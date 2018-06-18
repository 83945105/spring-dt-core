package com.dt.core;

import com.dt.core.bean.ConditionModel;
import com.dt.core.bean.OnModel;
import com.dt.core.data.ToolData;
import com.dt.core.model.SelectTool;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/5/29.
 */
public class DataTool<M extends Model<M, MO, MC>, MO extends OnModel<MO, M>, MC extends ConditionModel<MC, M>> extends SelectTool<M, MO, MC> {

    public DataTool(ToolData<M, MO, MC> toolData) {
        super(toolData);
    }
}
