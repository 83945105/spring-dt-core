package com.dt.core.bean;

import com.dt.core.data.ConditionalData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 条件
 * Created by 白超 on 2018/6/7.
 */
public final class ConditionLink {

    private Map<ConditionLinkType, List<ConditionalData>> conditionMap = new LinkedHashMap<>();

    public ConditionLink and(ConditionModel conditionModel) {
        conditionMap.put(ConditionLinkType.AND, conditionModel.conditionBuilder.getConditionalDataList());
        return this;
    }

    public ConditionLink or(ConditionModel conditionModel) {
        conditionMap.put(ConditionLinkType.OR, conditionModel.conditionBuilder.getConditionalDataList());
        return this;
    }

    public enum ConditionLinkType {
        AND,
        OR
    }

    public Map<ConditionLinkType, List<ConditionalData>> getConditionMap() {
        return conditionMap;
    }
}
