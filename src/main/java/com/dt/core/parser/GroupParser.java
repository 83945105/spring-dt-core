package com.dt.core.parser;

import com.dt.core.data.GroupData;

import java.util.List;

/**
 * Created by 白超 on 2018/7/2.
 */
public class GroupParser {

    private GroupParser() {
    }

    private static final GroupParser GROUP_PARSER = new GroupParser();

    public static GroupParser getInstance() {
        return GROUP_PARSER;
    }

    public String parse(List<GroupData> groupDataList) {
        if (groupDataList == null || groupDataList.size() == 0) {
            return null;
        }
        StringBuilder sql = new StringBuilder(64);
        String alias;
        for (GroupData groupData : groupDataList) {
            alias = groupData.getTableData().getTableAlias();
            for (String columnName : groupData.getColumnNames()) {
                sql.append(", ").append(alias).append(".").append(columnName);
            }
        }
        return sql.length() > 2 ? sql.replace(0, 2, "group by ").toString() : null;
    }
}
