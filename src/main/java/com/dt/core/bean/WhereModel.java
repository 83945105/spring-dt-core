package com.dt.core.bean;

import com.dt.core.norm.Model;

public class WhereModel<T extends Model<T, TL, TO, TC, TS, TG>,
        TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
        TO extends OnModel<T, TL, TO, TC, TS, TG>,
        TC extends WhereModel<T, TL, TO, TC, TS, TG>,
        TS extends SortModel<T, TL, TO, TC, TS, TG>,
        TG extends GroupModel<T, TL, TO, TC, TS, TG>> {

    protected WhereBuilder<TC> whereBuilder = new WhereBuilder<>((TC) this);

    protected Class<T> owner;
}
