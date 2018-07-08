package com.dt.core.norm;

import com.dt.core.data.ParseData;

import java.util.Map;

/**
 * Created by 白超 on 2018/7/3.
 */
public interface Engine {

    default Class getTableClass() {
        return null;
    }

    default String getTableName() {
        return null;
    }

    default String getTableAlias() {
        return null;
    }

    default String getPrimaryKeyName() {
        return null;
    }

    default String getPrimaryKeyAlias() {
        return null;
    }

    default Map<String, String> getColumnAliasMap() {
        return null;
    }

    default String getColumnSql() {
        return null;
    }

    default ParseData getJoinParseData() {
        return null;
    }

    default ParseData getWhereParseData() {
        return null;
    }

    default String getGroupSql() {
        return null;
    }

    default String getSortSql() {
        return null;
    }

    default ParseData getLimitParseData() {
        return null;
    }

}
