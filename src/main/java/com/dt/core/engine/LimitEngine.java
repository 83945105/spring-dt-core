package com.dt.core.engine;

import com.dt.core.bean.*;
import com.dt.core.data.EngineData;
import com.dt.core.data.MainTableData;
import com.dt.core.norm.Data;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/18.
 */
public class LimitEngine<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> implements DataEngine<M, ML, MO, MC, MS, MG>, SqlEngine<M, ML, MO, MC, MS, MG> {

    protected Data<M, ML, MO, MC, MS, MG> data = new EngineData<>();

    public LimitEngine(Class<M> mainClass) {
        MainTableData data = new MainTableData(mainClass);
        this.data.setMainTableData(data);
    }

    public LimitEngine(Class<M> mainClass, String tableName) {
        MainTableData data = new MainTableData(mainClass);
        data.setTableName(tableName);
        this.data.setMainTableData(data);
    }

    public SqlEngine<M, ML, MO, MC, MS, MG> limit(int start, Integer end) {
        return this;
    }

    public SqlEngine<M, ML, MO, MC, MS, MG> limit(int start) {
        return limit(start, null);
    }

    @Override
    public Data<M, ML, MO, MC, MS, MG> getData() {
        return this.data;
    }

    @Override
    public String getTableName() {
        return this.data.getMainTableData().getTableName();
    }

    @Override
    public String getTableAlias() {
        return this.data.getMainTableData().getTableAlias();
    }

    @Override
    public String getPrimaryKeyName() {
        return this.data.getMainTableData().getPrimaryKeyName();
    }

    @Override
    public String getPrimaryKeyAlias() {
        return this.data.getMainTableData().getPrimaryKeyAlias();
    }
}
