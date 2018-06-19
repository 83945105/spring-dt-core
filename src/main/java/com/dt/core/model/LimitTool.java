package com.dt.core.model;

import com.dt.core.bean.ConditionModel;
import com.dt.core.bean.GroupModel;
import com.dt.core.bean.OnModel;
import com.dt.core.bean.SortModel;
import com.dt.core.norm.Data;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/18.
 */
public abstract class LimitTool<M extends Model<M, MO, MC, MS, MG>,
        MO extends OnModel<M, MO, MC, MS, MG>,
        MC extends ConditionModel<M, MO, MC, MS, MG>,
        MS extends SortModel<M, MO, MC, MS, MG>,
        MG extends GroupModel<M, MO, MC, MS, MG>> {

    protected Data<M, MO, MC, MS, MG> data;

    public LimitTool(Data<M, MO, MC, MS, MG> data) {
        this.data = data;
    }

    public LimitTool<M, MO, MC, MS, MG> limit(int start, Integer end) {
        data.setLimit(start, end);
        return this;
    }

    public LimitTool<M, MO, MC, MS, MG> limit(int start) {
        return limit(start, null);
    }

}
