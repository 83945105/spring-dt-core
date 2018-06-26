package com.dt.core.bean;

import com.dt.core.data.OnData;
import com.dt.core.norm.Model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 白超 on 2018/6/17.
 */
public class OnLink<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> {

    private Map<LinkType, List<OnData>> onDataMap = new LinkedHashMap<>();

    public OnLink<M, ML, MO, MC, MS, MG> and(OnModel<M, ML, MO, MC, MS, MG> onModel) {
        onDataMap.put(LinkType.AND, onModel.onBuilder.getOnDataList());
        return this;
    }

    public Map<LinkType, List<OnData>> getOnDataMap() {
        return onDataMap;
    }

}
