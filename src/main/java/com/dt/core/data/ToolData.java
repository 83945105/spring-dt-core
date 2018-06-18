package com.dt.core.data;

import com.dt.core.bean.ConditionLink;
import com.dt.core.bean.ConditionModel;
import com.dt.core.bean.OnModel;
import com.dt.core.norm.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 白超 on 2018/6/18.
 */
public class ToolData<T extends Model<T, TO, TC>, TO extends OnModel<TO, T>, TC extends ConditionModel<TC, T>> extends Data<T, TO, TC> {

    private List<ConditionData> conditionDataList = new ArrayList<>();

    public ToolData(Data ownerData, Class<T> targetClass) {
        super(ownerData, targetClass);
    }

    public void addConditionLink(ConditionLink conditionLink) {
        ConditionData<T, TO, TC> data = new ConditionData(this, this.getTargetClass());
        this.conditionDataList.add(data);
    }

    public <C extends Model<C, CO, CC>,
            CO extends OnModel<CO, C>,
            CC extends ConditionModel<CC, C>> void addConditionData(ConditionData<C, CO, CC> conditionData) {
        this.conditionDataList.add(conditionData);
    }

}
