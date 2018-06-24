package com.dt.core.model;

import com.dt.core.bean.*;
import com.dt.core.norm.Data;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/23.
 */
public class InsertTool<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> extends InsertColumnTool<M, ML, MO, MC, MS, MG> {

    public InsertTool(Data<M, ML, MO, MC, MS, MG> data) {
        super(data);
    }

    public InsertColumnTool<M, ML, MO, MC, MS, MG> insert(String tableName, Class<M> mainClass) {
        //TODO
        return this;
    }

    public InsertColumnTool<M, ML, MO, MC, MS, MG> insert(Class<M> mainClass) {
        return insert(null, mainClass);
    }
}
