package com.dt.core.model;

import com.dt.core.bean.*;
import com.dt.core.norm.Data;
import com.dt.core.norm.DataTool;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/18.
 */
public abstract class LimitTool<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> extends SqlTool<M, ML, MO, MC, MS, MG> {

    protected Data<M, ML, MO, MC, MS, MG> data;

    public LimitTool(Data<M, ML, MO, MC, MS, MG> data) {
        this.data = data;
    }

    public SqlTool<M, ML, MO, MC, MS, MG> limit(int start, Integer end) {
        return this;
    }

    public SqlTool<M, ML, MO, MC, MS, MG> limit(int start) {
        return limit(start, null);
    }

    @Override
    public Data<M, ML, MO, MC, MS, MG> getData() {
        return this.data;
    }

}
