package com.dt.core.norm;

import com.dt.core.bean.ConditionLink;

/**
 * 条件
 * Created by 白超 on 2018/6/17.
 */
@FunctionalInterface
public interface Condition<TC> {

    /**
     * @param condition 连接条件
     * @param table     表的条件
     * @return
     */
    ConditionLink apply(ConditionLink condition, TC table);
}
