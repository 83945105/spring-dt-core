package com.dt.core.bean;

import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/19.
 */
public class SortModel<T extends Model<T, TL, TO, TC, TS, TG>,
        TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
        TO extends OnModel<T, TL, TO, TC, TS, TG>,
        TC extends WhereModel<T, TL, TO, TC, TS, TG>,
        TS extends SortModel<T, TL, TO, TC, TS, TG>,
        TG extends GroupModel<T, TL, TO, TC, TS, TG>> {

    protected SortBuilder<TS> sortBuilder = new SortBuilder<>((TS) this);

    public SortBuilder<TS> getSortBuilder() {
        return sortBuilder;
    }
}
