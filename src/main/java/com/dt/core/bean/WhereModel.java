package com.dt.core.bean;

import com.dt.core.norm.Data;
import com.dt.core.norm.Model;

public class WhereModel<T extends Model<T, TL, TO, TC, TS, TG>,
        TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
        TO extends OnModel<T, TL, TO, TC, TS, TG>,
        TC extends WhereModel<T, TL, TO, TC, TS, TG>,
        TS extends SortModel<T, TL, TO, TC, TS, TG>,
        TG extends GroupModel<T, TL, TO, TC, TS, TG>> {

    private Data data;

    protected WhereBuilder<TC> whereBuilder = new WhereBuilder<>((TC) this);

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
