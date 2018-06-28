package com.dt.core.parser;

import com.dt.core.data.TableData;

import java.util.Set;

/**
 * 查询字段解析器
 * Created by 白超 on 2018/6/28.
 */
public class SelectColumnParser {

    private SelectColumnParser() {
    }

    public static final SelectColumnParser COLUMN_PARSER = new SelectColumnParser();

    public SelectColumnParser getInstance() {
        return COLUMN_PARSER;
    }

    private Set<TableData> columnDataSet;

    public static String parse(Set<TableData> columnDataSet) {
        if (columnDataSet == null || columnDataSet.size() == 0) {
            return " * ";
        }
        StringBuilder sql = new StringBuilder(64);
        for (TableData tableData : columnDataSet) {

            tableData.getSelectColumns();


        }


        return "";
    }

}
