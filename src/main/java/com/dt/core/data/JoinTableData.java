package com.dt.core.data;

import com.dt.core.bean.*;
import com.dt.core.norm.Model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 表数据
 * Created by 白超 on 2018/6/24.
 */
public final class JoinTableData<T extends Model<T, TL, TO, TC, TS, TG>,
        TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
        TO extends OnModel<T, TL, TO, TC, TS, TG>,
        TC extends WhereModel<T, TL, TO, TC, TS, TG>,
        TS extends SortModel<T, TL, TO, TC, TS, TG>,
        TG extends GroupModel<T, TL, TO, TC, TS, TG>> extends TableData {

    private T table;

    private Class<T> tableClass;

    private JoinType joinType = JoinType.INNER;

    private Map<OnType, List<OnData>> onDataMap = new LinkedHashMap<>();

    public void addOnDataMap(Map<OnType, List<OnData>> onDataMap) {
        onDataMap.putAll(onDataMap);
    }

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

    public T getTable() {
        return table;
    }

    public JoinType getJoinType() {
        return joinType;
    }

    public void setJoinType(JoinType joinType) {
        this.joinType = joinType;
    }

}
