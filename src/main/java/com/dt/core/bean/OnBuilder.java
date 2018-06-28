package com.dt.core.bean;

import com.dt.core.data.JoinTableData;
import com.dt.core.data.OnData;
import com.dt.core.norm.Model;
import com.dt.core.norm.OnB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 白超 on 2018/6/17.
 */
public final class OnBuilder<M extends Model<M, ML, MO, MC, MS, MG>,
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

    private List<OnData> onDataList = new ArrayList<>();

    public OnBuilder handler(String ownerTableName, String ownerAlias, String ownerColumnName) {
        onData = new OnData();
        onData.setOwnerTableName(ownerTableName);
        onData.setOwnerAlias(ownerAlias);
        onData.setOwnerColumnName(ownerColumnName);
        return this;
    }

    private MO equalToObject(Object value) {
        onData.setOnType(OnType.EQUAL);
        onData.setTargetValue(value);
        onDataList.add(onData);
        return handleModel;
    }

    public MO equalTo(String value) {
        return equalToObject(value);
    }

    public MO equalTo(int value) {
        return equalToObject(value);
    }

    public MO equalTo(long value) {
        return equalToObject(value);
    }

    public MO equalTo(double value) {
        return equalToObject(value);
    }

    public MO equalTo(OnBuilder onBuilder) {
        onData.setOnType(OnType.EQUAL);
        OnData targetOnData = onBuilder.onData;
        onData.setTargetTableName(targetOnData.getOwnerTableName());
        onData.setTargetAlias(targetOnData.getOwnerAlias());
        onData.setTargetColumnName(targetOnData.getOwnerColumnName());
        onDataList.add(onData);
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
        JoinTableData<T, TL, TO, TC, TS, TG> joinTableData = this.handleModel.getData().getJoinTableData(alias, onClass);
        TO to = (TO) joinTableData.getTable().getOn();
        OnData targetOnData = on.apply(to).onData;
        onData.setTargetTableName(targetOnData.getOwnerTableName());
        onData.setTargetAlias(targetOnData.getOwnerAlias());
        onData.setTargetColumnName(targetOnData.getOwnerColumnName());
        onDataList.add(onData);
        return handleModel;
    }

    public List<OnData> getOnDataList() {
        return onDataList;
    }
}
