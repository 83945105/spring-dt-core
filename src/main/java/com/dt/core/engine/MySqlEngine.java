package com.dt.core.engine;

import com.dt.core.bean.*;
import com.dt.core.data.EngineData;
import com.dt.core.engine.*;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/5/29.
 */
public class MySqlEngine {

    public static <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> JoinEngine<T, TL, TO, TC, TS, TG> main(String tableName, Class<T> mainClass) {
        return new JoinEngine<>(mainClass, tableName);
    }

    public static <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> JoinEngine<T, TL, TO, TC, TS, TG> main(Class<T> mainClass) {
        return main(null, mainClass);
    }

    public static <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> ColumnEngine<T, TL, TO, TC, TS, TG> column(Class<T> columnClass) {
        return new ColumnEngine<>(columnClass);
    }

}
