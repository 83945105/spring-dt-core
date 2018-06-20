package com.dt.core.norm;

import com.dt.core.bean.ConditionModel;
import com.dt.core.bean.GroupModel;
import com.dt.core.bean.OnModel;
import com.dt.core.bean.SortModel;

/**
 * Created by 白超 on 2018/6/19.
 */
@FunctionalInterface
public interface Sort<T extends Model<T, TO, TC, TS, TG>,
        TO extends OnModel<T, TO, TC, TS, TG>,
        TC extends ConditionModel<T, TO, TC, TS, TG>,
        TS extends SortModel<T, TO, TC, TS, TG>,
        TG extends GroupModel<T, TO, TC, TS, TG>> {

    TS apply(TS table);
}
