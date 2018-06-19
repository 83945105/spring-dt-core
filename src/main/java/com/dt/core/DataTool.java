package com.dt.core;

import com.dt.core.bean.ConditionModel;
import com.dt.core.bean.GroupModel;
import com.dt.core.bean.OnModel;
import com.dt.core.bean.SortModel;
import com.dt.core.model.SelectTool;
import com.dt.core.norm.Data;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/5/29.
 */
public class DataTool<M extends Model<M, MO, MC, MS, MG>,
        MO extends OnModel<M, MO, MC, MS, MG>,
        MC extends ConditionModel<M, MO, MC, MS, MG>,
        MS extends SortModel<M, MO, MC, MS, MG>,
        MG extends GroupModel<M, MO, MC, MS, MG>> extends SelectTool<M, MO, MC, MS, MG> {

    public DataTool(Data<M, MO, MC, MS, MG> data) {
        super(data);
    }

}
