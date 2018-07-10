package com.dt.core.data;

import com.dt.core.bean.SortType;

/**
 * 排序数据
 *
 * @author 白超
 * @version 1.0
 * @since 2018/7/10
 */
public final class SortData {

    private TableData tableData;

    private String columnName;

    private SortType sortType = SortType.ASC;

    public TableData getTableData() {
        return tableData;
    }

    public void setTableData(TableData tableData) {
        this.tableData = tableData;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public SortType getSortType() {
        return sortType;
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
    }
}
