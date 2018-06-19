package com.dt.core.bean;

import com.dt.core.norm.Model;
import com.dt.core.norm.SortA;

/**
 * Created by 白超 on 2018/6/19.
 */
public final class SortLink<M extends Model<M, MO, MC, MS, MG>,
        MO extends OnModel<M, MO, MC, MS, MG>,
        MC extends ConditionModel<M, MO, MC, MS, MG>,
        MS extends SortModel<M, MO, MC, MS, MG>,
        MG extends GroupModel<M, MO, MC, MS, MG>> {

    public SortLink and(SortModel<M, MO, MC, MS, MG> sortModel) {
        return this;
    }

    public <T extends Model<T, TO, TC, TS, TG>,
            TO extends OnModel<T, TO, TC, TS, TG>,
            TC extends ConditionModel<T, TO, TC, TS, TG>,
            TS extends SortModel<T, TO, TC, TS, TG>,
            TG extends GroupModel<T, TO, TC, TS, TG>> SortLink and(Class<T> sortClass, SortA<T, TO, TC, TS, TG> sort) {

        return this;
    }

}
