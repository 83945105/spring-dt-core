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

    private String parseWhereData(List<WhereData> whereDataList, StringBuilder sql) {
        if (whereDataList == null || whereDataList.size() == 0) {
            return "";
        }
        sql.replace(0, sql.length(), "");
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
        return sql.replace(0, 4, "(").toString();
    }

    private String parseLinkWhereData(List<LinkWhereData> linkWhereDataList, StringBuilder sql) {
        if (linkWhereDataList == null || linkWhereDataList.size() == 0) {
            return "";
        }
        sql.replace(0, sql.length(), "");

        return sql.toString();
    }

    public String parse(List<List<LinkWhereData>> linkWhereDataList) {
        if (linkWhereDataList == null || linkWhereDataList.size() == 0) {
            return "";
        }
        StringBuilder sql = new StringBuilder(256);
        StringBuilder link = new StringBuilder(128);
        StringBuilder where = new StringBuilder(64);
        for (List<LinkWhereData> linkWhereData : linkWhereDataList) {
            link.replace(0, link.length(), "");
            sql.append(" and (");
            for (LinkWhereData linkWhereDatum : linkWhereData) {
                if (linkWhereDatum.getWhereDataList() != null) {
                    link.append(parseWhereData(linkWhereDatum.getWhereDataList(), where));
                    continue;
                }
                if (linkWhereDatum.getLinkWhereDataList() != null) {

                    continue;
                }
            }
            sql.append(link).append(")");
        }

        return sql.toString();
    }

}
