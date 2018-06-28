package com.dt.core.data;

/**
 * Created by 白超 on 2018/6/28.
 */
public final class GroupData {

    private TableData tableData;

    private String[] columnNames;

    public GroupData(TableData tableData, String[] columnNames) {
        this.tableData = tableData;
        this.columnNames = columnNames;
    }

    public TableData getTableData() {
        return tableData;
    }

    public String[] getColumnNames() {
        return columnNames;
    }
}
