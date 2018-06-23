package com.dt.core.model;

import com.dt.core.bean.*;
import com.dt.core.norm.Column;
import com.dt.core.norm.Data;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/23.
 */
public abstract class InsertColumnTool<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends ConditionModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> {

    public InsertColumnTool(Data<M, ML, MO, MC, MS, MG> data) {
    }

    public InsertColumnTool<M, ML, MO, MC, MS, MG> column(String... columnName) {
        return this;
    }

    public InsertColumnTool<M, ML, MO, MC, MS, MG> column(Column<M, ML, MO, MC, MS, MG> column) {
        return this;
    }

}
