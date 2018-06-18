package com.dt.core.model;

import com.dt.core.bean.ConditionModel;
import com.dt.core.bean.OnModel;
import com.dt.core.data.ToolData;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/18.
 */
public abstract class GroupTool<M extends Model<M, MO, MC>, MO extends OnModel<MO, M>, MC extends ConditionModel<MC, M>> extends SortTool<M, MO, MC> {

    public GroupTool(ToolData<M, MO, MC> toolData) {
        super(toolData);
    }

    public GroupTool<M, MO, MC> group() {

        return this;
    }

}
