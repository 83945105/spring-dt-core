package com.dt.core.model;

import com.dt.core.bean.ConditionModel;
import com.dt.core.bean.GroupModel;
import com.dt.core.bean.OnModel;
import com.dt.core.bean.SortModel;
import com.dt.core.norm.Data;
import com.dt.core.norm.Model;
import com.dt.core.norm.Sort;

/**
 * Created by 白超 on 2018/6/18.
 */
public abstract class SortTool<M extends Model<M, MO, MC, MS, MG>,
        MO extends OnModel<M, MO, MC, MS, MG>,
        MC extends ConditionModel<M, MO, MC, MS, MG>,
        MS extends SortModel<M, MO, MC, MS, MG>,
        MG extends GroupModel<M, MO, MC, MS, MG>> extends LimitTool<M, MO, MC, MS, MG> {

    public SortTool(Data<M, MO, MC, MS, MG> data) {
        super(data);
    }

    public SortTool<M, MO, MC, MS, MG> sort(Sort<M, MO, MC, MS, MG> sort) {

        return this;
    }

    public <T extends Model<T, TO, TC, TS, TG>,
            TO extends OnModel<T, TO, TC, TS, TG>,
            TC extends ConditionModel<T, TO, TC, TS, TG>,
            TS extends SortModel<T, TO, TC, TS, TG>,
            TG extends GroupModel<T, TO, TC, TS, TG>> SortTool<M, MO, MC, MS, MG> sort(Class<T> sortClass, Sort<T, TO, TC, TS, TG> sort) {
        return sort(sortClass, null, sort);
    }

    public <T extends Model<T, TO, TC, TS, TG>,
            TO extends OnModel<T, TO, TC, TS, TG>,
            TC extends ConditionModel<T, TO, TC, TS, TG>,
            TS extends SortModel<T, TO, TC, TS, TG>,
            TG extends GroupModel<T, TO, TC, TS, TG>> SortTool<M, MO, MC, MS, MG> sort(Class<T> sortClass, String alias, Sort<T, TO, TC, TS, TG> sort) {

        return this;
    }

}
