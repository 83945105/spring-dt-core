package com.dt.core.data;

import com.dt.core.bean.WhereType;

/**
 * Created by 白超 on 2018/6/26.
 */
public class WhereData {

    private String ownerTableName;

    private String ownerAlias;

    private String ownerColumnName;

    private WhereType whereType = WhereType.EQUAL;

    private String targetTableName;

    private String targetAlias;

    private Object targetValue;

    private Object targetSecondValue;

    public String getOwnerTableName() {
        return ownerTableName;
    }

    public void setOwnerTableName(String ownerTableName) {
        this.ownerTableName = ownerTableName;
    }

    public String getOwnerAlias() {
        return ownerAlias;
    }

    public void setOwnerAlias(String ownerAlias) {
        this.ownerAlias = ownerAlias;
    }

    public String getOwnerColumnName() {
        return ownerColumnName;
    }

    public void setOwnerColumnName(String ownerColumnName) {
        this.ownerColumnName = ownerColumnName;
    }

    public WhereType getWhereType() {
        return whereType;
    }

    public void setWhereType(WhereType whereType) {
        this.whereType = whereType;
    }

    public String getTargetTableName() {
        return targetTableName;
    }

    public void setTargetTableName(String targetTableName) {
        this.targetTableName = targetTableName;
    }

    public String getTargetAlias() {
        return targetAlias;
    }

    public void setTargetAlias(String targetAlias) {
        this.targetAlias = targetAlias;
    }

    public Object getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(Object targetValue) {
        this.targetValue = targetValue;
    }

    public Object getTargetSecondValue() {
        return targetSecondValue;
    }

    public void setTargetSecondValue(Object targetSecondValue) {
        this.targetSecondValue = targetSecondValue;
    }
}
