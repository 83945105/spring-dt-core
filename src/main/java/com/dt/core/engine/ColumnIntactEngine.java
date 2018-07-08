package com.dt.core.engine;

import com.dt.core.bean.*;
import com.dt.core.data.JoinTableData;
import com.dt.core.data.MainTableData;
import com.dt.core.data.VirtualFieldData;
import com.dt.core.norm.Column;
import com.dt.core.norm.Model;
import com.dt.core.parser.ColumnParser;

import java.util.Map;

/**
 * Created by 白超 on 2018/6/23.
 */
public class ColumnIntactEngine<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> extends WhereEngine<M, ML, MO, MC, MS, MG> {

    private ColumnParser columnParser = ColumnParser.getInstance();

    public ColumnIntactEngine(Class<M> mainClass) {
        super(mainClass);
    }

    public ColumnIntactEngine(Class<M> mainClass, String tableName) {
        super(mainClass, tableName);
    }

    public ColumnIntactEngine<M, ML, MO, MC, MS, MG> column(Column<M, ML, MO, MC, MS, MG> column) {
        MainTableData tableData = this.data.getMainTableData();
        Map<String, String> columns = column.apply((ML) tableData.getTable().getColumn()).getColumnAliasMap();
        tableData.addColumnAliasMap(columns);
        this.data.addColumnData(tableData);
        return this;
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> ColumnIntactEngine<M, ML, MO, MC, MS, MG> column(Class<T> columnClass, String alias, Column<T, TL, TO, TC, TS, TG> column) {
        JoinTableData joinTableData = this.data.getJoinTableData(alias, columnClass);
        Map<String, String> columns = column.apply((TL) joinTableData.getTable().getColumn()).getColumnAliasMap();
        joinTableData.addColumnAliasMap(columns);
        this.data.addColumnData(joinTableData);
        return this;
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> ColumnIntactEngine<M, ML, MO, MC, MS, MG> column(Class<T> columnClass, Column<T, TL, TO, TC, TS, TG> column) {
        return column(columnClass, null, column);
    }

    public ColumnIntactEngine<M, ML, MO, MC, MS, MG> virtualColumn(String value, String alias) {
        VirtualFieldData virtualFieldData = new VirtualFieldData();
        virtualFieldData.setValue(value);
        virtualFieldData.setAlias(alias);
        this.data.addVirtualFieldData(virtualFieldData);
        return this;
    }

    public ColumnIntactEngine<M, ML, MO, MC, MS, MG> virtualColumn(int value, String alias) {
        VirtualFieldData virtualFieldData = new VirtualFieldData();
        virtualFieldData.setValue(value);
        virtualFieldData.setAlias(alias);
        this.data.addVirtualFieldData(virtualFieldData);
        return this;
    }

    public ColumnIntactEngine<M, ML, MO, MC, MS, MG> virtualColumn(long value, String alias) {
        VirtualFieldData virtualFieldData = new VirtualFieldData();
        virtualFieldData.setValue(value);
        virtualFieldData.setAlias(alias);
        this.data.addVirtualFieldData(virtualFieldData);
        return this;
    }

    public ColumnIntactEngine<M, ML, MO, MC, MS, MG> virtualColumn(double value, String alias) {
        VirtualFieldData virtualFieldData = new VirtualFieldData();
        virtualFieldData.setValue(value);
        virtualFieldData.setAlias(alias);
        this.data.addVirtualFieldData(virtualFieldData);
        return this;
    }

    @Override
    public Map<String, String> getColumnAliasMap() {
        return this.data.getMainTableData().getColumnAliasMap();
    }

    @Override
    public String getColumnSql() {
        return this.columnParser.parse(this.getData().getMainTableData(),
                this.getData().getVirtualFieldDataSet(),
                this.getData().getColumnDataSet());
    }

}
