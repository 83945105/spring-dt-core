package com.dt.core.engine;

import com.dt.core.bean.*;
import com.dt.core.data.MainTableData;
import com.dt.core.norm.Column;
import com.dt.core.norm.Model;
import com.dt.core.parser.ColumnParser;

import java.util.Map;

/**
 * Created by 白超 on 2018/6/23.
 */
public class ColumnEngine<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> extends WhereEngine<M, ML, MO, MC, MS, MG> {

    private ColumnParser columnParser = ColumnParser.getInstance();

    public ColumnEngine(Class<M> mainClass) {
        super(mainClass);
    }

    public ColumnEngine(Class<M> mainClass, String tableName) {
        super(mainClass, tableName);
    }

    public ColumnEngine<M, ML, MO, MC, MS, MG> column(Column<M, ML, MO, MC, MS, MG> column) {
        MainTableData tableData = this.data.getMainTableData();
        Map<String, String> columns = column.apply((ML) tableData.getTable().getColumn()).getColumns();
        tableData.addSelectColumns(columns);
        this.data.addColumnDataSet(tableData);
        return this;
    }

    @Override
    public String getColumnSql() {
        return this.columnParser.parse(this.getData().getColumnDataSet());
    }

}
