package com.dt.core.model;

import com.dt.core.DataTool;
import com.dt.core.bean.ConditionModel;
import com.dt.core.bean.OnModel;
import com.dt.core.data.ToolData;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/18.
 */
public abstract class SelectTool<M extends Model<M, MO, MC>, MO extends OnModel<MO, M>, MC extends ConditionModel<MC, M>> extends JoinTool<M, MO, MC> {

    public SelectTool(ToolData<M, MO, MC> toolData) {
        super(toolData);
    }

    public static <T extends Model<T, TO, TC>,
            TO extends OnModel<TO, T>,
            TC extends ConditionModel<TC, T>> SelectTool<T, TO, TC> select(Class<T> mainClass) {
        return new DataTool(new ToolData(null, mainClass));
    }

    public static <T extends Model<T, TO, TC>,
            TO extends OnModel<TO, T>,
            TC extends ConditionModel<TC, T>> SelectTool<T, TO, TC> select(Class<T> mainClass, String tableName) {
        DataTool<T, TO, TC> tool = new DataTool(new ToolData(null, mainClass));
        tool.toolData.setTableName(tableName);
        return tool;
    }

}
