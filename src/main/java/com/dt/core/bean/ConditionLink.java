package com.dt.core.bean;

import com.dt.core.data.ConditionalData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 条件
 * Created by 白超 on 2018/6/7.
 */
public class ConditionLink {

    protected Map<ConditionLinkType, List<ConditionalData>> conditionMap = new LinkedHashMap<>();

    public ConditionLink and(ConditionModel dataModel) {
        return this;
    }

    public ConditionLink or(ConditionModel dataModel) {
        return this;
    }

    public enum ConditionLinkType {
        AND,
        OR
    }

}
