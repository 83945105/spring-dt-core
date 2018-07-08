package com.dt.core.bean;

import com.dt.core.norm.Model;

import java.util.*;

/**
 * Created by 白超 on 2018/6/23.
 */
public class ColumnModel<T extends Model<T, TL, TO, TC, TS, TG>,
        TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
        TO extends OnModel<T, TL, TO, TC, TS, TG>,
        TC extends WhereModel<T, TL, TO, TC, TS, TG>,
        TS extends SortModel<T, TL, TO, TC, TS, TG>,
        TG extends GroupModel<T, TL, TO, TC, TS, TG>> {

    protected Map<String, String> columnAliasMap = new LinkedHashMap<>();

    public Map<String, String> getColumnAliasMap() {
        return columnAliasMap;
    }

    public ColumnModel<T, TL, TO, TC, TS, TG> addColumnAlias(String column, String alias) {
        this.columnAliasMap.put(column, alias);
        return this;
    }
}
