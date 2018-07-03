package com.dt.core.data;

import java.util.List;

/**
 * Created by 白超 on 2018/7/3.
 */
public class ParseData {

    private String sql;

    private List<Object> args;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public List<Object> getArgs() {
        return args;
    }

    public void setArgs(List<Object> args) {
        this.args = args;
    }
}
