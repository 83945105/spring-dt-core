package com.dt.core.model;

import com.dt.core.bean.ConditionModel;
import com.dt.core.bean.JoinType;
import com.dt.core.bean.OnModel;
import com.dt.core.data.ToolData;
import com.dt.core.norm.Model;
import com.dt.core.norm.On;

/**
 * Created by 白超 on 2018/6/18.
 */
public abstract class JoinTool<M extends Model<M, MO, MC>, MO extends OnModel<MO, M>, MC extends ConditionModel<MC, M>> extends ConditionTool<M, MO, MC> {

    public JoinTool(ToolData<M, MO, MC> toolData) {
        super(toolData);
    }

    public <J extends Model<J, JO, JC>,
            JO extends OnModel<JO, J>,
            JC extends ConditionModel<JC, J>> JoinTool<M, MO, MC> join(Class<J> joinClass,
                                                                       JoinType joinType,
                                                                       On<JO, MO> on) {


        return this;
    }

}
