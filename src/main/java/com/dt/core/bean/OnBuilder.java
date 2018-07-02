package com.dt.core.bean;

import com.dt.core.data.JoinTableData;
import com.dt.core.data.OnData;
import com.dt.core.exception.ComparisonException;
import com.dt.core.norm.*;

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
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> implements ComparisonOperator<MO>, OnComparisonOperator<M, ML, MO, MC, MS, MG> {

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

    @Override
    public MO isNull() {
        onData.setOnType(OnType.IS_NULL);
        onData.setOnValueType(OnValueType.VALUE);
        onData.setValueCount(0);
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public MO isNotNull() {
        onData.setOnType(OnType.IS_NOT_NULL);
        onData.setOnValueType(OnValueType.VALUE);
        onData.setValueCount(0);
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public MO equalToValue(Object value, ComparisonRule comparisonRule) {
        if (value == null) {
            switch (comparisonRule) {
                case NULL_SKIP:
                    return handleModel;
                case NOT_NULL:
                    throw new ComparisonException("join table alias [" + onData.getOwnerAlias() + "] column [" + onData.getOwnerColumnName() + "] equalTo, the value can not be null.");
            }
        }
        onData.setOnType(OnType.EQUAL);
        onData.setOnValueType(OnValueType.VALUE);
        onData.setValueCount(1);
        onData.setTargetValue(value);
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public MO notEqualToValue(Object value, ComparisonRule comparisonRule) {
        if (value == null) {
            switch (comparisonRule) {
                case NULL_SKIP:
                    return handleModel;
                case NOT_NULL:
                    throw new ComparisonException("join table alias [" + onData.getOwnerAlias() + "] column [" + onData.getOwnerColumnName() + "] notEqualTo, the value can not be null.");
            }
        }
        onData.setOnType(OnType.NOT_EQUAL);
        onData.setOnValueType(OnValueType.VALUE);
        onData.setValueCount(1);
        onData.setTargetValue(value);
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public MO greaterThanValue(Object value, ComparisonRule comparisonRule) {
        if (value == null) {
            switch (comparisonRule) {
                case NULL_SKIP:
                    return handleModel;
                case NOT_NULL:
                    throw new ComparisonException("join table alias [" + onData.getOwnerAlias() + "] column [" + onData.getOwnerColumnName() + "] greaterThan, the value can not be null.");
            }
        }
        onData.setOnType(OnType.GREATER);
        onData.setOnValueType(OnValueType.VALUE);
        onData.setValueCount(1);
        onData.setTargetValue(value);
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public MO greaterThanAndEqualToValue(Object value, ComparisonRule comparisonRule) {
        if (value == null) {
            switch (comparisonRule) {
                case NULL_SKIP:
                    return handleModel;
                case NOT_NULL:
                    throw new ComparisonException("join table alias [" + onData.getOwnerAlias() + "] column [" + onData.getOwnerColumnName() + "] greaterThanAndEqualTo, the value can not be null.");
            }
        }
        onData.setOnType(OnType.GREATER_EQUAL);
        onData.setOnValueType(OnValueType.VALUE);
        onData.setValueCount(1);
        onData.setTargetValue(value);
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public MO lessThanValue(Object value, ComparisonRule comparisonRule) {
        if (value == null) {
            switch (comparisonRule) {
                case NULL_SKIP:
                    return handleModel;
                case NOT_NULL:
                    throw new ComparisonException("join table alias [" + onData.getOwnerAlias() + "] column [" + onData.getOwnerColumnName() + "] lessThan, the value can not be null.");
            }
        }
        onData.setOnType(OnType.LESS);
        onData.setOnValueType(OnValueType.VALUE);
        onData.setValueCount(1);
        onData.setTargetValue(value);
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public MO lessThanAndEqualToValue(Object value, ComparisonRule comparisonRule) {
        if (value == null) {
            switch (comparisonRule) {
                case NULL_SKIP:
                    return handleModel;
                case NOT_NULL:
                    throw new ComparisonException("join table alias [" + onData.getOwnerAlias() + "] column [" + onData.getOwnerColumnName() + "] lessThanAndEqualTo, the value can not be null.");
            }
        }
        onData.setOnType(OnType.LESS_EQUAL);
        onData.setOnValueType(OnValueType.VALUE);
        onData.setValueCount(1);
        onData.setTargetValue(value);
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public MO betweenValue(Object value, Object secondValue, ComparisonRule comparisonRule) {
        if (value == null) {
            switch (comparisonRule) {
                case NULL_SKIP:
                    return handleModel;
                case NOT_NULL:
                    throw new ComparisonException("join table alias [" + onData.getOwnerAlias() + "] column [" + onData.getOwnerColumnName() + "] between, the value can not be null.");
            }
        }
        if (secondValue == null) {
            switch (comparisonRule) {
                case NULL_SKIP:
                    return handleModel;
                case NOT_NULL:
                    throw new ComparisonException("join table alias [" + onData.getOwnerAlias() + "] column [" + onData.getOwnerColumnName() + "] between, the secondValue can not be null.");
            }
        }
        onData.setOnType(OnType.BETWEEN);
        onData.setOnValueType(OnValueType.VALUE);
        onData.setValueCount(2);
        onData.setTargetValue(value);
        onData.setTargetSecondValue(secondValue);
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public MO likeValue(Object value, ComparisonRule comparisonRule) {
        if (value == null) {
            switch (comparisonRule) {
                case NULL_SKIP:
                    return handleModel;
                case NOT_NULL:
                    throw new ComparisonException("join table alias [" + onData.getOwnerAlias() + "] column [" + onData.getOwnerColumnName() + "] like, the value can not be null.");
            }
        }
        onData.setOnType(OnType.LIKE);
        onData.setOnValueType(OnValueType.VALUE);
        onData.setValueCount(1);
        onData.setTargetValue(value);
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public MO inValue(Object[] values, ComparisonRule comparisonRule) {
        if (values == null || values.length == 0) {
            switch (comparisonRule) {
                case NULL_SKIP:
                    return handleModel;
                case NOT_NULL:
                    throw new ComparisonException("join table alias [" + onData.getOwnerAlias() + "] column [" + onData.getOwnerColumnName() + "] in, the values can not be null or size = 0.");
            }
        }
        onData.setOnType(OnType.IN);
        onData.setOnValueType(OnValueType.VALUE);
        onData.setValueCount(values.length);
        onData.setTargetValue(values);
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public MO equalTo(OnBuilder onBuilder) {
        onData.setOnType(OnType.EQUAL);
        onData.setOnValueType(OnValueType.JOIN);
        OnData targetOnData = onBuilder.onData;
        onData.setTargetTableName(targetOnData.getOwnerTableName());
        onData.setTargetAlias(targetOnData.getOwnerAlias());
        onData.setTargetColumnName(targetOnData.getOwnerColumnName());
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public MO notEqualTo(OnBuilder onBuilder) {
        onData.setOnType(OnType.NOT_EQUAL);
        onData.setOnValueType(OnValueType.JOIN);
        OnData targetOnData = onBuilder.onData;
        onData.setTargetTableName(targetOnData.getOwnerTableName());
        onData.setTargetAlias(targetOnData.getOwnerAlias());
        onData.setTargetColumnName(targetOnData.getOwnerColumnName());
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public MO greaterThan(OnBuilder onBuilder) {
        onData.setOnType(OnType.GREATER);
        onData.setOnValueType(OnValueType.JOIN);
        OnData targetOnData = onBuilder.onData;
        onData.setTargetTableName(targetOnData.getOwnerTableName());
        onData.setTargetAlias(targetOnData.getOwnerAlias());
        onData.setTargetColumnName(targetOnData.getOwnerColumnName());
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public MO greaterThanAndEqualTo(OnBuilder onBuilder) {
        onData.setOnType(OnType.GREATER_EQUAL);
        onData.setOnValueType(OnValueType.JOIN);
        OnData targetOnData = onBuilder.onData;
        onData.setTargetTableName(targetOnData.getOwnerTableName());
        onData.setTargetAlias(targetOnData.getOwnerAlias());
        onData.setTargetColumnName(targetOnData.getOwnerColumnName());
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public MO lessThan(OnBuilder onBuilder) {
        onData.setOnType(OnType.LESS);
        onData.setOnValueType(OnValueType.JOIN);
        OnData targetOnData = onBuilder.onData;
        onData.setTargetTableName(targetOnData.getOwnerTableName());
        onData.setTargetAlias(targetOnData.getOwnerAlias());
        onData.setTargetColumnName(targetOnData.getOwnerColumnName());
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public MO lessThanAndEqualTo(OnBuilder onBuilder) {
        onData.setOnType(OnType.LESS_EQUAL);
        onData.setOnValueType(OnValueType.JOIN);
        OnData targetOnData = onBuilder.onData;
        onData.setTargetTableName(targetOnData.getOwnerTableName());
        onData.setTargetAlias(targetOnData.getOwnerAlias());
        onData.setTargetColumnName(targetOnData.getOwnerColumnName());
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> MO equalTo(String alias,
                                                                     Class<T> onClass,
                                                                     OnB<T, TL, TO, TC, TS, TG> on) {
        onData.setOnType(OnType.EQUAL);
        onData.setOnValueType(OnValueType.JOIN);
        JoinTableData<T, TL, TO, TC, TS, TG> joinTableData = this.handleModel.getData().getJoinTableData(alias, onClass);
        TO to = (TO) joinTableData.getTable().getOn();
        OnData targetOnData = on.apply(to).onData;
        onData.setTargetTableName(targetOnData.getOwnerTableName());
        onData.setTargetAlias(joinTableData.getTableAlias());
        onData.setTargetColumnName(targetOnData.getOwnerColumnName());
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> MO notEqualTo(String alias, Class<T> onClass, OnB<T, TL, TO, TC, TS, TG> on) {
        onData.setOnType(OnType.NOT_EQUAL);
        onData.setOnValueType(OnValueType.JOIN);
        JoinTableData<T, TL, TO, TC, TS, TG> joinTableData = this.handleModel.getData().getJoinTableData(alias, onClass);
        TO to = (TO) joinTableData.getTable().getOn();
        OnData targetOnData = on.apply(to).onData;
        onData.setTargetTableName(targetOnData.getOwnerTableName());
        onData.setTargetAlias(joinTableData.getTableAlias());
        onData.setTargetColumnName(targetOnData.getOwnerColumnName());
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> MO greaterThan(String alias, Class<T> onClass, OnB<T, TL, TO, TC, TS, TG> on) {
        onData.setOnType(OnType.GREATER);
        onData.setOnValueType(OnValueType.JOIN);
        JoinTableData<T, TL, TO, TC, TS, TG> joinTableData = this.handleModel.getData().getJoinTableData(alias, onClass);
        TO to = (TO) joinTableData.getTable().getOn();
        OnData targetOnData = on.apply(to).onData;
        onData.setTargetTableName(targetOnData.getOwnerTableName());
        onData.setTargetAlias(joinTableData.getTableAlias());
        onData.setTargetColumnName(targetOnData.getOwnerColumnName());
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> MO greaterThanAndEqualTo(String alias, Class<T> onClass, OnB<T, TL, TO, TC, TS, TG> on) {
        onData.setOnType(OnType.GREATER_EQUAL);
        onData.setOnValueType(OnValueType.JOIN);
        JoinTableData<T, TL, TO, TC, TS, TG> joinTableData = this.handleModel.getData().getJoinTableData(alias, onClass);
        TO to = (TO) joinTableData.getTable().getOn();
        OnData targetOnData = on.apply(to).onData;
        onData.setTargetTableName(targetOnData.getOwnerTableName());
        onData.setTargetAlias(joinTableData.getTableAlias());
        onData.setTargetColumnName(targetOnData.getOwnerColumnName());
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> MO lessThan(String alias, Class<T> onClass, OnB<T, TL, TO, TC, TS, TG> on) {
        onData.setOnType(OnType.LESS);
        onData.setOnValueType(OnValueType.JOIN);
        JoinTableData<T, TL, TO, TC, TS, TG> joinTableData = this.handleModel.getData().getJoinTableData(alias, onClass);
        TO to = (TO) joinTableData.getTable().getOn();
        OnData targetOnData = on.apply(to).onData;
        onData.setTargetTableName(targetOnData.getOwnerTableName());
        onData.setTargetAlias(joinTableData.getTableAlias());
        onData.setTargetColumnName(targetOnData.getOwnerColumnName());
        onDataList.add(onData);
        return handleModel;
    }

    @Override
    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> MO lessThanAndEqualTo(String alias, Class<T> onClass, OnB<T, TL, TO, TC, TS, TG> on) {
        onData.setOnType(OnType.LESS_EQUAL);
        onData.setOnValueType(OnValueType.JOIN);
        JoinTableData<T, TL, TO, TC, TS, TG> joinTableData = this.handleModel.getData().getJoinTableData(alias, onClass);
        TO to = (TO) joinTableData.getTable().getOn();
        OnData targetOnData = on.apply(to).onData;
        onData.setTargetTableName(targetOnData.getOwnerTableName());
        onData.setTargetAlias(joinTableData.getTableAlias());
        onData.setTargetColumnName(targetOnData.getOwnerColumnName());
        onDataList.add(onData);
        return handleModel;
    }

    public List<OnData> getOnDataList() {
        return onDataList;
    }
}
