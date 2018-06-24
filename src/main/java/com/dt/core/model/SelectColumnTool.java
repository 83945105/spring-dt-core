package com.dt.core.model;

import com.dt.core.bean.*;
import com.dt.core.norm.Column;
import com.dt.core.norm.Data;
import com.dt.core.norm.Model;

import java.util.List;

/**
 * Created by 白超 on 2018/6/23.
 */
public abstract class SelectColumnTool<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> extends JoinTool<M, ML, MO, MC, MS, MG> {

    public SelectColumnTool(Data<M, ML, MO, MC, MS, MG> data) {
        super(data);
    }

    public SelectColumnTool<M, ML, MO, MC, MS, MG> column(String... columnName) {
        this.data.getMainMainTableData().setSelectColumns(columnName);
        return this;
    }


    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> SelectColumnTool<M, ML, MO, MC, MS, MG> column(String alias, Class<T> columnClass, String... columnName) {
        this.data.getJoinTableData(alias, columnClass).setSelectColumns(columnName);
        return this;
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> SelectColumnTool<M, ML, MO, MC, MS, MG> column(Class<T> columnClass, String... columnName) {
        return column(null, columnClass, columnName);
    }

    public SelectColumnTool<M, ML, MO, MC, MS, MG> column(Column<M, ML, MO, MC, MS, MG> column) {
        List<String> columns = column.apply((ML) this.data.getMainMainTableData().getTable().getColumn()).getColumns();
        return column(columns.toArray(new String[columns.size()]));
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> SelectColumnTool<M, ML, MO, MC, MS, MG> column(Class<T> columnClass, String alias, Column<T, TL, TO, TC, TS, TG> column) {
        List<String> columns = column.apply((TL) this.data.getJoinTableData(alias, columnClass).getTable().getColumn()).getColumns();
        return column(columns.toArray(new String[columns.size()]));
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> SelectColumnTool<M, ML, MO, MC, MS, MG> column(Class<T> columnClass, Column<T, TL, TO, TC, TS, TG> column) {
        return column(columnClass, null, column);
    }

}
