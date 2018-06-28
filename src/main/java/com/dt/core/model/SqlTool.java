package com.dt.core.model;

import com.dt.core.bean.*;
import com.dt.core.norm.DataTool;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/28.
 */
public abstract class SqlTool<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> implements DataTool<M, ML, MO, MC, MS, MG> {




}
