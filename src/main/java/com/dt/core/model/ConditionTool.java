package com.dt.core.model;

import com.dt.core.bean.*;
import com.dt.core.data.ConditionData;
import com.dt.core.norm.Condition;
import com.dt.core.norm.Data;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/18.
 */
public abstract class ConditionTool<M extends Model<M, MO, MC, MS, MG>,
        MO extends OnModel<M, MO, MC, MS, MG>,
        MC extends ConditionModel<M, MO, MC, MS, MG>,
        MS extends SortModel<M, MO, MC, MS, MG>,
        MG extends GroupModel<M, MO, MC, MS, MG>> extends GroupTool<M, MO, MC, MS, MG> {

    public ConditionTool(Data<M, MO, MC, MS, MG> data) {
        super(data);
    }

    public ConditionTool<M, MO, MC, MS, MG> condition(Condition<MC> condition) {
        return this;
    }

    public <T extends Model<T, TO, TC, TS, TG>,
            TO extends OnModel<T, TO, TC, TS, TG>,
            TC extends ConditionModel<T, TO, TC, TS, TG>,
            TS extends SortModel<T, TO, TC, TS, TG>,
            TG extends GroupModel<T, TO, TC, TS, TG>> ConditionTool<M, MO, MC, MS, MG> condition(Class<T> conditionClass, Condition<TC> condition) {
        return condition(conditionClass, null, condition);
    }

    public <T extends Model<T, TO, TC, TS, TG>,
            TO extends OnModel<T, TO, TC, TS, TG>,
            TC extends ConditionModel<T, TO, TC, TS, TG>,
            TS extends SortModel<T, TO, TC, TS, TG>,
            TG extends GroupModel<T, TO, TC, TS, TG>> ConditionTool<M, MO, MC, MS, MG> condition(Class<T> conditionClass, String alias, Condition<TC> condition) {
        return this;
    }

}
