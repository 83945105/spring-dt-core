package com.dt.core.model;

import com.dt.core.DataTool;
import com.dt.core.bean.ConditionModel;
import com.dt.core.bean.GroupModel;
import com.dt.core.bean.OnModel;
import com.dt.core.bean.SortModel;
import com.dt.core.data.ToolData;
import com.dt.core.norm.Data;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/18.
 */
public abstract class SelectTool<M extends Model<M, MO, MC, MS, MG>,
        MO extends OnModel<M, MO, MC, MS, MG>,
        MC extends ConditionModel<M, MO, MC, MS, MG>,
        MS extends SortModel<M, MO, MC, MS, MG>,
        MG extends GroupModel<M, MO, MC, MS, MG>> extends JoinTool<M, MO, MC, MS, MG> {

    public SelectTool(Data<M, MO, MC, MS, MG> data) {
        super(data);
    }

    public static <T extends Model<T, TO, TC, TS, TG>,
            TO extends OnModel<T, TO, TC, TS, TG>,
            TC extends ConditionModel<T, TO, TC, TS, TG>,
            TS extends SortModel<T, TO, TC, TS, TG>,
            TG extends GroupModel<T, TO, TC, TS, TG>> SelectTool<T, TO, TC, TS, TG> select(Class<T> mainClass) {
        return new DataTool(new ToolData());
    }

    public static <T extends Model<T, TO, TC, TS, TG>,
            TO extends OnModel<T, TO, TC, TS, TG>,
            TC extends ConditionModel<T, TO, TC, TS, TG>,
            TS extends SortModel<T, TO, TC, TS, TG>,
            TG extends GroupModel<T, TO, TC, TS, TG>> SelectTool<T, TO, TC, TS, TG> select(Class<T> mainClass, String tableName) {
        DataTool<T, TO, TC, TS, TG> tool = new DataTool(new ToolData());
//        tool.toolData.setTableName(tableName);
        return tool;
    }

}
