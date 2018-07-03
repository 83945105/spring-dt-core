package com.dt.core.parser;

import com.dt.core.data.MainTableData;
import com.dt.core.data.TableData;
import com.dt.core.data.VirtualFieldData;
import com.dt.core.exception.DtException;
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

    public String parse(MainTableData mainTableData, Set<VirtualFieldData> virtualFieldDataSet, Set<TableData> columnDataSet) {
        boolean hasV = virtualFieldDataSet != null && virtualFieldDataSet.size() != 0;
        boolean hasC = columnDataSet != null && columnDataSet.size() != 0;
        if (!hasV && !hasC) {
            return "*";
        }
        StringBuilder sql = new StringBuilder(64);
        Map<String, Boolean> cache = new HashMap<>();
        if (hasV) {
            Object value;
            String alias;
            for (VirtualFieldData data : virtualFieldDataSet) {
                sql.append(", ");
                value = data.getValue();
                alias = data.getAlias();
                if (cache.get(alias) != null) {
                    throw new TableDataException("VirtualField alias [" + alias + "] is already be used, please set another alias.");
                }
                if (value == null) {
                    sql.append("null");
                } else if (value instanceof String) {
                    sql.append("'").append(value).append("'");
                } else if (value instanceof Integer) {
                    sql.append(value);
                } else if (value instanceof Long) {
                    sql.append(value);
                } else if (value instanceof Double) {
                    sql.append(value);
                } else {
                    throw new DtException("the VirtualFieldData value type is wrong.");
                }
                if (alias != null) {
                    sql.append(" ").append(alias);
                    cache.put(alias, true);
                } else {
                    cache.put(value + "", true);
                }
            }
        }

        if (!hasC) {
            sql.append(", ")
                    .append(mainTableData.getTableAlias())
                    .append(".")
                    .append("*");
            return sql.substring(2);
        }

        Map<String, String> columnNames;
        for (TableData tableData : columnDataSet) {
            columnNames = tableData.getSelectColumns();
            if (columnNames.size() == 0) {
                sql.append(", ")
                        .append(tableData.getTableAlias())
                        .append(".")
                        .append("*");
                continue;
            }
            for (Map.Entry<String, String> entry : columnNames.entrySet()) {
                if (cache.get(entry.getValue()) != null) {
                    throw new TableDataException("table alias [" + tableData.getTableAlias() + "] column alias [" + entry.getValue() + "] is already be used, please set another alias.");
                }
                sql.append(", ")
                        .append(tableData.getTableAlias())
                        .append(".")
                        .append(entry.getKey())
                        .append(" ").append(entry.getValue());
                cache.put(entry.getValue(), true);
            }
        }
        return sql.substring(2);
    }

}
