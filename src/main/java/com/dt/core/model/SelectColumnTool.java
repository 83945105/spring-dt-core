package com.dt.core.model;

import com.dt.core.bean.*;
import com.dt.core.data.JoinTableData;
import com.dt.core.data.MainTableData;
import com.dt.core.norm.Column;
import com.dt.core.norm.Data;
import com.dt.core.norm.Model;
import com.dt.core.parser.SelectColumnParser;

import java.util.Map;

/**
 * Created by 白超 on 2018/6/23.
 */
public abstract class SelectColumnTool<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> extends WhereTool<M, ML, MO, MC, MS, MG> {

    private SelectColumnParser selectColumnParser = SelectColumnParser.getInstance();

    public SelectColumnTool(Data<M, ML, MO, MC, MS, MG> data) {
        super(data);
    }

    public SelectColumnTool<M, ML, MO, MC, MS, MG> column(Column<M, ML, MO, MC, MS, MG> column) {
        MainTableData tableData = this.data.getMainTableData();
        Map<String, String> columns = column.apply((ML) tableData.getTable().getColumn()).getColumns();
        tableData.addSelectColumns(columns);
        this.data.addColumnDataSet(tableData);
        return this;
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> SelectColumnTool<M, ML, MO, MC, MS, MG> column(Class<T> columnClass, String alias, Column<T, TL, TO, TC, TS, TG> column) {
        JoinTableData joinTableData = this.data.getJoinTableData(alias, columnClass);
        Map<String, String> columns = column.apply((TL) joinTableData.getTable().getColumn()).getColumns();
        joinTableData.addSelectColumns(columns);
        this.data.addColumnDataSet(joinTableData);
        return this;
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> SelectColumnTool<M, ML, MO, MC, MS, MG> column(Class<T> columnClass, Column<T, TL, TO, TC, TS, TG> column) {
        return column(columnClass, null, column);
    }

    @Override
    public String getSelectColumnSql() {
        return this.selectColumnParser.parse(this.getData().getColumnDataSet());
    }

}
