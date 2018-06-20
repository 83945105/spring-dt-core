package com.dt.core.norm;

import com.dt.core.bean.*;

/**
 * 条件
 * Created by 白超 on 2018/6/17.
 */
@FunctionalInterface
public interface ConditionB<M extends Model<M, MO, MC, MS, MG>,
        MO extends OnModel<M, MO, MC, MS, MG>,
        MC extends ConditionModel<M, MO, MC, MS, MG>,
        MS extends SortModel<M, MO, MC, MS, MG>,
        MG extends GroupModel<M, MO, MC, MS, MG>,
        T extends Model<T, TO, TC, TS, TG>,
        TO extends OnModel<T, TO, TC, TS, TG>,
        TC extends ConditionModel<T, TO, TC, TS, TG>,
        TS extends SortModel<T, TO, TC, TS, TG>,
        TG extends GroupModel<T, TO, TC, TS, TG>> {

    /**
     * @param condition 连接条件
     * @param table     指定表条件
     * @param mainTable 主表的条件
     * @return
     */
    ConditionLink<M, MO, MC, MS, MG> apply(ConditionLink<M, MO, MC, MS, MG> condition, TC table, MC mainTable);
}
