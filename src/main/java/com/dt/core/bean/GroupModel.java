package com.dt.core.bean;

import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/19.
 */
public class GroupModel<T extends Model<T, TO, TC, TS, TG>,
        TO extends OnModel<T, TO, TC, TS, TG>,
        TC extends ConditionModel<T, TO, TC, TS, TG>,
        TS extends SortModel<T, TO, TC, TS, TG>,
        TG extends GroupModel<T, TO, TC, TS, TG>> {

    protected GroupBuilder<TG> groupBuilder = new GroupBuilder<TG>((TG) this);

}
