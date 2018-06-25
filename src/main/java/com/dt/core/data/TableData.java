package com.dt.core.data;

/**
 * Created by 白超 on 2018/6/25.
 */
public abstract class TableData {

    protected String tableName;

    protected String alias;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

}
