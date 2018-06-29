package com.dt.core.parser;

import com.dt.core.bean.LinkType;
import com.dt.core.data.JoinTableData;
import com.dt.core.data.OnData;

import java.util.List;
import java.util.Map;

/**
 * Created by 白超 on 2018/6/29.
 */
public class JoinParser {

    private JoinParser() {
    }

    private static final JoinParser JOIN_PARSER = new JoinParser();

    public static JoinParser getInstance() {
        return JOIN_PARSER;
    }

    public String parse(Map<String, JoinTableData> joinTableDataAliasMap) {
        if (joinTableDataAliasMap == null || joinTableDataAliasMap.size() == 0) {
            return "";
        }
        StringBuilder sql = new StringBuilder(64);
        StringBuilder onSql = new StringBuilder(64);
        StringBuilder on = new StringBuilder(32);
        JoinTableData joinTableData;
        for (Map.Entry<String, JoinTableData> entry : joinTableDataAliasMap.entrySet()) {
            joinTableData = entry.getValue();
            switch (joinTableData.getJoinType()) {
                case INNER:
                    sql.append(", inner join ");
                    break;
                case LEFT:
                    sql.append(", left join ");
                    break;
                case RIGHT:
                    sql.append(", right join ");
                    break;
            }
            sql.append(joinTableData.getTableName()).append(" ").append(joinTableData.getAlias());
            Map<LinkType, List<OnData>> onDataMap = joinTableData.getLinkOnDataMap();
            if (onDataMap != null && onDataMap.size() > 0) {
                onSql.replace(0, onSql.length(), "");
                on.replace(0, on.length(), "");
                sql.append(" on ");
                for (Map.Entry<LinkType, List<OnData>> onEntry : onDataMap.entrySet()) {
                    switch (onEntry.getKey()) {
                        case AND:
                            onSql.append(" and ");
                            break;
                        case OR:
                            onSql.append(" or ");
                            break;
                    }
                    for (OnData onData : onEntry.getValue()) {
                        on.append(" and ")
                                .append(joinTableData.getAlias())
                                .append(".")
                                .append(onData.getOwnerColumnName());
                        switch (onData.getOnType()) {
                            case IS_NULL:
                                on.append(" is null ");
                                continue;
                            case IS_NOT_NULL:
                                on.append(" is not null ");
                                continue;
                            case EQUAL:
                                on.append(" = ");
                                break;
                            case NOT_EQUAL:
                                on.append(" != ");
                                break;
                            case GREATER:
                                on.append(" > ");
                                break;
                            case GREATER_EQUAL:
                                on.append(" >= ");
                                break;
                            case LESS:
                                on.append(" < ");
                                break;
                            case LESS_EQUAL:
                                on.append(" <= ");
                                break;
                            case BETWEEN:
                                on.append(" between ? and ? ");
                                continue;
                            case LIKE:
                                on.append(" like ? ");
                                continue;
                            case IN:
                                int count = onData.getValueCount();
                                on.append(" in (");
                                for (; count > 0; count--) {
                                    if (count == 1) {
                                        on.append("?");
                                    } else {
                                        on.append("?,");
                                    }
                                }
                                on.append(")");
                                continue;
                        }
                        switch (onData.getOnValueType()) {
                            case VALUE:
                                on.append("? ");
                                continue;
                            case JOIN:
                                on.append(onData.getTargetAlias())
                                        .append(".")
                                        .append(onData.getTargetColumnName());
                                continue;
                        }

                    }
                    onSql.append(on.substring(4)).append(" ");
                }
                sql.append(onSql.substring(4));
            }
        }
        return sql.substring(1);
    }

}