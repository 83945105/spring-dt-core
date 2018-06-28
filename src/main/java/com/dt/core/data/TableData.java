package com.dt.core.data;

import java.util.*;

/**
 * Created by 白超 on 2018/6/25.
 */
public abstract class TableData {

    protected String tableName;

    protected String alias;

    protected Set<String> selectColumns = new LinkedHashSet<>();

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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        if (alias == null || "".equals(alias.trim())) {
            return;
        }
        this.alias = alias;
    }

    public void addLinkWhereDataList(List<LinkWhereData> linkWhereDataList) {
        if (linkWhereDataList == null || linkWhereDataList.size() == 0) {
            return;
        }
        this.linkWhereDataList.addAll(linkWhereDataList);
    }

    public Set<String> getSelectColumns() {
        return selectColumns;
    }

    public void addSelectColumns(Collection<String> selectColumns) {
        if (selectColumns == null || selectColumns.size() == 0) {
            return;
        }
        this.selectColumns.addAll(selectColumns);
    }

    public void addSelectColumns(String[] selectColumns) {
        if (selectColumns == null || selectColumns.length == 0) {
            return;
        }
        for (String selectColumn : selectColumns) {
            this.selectColumns.add(selectColumn);
        }
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
        return Objects.equals(alias, tableData.alias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alias);
    }
}
