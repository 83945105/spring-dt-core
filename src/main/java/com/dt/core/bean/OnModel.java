package com.dt.core.bean;

import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/16.
 */
public class OnModel<T extends Model<T, TL, TO, TC, TS, TG>,
        TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
        TO extends OnModel<T, TL, TO, TC, TS, TG>,
        TC extends ConditionModel<T, TL, TO, TC, TS, TG>,
        TS extends SortModel<T, TL, TO, TC, TS, TG>,
        TG extends GroupModel<T, TL, TO, TC, TS, TG>> {

    protected OnBuilder<TO> onBuilder = new OnBuilder<>((TO) this);

    protected Class<T> owner;
}
