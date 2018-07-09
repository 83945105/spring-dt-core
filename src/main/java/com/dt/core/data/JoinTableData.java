package com.dt.core.data;

import com.dt.core.bean.*;
import com.dt.core.norm.Model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 表数据
 * Created by 白超 on 2018/6/24.
 */
public final class JoinTableData<T extends Model<T, TL, TO, TC, TS, TG>,
        TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
        TO extends OnModel<T, TL, TO, TC, TS, TG>,
        TC extends WhereModel<T, TL, TO, TC, TS, TG>,
        TS extends SortModel<T, TL, TO, TC, TS, TG>,
        TG extends GroupModel<T, TL, TO, TC, TS, TG>> extends TableData<T, TL, TO, TC, TS, TG> {

    private JoinType joinType = JoinType.INNER;

    private Map<LinkType, List<OnData>> linkOnDataMap = new LinkedHashMap<>();

    public JoinTableData(Class<T> tableClass) {
        super(tableClass);
    }

    public JoinType getJoinType() {
        return joinType;
    }

    public void setJoinType(JoinType joinType) {
        this.joinType = joinType;
    }

    public Map<LinkType, List<OnData>> getLinkOnDataMap() {
        return linkOnDataMap;
    }

    public void addLinkOnDataMap(Map<LinkType, List<OnData>> linkOnDataMap) {
        if (linkOnDataMap == null || linkOnDataMap.size() == 0) {
            return;
        }
        this.linkOnDataMap.putAll(linkOnDataMap);
    }

}
