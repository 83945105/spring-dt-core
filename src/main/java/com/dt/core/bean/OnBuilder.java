package com.dt.core.bean;

import com.dt.core.data.OnData;
import com.dt.core.norm.Model;
import com.dt.core.norm.OnB;

/**
 * Created by 白超 on 2018/6/17.
 */
public class OnBuilder<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> {

    protected MO handleModel;

    public OnBuilder(MO handleModel) {
        this.handleModel = handleModel;
    }

    private OnData onData;

    public OnBuilder handler(String joinTableName, String joinAlias, String joinColumnName) {
        onData = new OnData();
        onData.setJoinTableName(joinTableName);
        onData.setJoinAlias(joinAlias);
        onData.setJoinColumnName(joinColumnName);
        return this;
    }

    public MO equalTo(Object value) {
        onData.setOnType(OnType.EQUAL);
        onData.setTargetValue(value);
        return handleModel;
    }

    public MO equalTo(OnBuilder onBuilder) {
        onData.setOnType(OnType.EQUAL);
        OnData targetData = onBuilder.onData;
        onData.setTargetTableName(targetData.getJoinTableName());
        onData.setTargetAlias(targetData.getJoinAlias());
        onData.setJoinColumnName(targetData.getJoinColumnName());
        return handleModel;
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> MO equalTo(String alias,
                                                                     Class<T> onClass,
                                                                     OnB<T, TL, TO, TC, TS, TG> on) {
        return handleModel;
    }
}
