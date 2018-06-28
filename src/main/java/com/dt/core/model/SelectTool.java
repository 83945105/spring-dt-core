package com.dt.core.model;

import com.dt.core.bean.*;
import com.dt.core.data.MainTableData;
import com.dt.core.norm.Data;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/18.
 */
public class SelectTool<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> extends JoinTool<M, ML, MO, MC, MS, MG> {

    public SelectTool(Data<M, ML, MO, MC, MS, MG> data) {
        super(data);
    }

    public JoinTool<M, ML, MO, MC, MS, MG> select(String tableName, Class<M> mainClass) {
        MainTableData data = new MainTableData(mainClass);
        data.setTableName(tableName);
        this.data.setMainMainTableData(data);
        return this;
    }

    public JoinTool<M, ML, MO, MC, MS, MG> select(Class<M> mainClass) {
        return select(null, mainClass);
    }

}
