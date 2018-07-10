package com.dt.core.data;

/**
 * 分组数据
 *
 * @author 白超
 * @version 1.0
 * @since 2018/7/10
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
