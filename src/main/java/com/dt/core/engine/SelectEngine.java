package com.dt.core.engine;

/**
 * Created by 白超 on 2018/7/3.
 */
public class SelectEngine {

    public String selectByPrimaryKey(ColumnEngine columnEngine) {
        return new StringBuilder(36)
                .append("select ")
                .append(columnEngine.getColumnSql())
                .append(" from ")
                .append(columnEngine.getTableName())
                .append(" ")
                .append(columnEngine.getTableAlias())
                .append(" where ")
                .append(columnEngine.getTableAlias())
                .append(".")
                .append(columnEngine.getPrimaryKeyName())
                .append(" = ?").toString();
    }

}
