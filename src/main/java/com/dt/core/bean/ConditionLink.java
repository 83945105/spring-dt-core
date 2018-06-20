package com.dt.core.bean;

import com.dt.core.norm.ConditionA;
import com.dt.core.norm.ConditionB;
import com.dt.core.norm.Model;

/**
 * 条件
 * Created by 白超 on 2018/6/7.
 */
public final class ConditionLink<M extends Model<M, MO, MC, MS, MG>,
        MO extends OnModel<M, MO, MC, MS, MG>,
        MC extends ConditionModel<M, MO, MC, MS, MG>,
        MS extends SortModel<M, MO, MC, MS, MG>,
        MG extends GroupModel<M, MO, MC, MS, MG>> {

    public ConditionLink<M, MO, MC, MS, MG> and(ConditionModel<?, ?, ?, ?, ?> conditionModel) {
        return this;
    }

    public ConditionLink<M, MO, MC, MS, MG> or(ConditionModel<?, ?, ?, ?, ?> conditionModel) {
        return this;
    }

    public ConditionLink<M, MO, MC, MS, MG> and(ConditionA<M, MO, MC, MS, MG> condition) {
        return this;
    }

    public <T extends Model<T, TO, TC, TS, TG>,
            TO extends OnModel<T, TO, TC, TS, TG>,
            TC extends ConditionModel<T, TO, TC, TS, TG>,
            TS extends SortModel<T, TO, TC, TS, TG>,
            TG extends GroupModel<T, TO, TC, TS, TG>> ConditionLink<M, MO, MC, MS, MG> and(Class<T> conditionClass, ConditionB<M, MO, MC, MS, MG, T, TO, TC, TS, TG> condition) {
        return and(conditionClass, null, condition);
    }

    public <T extends Model<T, TO, TC, TS, TG>,
            TO extends OnModel<T, TO, TC, TS, TG>,
            TC extends ConditionModel<T, TO, TC, TS, TG>,
            TS extends SortModel<T, TO, TC, TS, TG>,
            TG extends GroupModel<T, TO, TC, TS, TG>> ConditionLink<M, MO, MC, MS, MG> and(Class<T> conditionClass, String alias, ConditionB<M, MO, MC, MS, MG, T, TO, TC, TS, TG> condition) {
        return this;
    }

    public ConditionLink<M, MO, MC, MS, MG> or(ConditionA<M, MO, MC, MS, MG> condition) {
        return this;
    }

    public <T extends Model<T, TO, TC, TS, TG>,
            TO extends OnModel<T, TO, TC, TS, TG>,
            TC extends ConditionModel<T, TO, TC, TS, TG>,
            TS extends SortModel<T, TO, TC, TS, TG>,
            TG extends GroupModel<T, TO, TC, TS, TG>> ConditionLink<M, MO, MC, MS, MG> or(Class<T> conditionClass, ConditionB<M, MO, MC, MS, MG, T, TO, TC, TS, TG> condition) {
        return or(conditionClass, null, condition);
    }

    public <T extends Model<T, TO, TC, TS, TG>,
            TO extends OnModel<T, TO, TC, TS, TG>,
            TC extends ConditionModel<T, TO, TC, TS, TG>,
            TS extends SortModel<T, TO, TC, TS, TG>,
            TG extends GroupModel<T, TO, TC, TS, TG>> ConditionLink<M, MO, MC, MS, MG> or(Class<T> conditionClass, String alias, ConditionB<M, MO, MC, MS, MG, T, TO, TC, TS, TG> condition) {
        return this;
    }

    public enum ConditionLinkType {
        AND,
        OR
    }

}
