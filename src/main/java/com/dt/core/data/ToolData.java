package com.dt.core.data;

import com.dt.core.bean.*;
import com.dt.core.norm.Data;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/18.
 */
public class ToolData<T extends Model<T, TL, TO, TC, TS, TG>,
        TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
        TO extends OnModel<T, TL, TO, TC, TS, TG>,
        TC extends ConditionModel<T, TL, TO, TC, TS, TG>,
        TS extends SortModel<T, TL, TO, TC, TS, TG>,
        TG extends GroupModel<T, TL, TO, TC, TS, TG>> implements Data<T, TL, TO, TC, TS, TG> {

    private String tableName;

    public ToolData() {
    }

    public ToolData(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public void setLimit(int start, Integer end) {

    }
}
