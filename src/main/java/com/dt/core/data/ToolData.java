package com.dt.core.data;

import com.dt.core.bean.*;
import com.dt.core.norm.Data;
import com.dt.core.norm.Model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 白超 on 2018/6/18.
 */
public class ToolData<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> implements Data<M, ML, MO, MC, MS, MG> {

    private MainTableData<M, ML, MO, MC, MS, MG> mainMainTableData;

    private Map<String, JoinTableData> joinTableDataAliasMap = new HashMap<>();
    private Map<String, Class> classAliasMap = new HashMap<>();

    @Override
    public MainTableData<M, ML, MO, MC, MS, MG> getMainMainTableData() {
        return this.mainMainTableData;
    }

    @Override
    public void setMainMainTableData(MainTableData<M, ML, MO, MC, MS, MG> mainMainTableData) {
        this.mainMainTableData = mainMainTableData;
    }

    @Override
    public <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> JoinTableData<J, JL, JO, JC, JS, JG> getJoinTableData(String alias, Class<J> joinClass) {
        JoinTableData joinTableData;
        if (alias == null) {
            for (Map.Entry<String, Class> entry : this.classAliasMap.entrySet()) {
                if (entry.getValue() == joinClass) {
                    alias = entry.getKey();
                    break;
                }
            }
        }
        if (alias != null) {
            joinTableData = this.joinTableDataAliasMap.get(alias);
            if (joinTableData != null) {
                return joinTableData;
            }
        }
        //走到这里说明不存在
        joinTableData = new JoinTableData(joinClass);
        if (alias == null) {
            alias = joinTableData.getAlias();
        }
        this.joinTableDataAliasMap.put(alias, joinTableData);
        this.classAliasMap.put(alias, joinClass);
        return joinTableData;
    }

    @Override
    public void setLimit(int start, Integer end) {

    }
}
