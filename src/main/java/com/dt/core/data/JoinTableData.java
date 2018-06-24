package com.dt.core.data;

import com.dt.core.bean.*;
import com.dt.core.norm.Model;

import java.util.Objects;

/**
 * 表数据
 * Created by 白超 on 2018/6/24.
 */
public final class JoinTableData<T extends Model<T, TL, TO, TC, TS, TG>,
        TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
        TO extends OnModel<T, TL, TO, TC, TS, TG>,
        TC extends WhereModel<T, TL, TO, TC, TS, TG>,
        TS extends SortModel<T, TL, TO, TC, TS, TG>,
        TG extends GroupModel<T, TL, TO, TC, TS, TG>> {

    private String tableName;

    private String alias;

    private T table;

    private Class<T> tableClass;

    private String[] selectColumns;

    private JoinType joinType = JoinType.INNER;

    public JoinTableData(Class<T> tableClass) {
        this.tableClass = tableClass;
        try {
            this.table = tableClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        this.tableName = this.table.getTableName();
        this.alias = this.table.getAlias();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String[] getSelectColumns() {
        return selectColumns;
    }

    public T getTable() {
        return table;
    }

    public void setSelectColumns(String[] selectColumns) {
        this.selectColumns = selectColumns;
    }

    public JoinType getJoinType() {
        return joinType;
    }

    public void setJoinType(JoinType joinType) {
        this.joinType = joinType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoinTableData<?, ?, ?, ?, ?, ?> data = (JoinTableData<?, ?, ?, ?, ?, ?>) o;
        return Objects.equals(getAlias(), data.getAlias());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAlias());
    }
}
