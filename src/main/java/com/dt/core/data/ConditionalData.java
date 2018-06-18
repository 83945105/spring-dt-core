package com.dt.core.data;

import com.dt.core.bean.ConditionModel;
import com.dt.core.bean.OnModel;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/19.
 */
public class ConditionalData<T extends Model<T, TO, TC>, TO extends OnModel<TO, T>, TC extends ConditionModel<TC, T>> extends Data<T, TO, TC> {

    public ConditionalData(Data ownerData, Class<T> targetClass) {
        super(ownerData, targetClass);
    }
}
