package com.dt.core;

import com.dt.core.bean.*;
import com.dt.core.data.ToolData;
import com.dt.core.model.InsertColumnTool;
import com.dt.core.model.InsertTool;
import com.dt.core.model.SelectColumnTool;
import com.dt.core.model.SelectTool;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/5/29.
 */
public class MySqlTool {

    public static <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> InsertColumnTool<T, TL, TO, TC, TS, TG> INSERT(String tableName, Class<T> mainClass) {
        return new InsertTool<T, TL, TO, TC, TS, TG>(new ToolData()).insert(tableName, mainClass);
    }

    public static <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> InsertColumnTool<T, TL, TO, TC, TS, TG> INSERT(Class<T> mainClass) {
        return INSERT(null, mainClass);
    }

    public static <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> SelectColumnTool<T, TL, TO, TC, TS, TG> SELECT(String tableName, Class<T> mainClass) {
        return new SelectTool<T, TL, TO, TC, TS, TG>(new ToolData()).select(tableName, mainClass);
    }

    public static <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> SelectColumnTool<T, TL, TO, TC, TS, TG> SELECT(Class<T> mainClass) {
        return SELECT(null, mainClass);
    }

}
