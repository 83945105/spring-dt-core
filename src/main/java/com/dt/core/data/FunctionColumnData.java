package com.dt.core.data;

import com.dt.core.bean.FunctionColumnType;

import java.util.Map;

/**
 * 函数列数据
 *
 * @author 白超
 * @version 1.0
 * @see
 * @since 2018/7/13
 */
public final class FunctionColumnData {

    private TableData tableData;

    private FunctionColumnType functionColumnType;

    private Map<String, String> columnAliasMap;

    public FunctionColumnData(TableData tableData, FunctionColumnType functionColumnType, Map<String, String> columnAliasMap) {
        this.tableData = tableData;
        this.functionColumnType = functionColumnType;
        this.columnAliasMap = columnAliasMap;
    }

    public TableData getTableData() {
        return tableData;
    }

    public void setTableData(TableData tableData) {
        this.tableData = tableData;
    }

    public FunctionColumnType getFunctionColumnType() {
        return functionColumnType;
    }

    public void setFunctionColumnType(FunctionColumnType functionColumnType) {
        this.functionColumnType = functionColumnType;
    }

    public Map<String, String> getColumnAliasMap() {
        return columnAliasMap;
    }

    public void setColumnAliasMap(Map<String, String> columnAliasMap) {
        this.columnAliasMap = columnAliasMap;
    }
}
