package com.dt.core.norm;

import com.dt.core.bean.ConditionLink;

/**
 * 条件
 * Created by 白超 on 2018/6/17.
 */
@FunctionalInterface
public interface Condition<MC> {

    /**
     * @param condition 连接条件
     * @param mainTable 主表的条件
     * @return
     */
    ConditionLink apply(ConditionLink condition, MC mainTable);
}
