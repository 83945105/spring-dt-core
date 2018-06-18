package com.dt.core.norm;

import com.dt.core.bean.ConditionModel;
import com.dt.core.bean.OnModel;

/**
 * Created by 白超 on 2018/6/16.
 */
public interface Model<T, TO extends OnModel<TO, T>, TC extends ConditionModel<TC, T>> {

    String getTableName();

    OnModel<TO, T> getOn();

    ConditionModel<TC, T> getCondition();
}
