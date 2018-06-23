package com.dt.core.model;

import com.dt.core.bean.*;
import com.dt.core.norm.Data;
import com.dt.core.norm.Model;
import com.dt.core.norm.On;

/**
 * Created by 白超 on 2018/6/18.
 */
public abstract class JoinTool<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends ConditionModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> extends WhereTool<M, ML, MO, MC, MS, MG> {

    public JoinTool(Data<M, ML, MO, MC, MS, MG> data) {
        super(data);
    }

    public <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends ConditionModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> JoinTool<M, ML, MO, MC, MS, MG> join(Class<J> joinClass,
                                                                                               JoinType joinType,
                                                                                               On<JO, MO> on) {


        return this;
    }

}
