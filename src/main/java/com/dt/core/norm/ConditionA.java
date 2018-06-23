package com.dt.core.norm;

import com.dt.core.bean.*;

/**
 * 条件
 * Created by 白超 on 2018/6/17.
 */
@FunctionalInterface
public interface ConditionA<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends ConditionModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> {

    /**
     * @param condition 连接条件
     * @param mainTable 主表的条件
     * @return
     */
    ConditionLink<M, ML, MO, MC, MS, MG> apply(ConditionLink<M, ML, MO, MC, MS, MG> condition, MC mainTable);
}
