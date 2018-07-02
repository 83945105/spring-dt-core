package com.dt.core.data;

import java.util.*;

/**
 * Created by 白超 on 2018/6/25.
 */
public abstract class TableData {

    protected String tableName;

    protected String tableAlias;

    protected String primaryKeyName;

    protected String primaryKeyAlias;

    protected Map<String, String> selectColumns = new LinkedHashMap<>();

    protected List<LinkWhereData> linkWhereDataList = new ArrayList<>();

    protected List<String> groupColumns = new ArrayList<>();

    protected List<List<SortData>> sortDataList = new ArrayList<>();

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        if (tableName == null || "".equals(tableName.trim())) {
            return;
        }
        this.tableName = tableName;
    }

    public String getTableAlias() {
        return tableAlias;
    }

    public void setTableAlias(String tableAlias) {
        if (tableAlias == null || "".equals(tableAlias.trim())) {
            return;
        }
        this.tableAlias = tableAlias;
    }

    public String getPrimaryKeyName() {
        return primaryKeyName;
    }

    public void setPrimaryKeyName(String primaryKeyName) {
        if (primaryKeyName == null || "".equals(primaryKeyName)) {
            return;
        }
        this.primaryKeyName = primaryKeyName;
    }

    public String getPrimaryKeyAlias() {
        return primaryKeyAlias;
    }

    public void setPrimaryKeyAlias(String primaryKeyAlias) {
        if (primaryKeyAlias == null || "".equals(primaryKeyAlias)) {
            return;
        }
        this.primaryKeyAlias = primaryKeyAlias;
    }

    public List<LinkWhereData> getLinkWhereDataList() {
        return linkWhereDataList;
    }

    public void addLinkWhereDataList(List<LinkWhereData> linkWhereDataList) {
        if (linkWhereDataList == null || linkWhereDataList.size() == 0) {
            return;
        }
        this.linkWhereDataList.addAll(linkWhereDataList);
    }

    public Map<String, String> getSelectColumns() {
        return selectColumns;
    }

    public void addSelectColumns(String columnName, String alias) {
        this.selectColumns.put(columnName, alias);
    }

    public void addSelectColumns(Map<String, String> selectColumns) {
        this.selectColumns.putAll(selectColumns);
    }

    public List<String> getGroupColumns() {
        return groupColumns;
    }

    public void addGroupColumns(Collection<String> groupColumns) {
        if (groupColumns == null || groupColumns.size() == 0) {
            return;
        }
        this.groupColumns.addAll(groupColumns);
    }

    public void addGroupColumns(String[] groupColumns) {
        if (groupColumns == null || groupColumns.length == 0) {
            return;
        }
        for (String groupColumn : groupColumns) {
            this.groupColumns.add(groupColumn);
        }
    }

    public void addSortDataList(List<SortData> sortDataList) {
        if (sortDataList == null || sortDataList.size() == 0) {
            return;
        }
        this.sortDataList.add(sortDataList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableData tableData = (TableData) o;
        return Objects.equals(tableAlias, tableData.tableAlias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableAlias);
    }
}
