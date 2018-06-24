package com.dt.core.bean;

import com.dt.core.data.MainTableData;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/16.
 */
public class OnModel<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> {

    private MainTableData targetTableData;

    protected OnBuilder<M, ML, MO, MC, MS, MG> onBuilder = new OnBuilder<>((MO) this);

    public MainTableData getTargetTableData() {
        return targetTableData;
    }

    public void setTargetTableData(MainTableData targetTableData) {
        this.targetTableData = targetTableData;
    }
}
