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

    protected Set<String> columns = new LinkedHashSet<>();

    public Set<String> getColumns() {
        return columns;
    }
}
