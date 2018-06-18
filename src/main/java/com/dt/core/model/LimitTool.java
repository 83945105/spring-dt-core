package com.dt.core.model;

import com.dt.core.bean.ConditionModel;
import com.dt.core.data.ToolData;
import com.dt.core.bean.OnModel;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/18.
 */
public abstract class LimitTool<M extends Model<M, MO, MC>, MO extends OnModel<MO, M>, MC extends ConditionModel<MC, M>> {

    protected ToolData<M, MO, MC> toolData;

    public LimitTool(ToolData<M, MO, MC> toolData) {
        this.toolData = toolData;
    }

    public LimitTool<M, MO, MC> limit() {

        return this;
    }

}
