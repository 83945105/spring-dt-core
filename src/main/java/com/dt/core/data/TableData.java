package com.dt.core.data;

import com.dt.core.bean.*;
import com.dt.core.norm.Model;

import java.util.*;

/**
 * Created by 白超 on 2018/6/25.
 */
public abstract class TableData<T extends Model<T, TL, TO, TC, TS, TG>,
        TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
        TO extends OnModel<T, TL, TO, TC, TS, TG>,
        TC extends WhereModel<T, TL, TO, TC, TS, TG>,
        TS extends SortModel<T, TL, TO, TC, TS, TG>,
        TG extends GroupModel<T, TL, TO, TC, TS, TG>> {

    private T table;

    protected Class tableClass;

    protected String tableName;

    protected String tableAlias;

    protected String primaryKeyName;

    protected String primaryKeyAlias;

    protected Map<String, String> columnAliasMap = new LinkedHashMap<>();

    protected List<LinkWhereData> linkWhereDataList = new ArrayList<>();

    protected List<String> groupColumns = new ArrayList<>();

    protected List<List<SortData>> sortDataList = new ArrayList<>();

    public TableData(Class<T> tableClass) {
        this.tableClass = tableClass;
        try {
            this.table = tableClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        this.tableName = this.table.getTableName();
        this.tableAlias = this.table.getTableAlias();
        this.primaryKeyName = this.table.getPrimaryKeyName();
        this.primaryKeyAlias = this.table.getPrimaryKeyAlias();
    }

    public T getTable() {
        return this.table;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        if (tableName == null || "".equals(tableName.trim())) {
            return;
        }
        this.tableName = tableName;
    }

    public String getTableAlias() {
        return this.tableAlias;
    }

    public void setTableAlias(String tableAlias) {
        if (tableAlias == null || "".equals(tableAlias.trim())) {
            return;
        }
        this.tableAlias = tableAlias;
    }

    public String getPrimaryKeyName() {
        return this.primaryKeyName;
    }

    public void setPrimaryKeyName(String primaryKeyName) {
        if (primaryKeyName == null || "".equals(primaryKeyName)) {
            return;
        }
        this.primaryKeyName = primaryKeyName;
    }

    public String getPrimaryKeyAlias() {
        return this.primaryKeyAlias;
    }

    public void setPrimaryKeyAlias(String primaryKeyAlias) {
        if (primaryKeyAlias == null || "".equals(primaryKeyAlias)) {
            return;
        }
        this.primaryKeyAlias = primaryKeyAlias;
    }

    public List<LinkWhereData> getLinkWhereDataList() {
        return this.linkWhereDataList;
    }

    public void addLinkWhereDataList(List<LinkWhereData> linkWhereDataList) {
        if (linkWhereDataList == null || linkWhereDataList.size() == 0) {
            return;
        }
        this.linkWhereDataList.addAll(linkWhereDataList);
    }

    public Map<String, String> getColumnAliasMap() {
        return this.columnAliasMap;
    }

    public void addColumnAlias(String columnName, String alias) {
        this.columnAliasMap.put(columnName, alias);
    }

    public void addColumnAliasMap(Map<String, String> selectColumns) {
        this.columnAliasMap.putAll(selectColumns);
    }

    public List<String> getGroupColumns() {
        return this.groupColumns;
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

    public Class getTableClass() {
        return this.tableClass;
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
