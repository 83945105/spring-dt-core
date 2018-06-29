package com.dt.core.bean;

import com.dt.core.data.WhereData;
import com.dt.core.exception.ComparisonException;
import com.dt.core.norm.ComparisonOperator;

import java.util.ArrayList;
import java.util.List;

/**
 * 条件构建器
 * Created by 白超 on 2018/6/7.
 */
public final class WhereBuilder<C extends WhereModel> implements ComparisonOperator<C> {

    private C handleModel;

    public WhereBuilder(C handleModel) {
        this.handleModel = handleModel;
    }

    private WhereData whereData;

    private List<WhereData> whereDataList = new ArrayList<>();

    public WhereBuilder handler(String ownerTableName, String ownerAlias, String ownerColumnName) {
        whereData = new WhereData();
        whereData.setOwnerTableName(ownerTableName);
        whereData.setOwnerAlias(ownerAlias);
        whereData.setOwnerColumnName(ownerColumnName);
        return this;
    }

    @Override
    public C isNull() {
        whereData.setWhereType(WhereType.IS_NULL);
        whereData.setValueCount(0);
        this.whereDataList.add(whereData);
        return handleModel;
    }

    @Override
    public C isNotNull() {
        whereData.setWhereType(WhereType.IS_NOT_NULL);
        whereData.setValueCount(0);
        this.whereDataList.add(whereData);
        return handleModel;
    }

    @Override
    public C equalToValue(Object value, ComparisonRule comparisonRule) {
        if (value == null) {
            switch (comparisonRule) {
                case NULL_SKIP:
                    return handleModel;
                case NOT_NULL:
                    throw new ComparisonException("table alias [" + whereData.getOwnerAlias() + "] column [" + whereData.getOwnerColumnName() + "] equalTo, the value can not be null.");
            }
        }
        whereData.setWhereType(WhereType.EQUAL);
        whereData.setValueCount(1);
        whereData.setTargetValue(value);
        whereDataList.add(whereData);
        return handleModel;
    }

    @Override
    public C notEqualToValue(Object value, ComparisonRule comparisonRule) {
        if (value == null) {
            switch (comparisonRule) {
                case NULL_SKIP:
                    return handleModel;
                case NOT_NULL:
                    throw new ComparisonException("table alias [" + whereData.getOwnerAlias() + "] column [" + whereData.getOwnerColumnName() + "] notEqualTo, the value can not be null.");
            }
        }
        whereData.setWhereType(WhereType.NOT_EQUAL);
        whereData.setValueCount(1);
        whereData.setTargetValue(value);
        whereDataList.add(whereData);
        return handleModel;
    }

    @Override
    public C greaterThanValue(Object value, ComparisonRule comparisonRule) {
        if (value == null) {
            switch (comparisonRule) {
                case NULL_SKIP:
                    return handleModel;
                case NOT_NULL:
                    throw new ComparisonException("table alias [" + whereData.getOwnerAlias() + "] column [" + whereData.getOwnerColumnName() + "] greaterThan, the value can not be null.");
            }
        }
        whereData.setWhereType(WhereType.GREATER);
        whereData.setValueCount(1);
        whereData.setTargetValue(value);
        whereDataList.add(whereData);
        return handleModel;
    }

    @Override
    public C greaterThanAndEqualToValue(Object value, ComparisonRule comparisonRule) {
        if (value == null) {
            switch (comparisonRule) {
                case NULL_SKIP:
                    return handleModel;
                case NOT_NULL:
                    throw new ComparisonException("table alias [" + whereData.getOwnerAlias() + "] column [" + whereData.getOwnerColumnName() + "] greaterThanAndEqualTo, the value can not be null.");
            }
        }
        whereData.setWhereType(WhereType.GREATER_EQUAL);
        whereData.setValueCount(1);
        whereData.setTargetValue(value);
        whereDataList.add(whereData);
        return handleModel;
    }

    @Override
    public C lessThanValue(Object value, ComparisonRule comparisonRule) {
        if (value == null) {
            switch (comparisonRule) {
                case NULL_SKIP:
                    return handleModel;
                case NOT_NULL:
                    throw new ComparisonException("table alias [" + whereData.getOwnerAlias() + "] column [" + whereData.getOwnerColumnName() + "] lessThan, the value can not be null.");
            }
        }
        whereData.setWhereType(WhereType.LESS);
        whereData.setValueCount(1);
        whereData.setTargetValue(value);
        whereDataList.add(whereData);
        return handleModel;
    }

    @Override
    public C lessThanAndEqualToValue(Object value, ComparisonRule comparisonRule) {
        if (value == null) {
            switch (comparisonRule) {
                case NULL_SKIP:
                    return handleModel;
                case NOT_NULL:
                    throw new ComparisonException("table alias [" + whereData.getOwnerAlias() + "] column [" + whereData.getOwnerColumnName() + "] lessThanAndEqualTo, the value can not be null.");
            }
        }
        whereData.setWhereType(WhereType.LESS_EQUAL);
        whereData.setValueCount(1);
        whereData.setTargetValue(value);
        whereDataList.add(whereData);
        return handleModel;
    }

    @Override
    public C betweenValue(Object value, Object secondValue, ComparisonRule comparisonRule) {
        if (value == null) {
            switch (comparisonRule) {
                case NULL_SKIP:
                    return handleModel;
                case NOT_NULL:
                    throw new ComparisonException("table alias [" + whereData.getOwnerAlias() + "] column [" + whereData.getOwnerColumnName() + "] between, the value can not be null.");
            }
        }
        if (secondValue == null) {
            switch (comparisonRule) {
                case NULL_SKIP:
                    return handleModel;
                case NOT_NULL:
                    throw new ComparisonException("table alias [" + whereData.getOwnerAlias() + "] column [" + whereData.getOwnerColumnName() + "] between, the secondValue can not be null.");
            }
        }
        whereData.setWhereType(WhereType.LESS_EQUAL);
        whereData.setValueCount(2);
        whereData.setTargetValue(value);
        whereData.setTargetSecondValue(secondValue);
        whereDataList.add(whereData);
        return handleModel;
    }

    @Override
    public C likeValue(Object value, ComparisonRule comparisonRule) {
        if (value == null) {
            switch (comparisonRule) {
                case NULL_SKIP:
                    return handleModel;
                case NOT_NULL:
                    throw new ComparisonException("table alias [" + whereData.getOwnerAlias() + "] column [" + whereData.getOwnerColumnName() + "] like, the value can not be null.");
            }
        }
        whereData.setWhereType(WhereType.LIKE);
        whereData.setValueCount(1);
        whereData.setTargetValue(value);
        whereDataList.add(whereData);
        return handleModel;
    }

    @Override
    public C inValue(Object[] values, ComparisonRule comparisonRule) {
        if (values == null || values.length == 0) {
            switch (comparisonRule) {
                case NULL_SKIP:
                    return handleModel;
                case NOT_NULL:
                    throw new ComparisonException("table alias [" + whereData.getOwnerAlias() + "] column [" + whereData.getOwnerColumnName() + "] in, the values can not be null or size = 0.");
            }
        }
        whereData.setWhereType(WhereType.IN);
        whereData.setValueCount(values.length);
        whereData.setTargetValue(values);
        whereDataList.add(whereData);
        return handleModel;
    }

    public List<WhereData> getWhereDataList() {
        return whereDataList;
    }
}
