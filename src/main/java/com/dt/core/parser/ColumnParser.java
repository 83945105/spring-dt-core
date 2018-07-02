package com.dt.core.parser;

import com.dt.core.data.TableData;
import com.dt.core.exception.TableDataException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 查询字段解析器
 * Created by 白超 on 2018/6/28.
 */
public class ColumnParser {

    private ColumnParser() {
    }

    private static final ColumnParser COLUMN_PARSER = new ColumnParser();

    public static ColumnParser getInstance() {
        return COLUMN_PARSER;
    }

    public String parse(Set<TableData> columnDataSet) {
        if (columnDataSet == null || columnDataSet.size() == 0) {
            return "*";
        }
        StringBuilder sql = new StringBuilder(32);
        Map<String, String> columnNames;
        Map<String, Boolean> cache = new HashMap<>();
        for (TableData tableData : columnDataSet) {
            columnNames = tableData.getSelectColumns();
            if (columnNames.size() == 0) {
                sql.append(" , ")
                        .append(tableData.getTableAlias())
                        .append(".")
                        .append("*");
                continue;
            }
            for (Map.Entry<String, String> entry : columnNames.entrySet()) {
                if (cache.get(entry.getValue()) != null) {
                    throw new TableDataException("table alias [" + tableData.getTableAlias() + "] column alias [" + entry.getValue() + "] is already be used, please set another alias.");
                }
                sql.append(" , ")
                        .append(tableData.getTableAlias())
                        .append(".")
                        .append(entry.getKey())
                        .append(" ").append(entry.getValue());
                cache.put(entry.getValue(), true);
            }
        }
        return sql.substring(3);
    }

}
