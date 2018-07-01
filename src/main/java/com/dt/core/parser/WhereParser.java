package com.dt.core.parser;

import com.dt.core.data.LinkWhereData;
import com.dt.core.data.WhereData;

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

    private String parseWhereData(List<WhereData> whereDataList) {
        if (whereDataList == null || whereDataList.size() == 0) {
            return "";
        }
        StringBuilder sql = new StringBuilder(64);
        for (WhereData whereData : whereDataList) {
            sql.append(" and ")
                    .append(whereData.getOwnerAlias())
                    .append(".")
                    .append(whereData.getOwnerColumnName());
            switch (whereData.getWhereType()) {
                case IS_NULL:
                    sql.append(" is null ");
                    continue;
                case IS_NOT_NULL:
                    sql.append(" is not null ");
                    continue;
                case EQUAL:
                    sql.append(" = ? ");
                    continue;
                case NOT_EQUAL:
                    sql.append(" != ? ");
                    continue;
                case GREATER:
                    sql.append(" > ? ");
                    continue;
                case GREATER_EQUAL:
                    sql.append(" >= ? ");
                    continue;
                case LESS:
                    sql.append(" < ? ");
                    continue;
                case LESS_EQUAL:
                    sql.append(" <= ? ");
                    continue;
                case BETWEEN:
                    sql.append(" between ? and ? ");
                    continue;
                case LIKE:
                    sql.append(" like ? ");
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
            }
        }
        return sql.length() > 4 ? sql.substring(4) : "";
    }

    private String parseLinkWhereData(List<LinkWhereData> linkWhereDataList, boolean bracket) {
        if (linkWhereDataList == null || linkWhereDataList.size() == 0) {
            return "";
        }
        boolean hasOr = false;
        StringBuilder sql = new StringBuilder(128);
        for (LinkWhereData linkWhereData : linkWhereDataList) {
            List<WhereData> whereDataList = linkWhereData.getWhereDataList();
            List<LinkWhereData> list = linkWhereData.getLinkWhereDataList();
            if (whereDataList != null && whereDataList.size() > 0) {
                switch (linkWhereData.getLinkType()) {
                    case AND:
                        sql.append(" and ").append(parseWhereData(whereDataList));
                        continue;
                    case OR:
                        hasOr = true;
                        sql.append(" or ");
                        if (whereDataList.size() > 1) {
                            sql.append("(").append(parseWhereData(whereDataList)).append(")");
                        } else if (whereDataList.size() == 1) {
                            sql.append(parseWhereData(whereDataList));
                        }
                        continue;
                }
            } else if (list != null && list.size() > 0) {
                switch (linkWhereData.getLinkType()) {
                    case AND:
                        sql.append(" and ").append(parseLinkWhereData(list, true));
                        continue;
                    case OR:
                        hasOr = true;
                        if (list.size() > 1) {
                            sql.append(" or (").append(parseLinkWhereData(list, false)).append(")");
                            continue;
                        } else if(list.size() == 1) {
                            sql.append(" or ").append(parseLinkWhereData(list, false));
                            continue;
                        }

                }
            }
        }
        if (bracket && hasOr) {
            return sql.length() > 4 ? sql.replace(0, 4, "(").append(")").toString() : "";
        }
        return sql.length() > 4 ? sql.substring(4) : "";
    }

    public String parse(List<List<LinkWhereData>> linkWhereDataList) {
        if (linkWhereDataList == null || linkWhereDataList.size() == 0) {
            return "";
        }
        StringBuilder sql = new StringBuilder(256);
        for (List<LinkWhereData> linkWhereData : linkWhereDataList) {
            sql.append(" and ").append(parseLinkWhereData(linkWhereData, false));
        }
        return sql.length() > 4 ? sql.substring(4) : "";
    }

}
