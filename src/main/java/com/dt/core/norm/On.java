package com.dt.core.norm;

import com.dt.core.bean.OnLink;

/**
 * 连接查询On条件
 * Created by 白超 on 2018/6/16.
 */
@FunctionalInterface
public interface On<JO, MO> {

    /**
     * 构建On条件
     *
     * @param on        连接对象
     * @param joinTable 连接表的条件
     * @param mainTable 主表的条件
     * @return
     */
    OnLink apply(OnLink on, JO joinTable, MO mainTable);

}
