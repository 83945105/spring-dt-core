package com.dt.core.bean;

import com.dt.core.norm.Model;

public class ConditionModel<T extends Model<T, TL, TO, TC, TS, TG>,
        TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
        TO extends OnModel<T, TL, TO, TC, TS, TG>,
        TC extends ConditionModel<T, TL, TO, TC, TS, TG>,
        TS extends SortModel<T, TL, TO, TC, TS, TG>,
        TG extends GroupModel<T, TL, TO, TC, TS, TG>> {

    protected ConditionBuilder<TC> conditionBuilder = new ConditionBuilder<>((TC) this);

    protected Class<T> owner;
}
