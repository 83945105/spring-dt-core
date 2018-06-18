package com.dt.core.model;

import com.dt.core.bean.ConditionLink;
import com.dt.core.bean.ConditionModel;
import com.dt.core.bean.OnModel;
import com.dt.core.data.ConditionData;
import com.dt.core.data.ToolData;
import com.dt.core.norm.Condition;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/18.
 */
public abstract class ConditionTool<M extends Model<M, MO, MC>, MO extends OnModel<MO, M>, MC extends ConditionModel<MC, M>> extends GroupTool<M, MO, MC> {

    public ConditionTool(ToolData<M, MO, MC> toolData) {
        super(toolData);
    }

    public ConditionTool<M, MO, MC> condition(Condition<MC> condition) {
        this.toolData.addConditionLink(condition.apply(new ConditionLink(), this.toolData.getTargetCondition()));
        return this;
    }

    public <T extends Model<T, TO, TC>,
            TO extends OnModel<TO, T>,
            TC extends ConditionModel<TC, T>> ConditionTool<M, MO, MC> condition(Class<T> conditionClass, Condition<TC> condition) {

        ConditionData<T, TO, TC> conditionData = new ConditionData(this.toolData, conditionClass);
        this.toolData.addConditionData(conditionData);
        return this;
    }

}
