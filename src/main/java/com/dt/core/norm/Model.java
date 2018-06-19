package com.dt.core.norm;

import com.dt.core.bean.ConditionModel;
import com.dt.core.bean.GroupModel;
import com.dt.core.bean.OnModel;
import com.dt.core.bean.SortModel;

/**
 * Created by 白超 on 2018/6/16.
 */
public interface Model<T extends Model<T, TO, TC, TS, TG>,
        TO extends OnModel<T, TO, TC, TS, TG>,
        TC extends ConditionModel<T, TO, TC, TS, TG>,
        TS extends SortModel<T, TO, TC, TS, TG>,
        TG extends GroupModel<T, TO, TC, TS, TG>> {

    String getTableName();

    String getAlias();

    OnModel<T, TO, TC, TS, TG> getOn();

    ConditionModel<T, TO, TC, TS, TG> getCondition();

    SortModel<T, TO, TC, TS, TG> getSort();

    GroupModel<T, TO, TC, TS, TG> getGroup();
}
