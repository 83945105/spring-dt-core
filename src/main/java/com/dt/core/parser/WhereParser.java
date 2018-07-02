package com.dt.core.parser;

import com.dt.core.bean.LinkType;
import com.dt.core.data.LinkWhereData;
import com.dt.core.data.WhereData;
import com.dt.core.exception.ComparisonException;
import com.dt.core.exception.DtException;

import java.util.List;

/**
 * Created by 白超 on 2018/6/29.
 */
public class WhereParser {

    private WhereParser() {
    }

    private static final WhereParser WHERE_PARSER = new WhereParser();

    public static WhereParser getInstance() {
        return WHERE_PARSER;
    }

    private String parseWhereData(List<WhereData> whereDataList, LinkType ownerLinkType) {
        if (whereDataList == null || whereDataList.size() == 0) {
            return null;
        }
        StringBuilder sql = new StringBuilder(64);
        for (WhereData whereData : whereDataList) {
            sql.append(" and ")
                    .append(whereData.getOwnerAlias())
                    .append(".")
                    .append(whereData.getOwnerColumnName());
            switch (whereData.getWhereType()) {
                case IS_NULL:
                    sql.append(" is null");
                    continue;
                case IS_NOT_NULL:
                    sql.append(" is not null");
                    continue;
                case EQUAL:
                    sql.append(" = ?");
                    continue;
                case NOT_EQUAL:
                    sql.append(" != ?");
                    continue;
                case GREATER:
                    sql.append(" > ?");
                    continue;
                case GREATER_EQUAL:
                    sql.append(" >= ?");
                    continue;
                case LESS:
                    sql.append(" < ?");
                    continue;
                case LESS_EQUAL:
                    sql.append(" <= ?");
                    continue;
                case BETWEEN:
                    sql.append(" between ? and ?");
                    continue;
                case LIKE:
                    sql.append(" like ?");
                    continue;
                case IN:
                    int count = whereData.getValueCount();
                    sql.append(" in (");
                    for (; count > 0; count--) {
                        if (count == 1) {
                            sql.append("?");
                        } else {
                            sql.append("?,");
                        }
                    }
                    sql.append(")");
                    continue;
                default:
                    throw new DtException("the WhereType is wrong.");
            }
        }
        switch (ownerLinkType) {
            case AND:
                return sql.length() > 4 ? sql.substring(5) : null;
            case OR:
                if (whereDataList.size() > 1) {
                    return sql.length() > 4 ? sql.replace(0, 5, "(").append(")").toString() : null;
                }
                return sql.length() > 4 ? sql.substring(5) : null;
            default:
                return null;
        }
    }

    private String parseLinkWhereData(List<LinkWhereData> linkWhereDataList, LinkType ownerLinkType) {
        if (linkWhereDataList == null || linkWhereDataList.size() == 0) {
            return null;
        }
        String str;
        int i = 0;
        int orCount = 0;
        StringBuilder sql = new StringBuilder(128);
        for (LinkWhereData linkWhereData : linkWhereDataList) {
            List<WhereData> whereDataList = linkWhereData.getWhereDataList();
            List<LinkWhereData> list = linkWhereData.getLinkWhereDataList();
            if (whereDataList != null && whereDataList.size() > 0) {
                switch (linkWhereData.getLinkType()) {
                    case AND:
                        str = parseWhereData(whereDataList, LinkType.AND);
                        if (str != null) {
                            sql.append(" and ").append(str);
                            i++;
                        }
                        continue;
                    case OR:
                        str = parseWhereData(whereDataList, LinkType.OR);
                        if (str != null) {
                            sql.append(" or ").append(str);
                            i++;
                            orCount++;
                        }
                        continue;
                }
            } else if (list != null && list.size() > 0) {
                switch (linkWhereData.getLinkType()) {
                    case AND:
                        str = parseLinkWhereData(list, LinkType.AND);
                        if (str != null) {
                            sql.append(" and ").append(str);
                            i++;
                        }
                        continue;
                    case OR:
                        str = parseLinkWhereData(list, LinkType.OR);
                        if (str != null) {
                            sql.append(" or ").append(str);
                            i++;
                            orCount++;
                        }
                        continue;
                }
            }
        }
        switch (ownerLinkType) {
            case AND:
                if (orCount > 0) {
                    return sql.length() > 4 ? sql.replace(0, 5, "(").append(")").toString() : null;
                }
                return sql.length() > 4 ? sql.substring(5) : null;
            case OR:
                if (i > 1) {
                    return sql.length() > 4 ? sql.replace(0, 5, "(").append(")").toString() : null;
                }
                return sql.length() > 4 ? sql.substring(5) : null;
            default:
                return null;
        }
    }

    public String parse(List<List<LinkWhereData>> linkWhereDataList) {
        if (linkWhereDataList == null || linkWhereDataList.size() == 0) {
            return "";
        }
        StringBuilder sql = new StringBuilder(256);
        String str;
        for (List<LinkWhereData> linkWhereData : linkWhereDataList) {
            str = parseLinkWhereData(linkWhereData, LinkType.AND);
            if (str != null) {
                sql.append(" and ").append(str);
            }
        }
        return sql.length() > 5 ? sql.substring(5) : "";
    }

}
