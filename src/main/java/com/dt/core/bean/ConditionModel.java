package com.dt.core.bean;

import com.dt.core.norm.Model;

public class ConditionModel<T extends Model<T, TO, TC, TS, TG>,
        TO extends OnModel<T, TO, TC, TS, TG>,
        TC extends ConditionModel<T, TO, TC, TS, TG>,
        TS extends SortModel<T, TO, TC, TS, TG>,
        TG extends GroupModel<T, TO, TC, TS, TG>> {

    protected ConditionBuilder<TC> conditionBuilder = new ConditionBuilder<>((TC) this);

    protected Class<T> owner;
}
