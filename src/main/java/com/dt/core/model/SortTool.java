package com.dt.core.model;

import com.dt.core.bean.*;
import com.dt.core.data.SortData;
import com.dt.core.norm.Data;
import com.dt.core.norm.Model;
import com.dt.core.norm.Sort;

import java.util.List;

/**
 * Created by 白超 on 2018/6/18.
 */
public abstract class SortTool<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> extends LimitTool<M, ML, MO, MC, MS, MG> {

    public SortTool(Data<M, ML, MO, MC, MS, MG> data) {
        super(data);
    }

    public SortTool<M, ML, MO, MC, MS, MG> sort(Sort<M, ML, MO, MC, MS, MG> sort) {
        List<SortData> sortDataList = sort.apply((MS) this.data.getMainMainTableData().getTable().getSort()).getSortBuilder().getSortDataList();
        return this;
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> SortTool<M, ML, MO, MC, MS, MG> sort(Class<T> sortClass, String alias, Sort<T, TL, TO, TC, TS, TG> sort) {

        return this;
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> SortTool<M, ML, MO, MC, MS, MG> sort(Class<T> sortClass, Sort<T, TL, TO, TC, TS, TG> sort) {
        return sort(sortClass, null, sort);
    }

}
