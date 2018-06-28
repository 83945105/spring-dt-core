package com.dt.core.data;

import com.dt.core.bean.OnType;

/**
 * 条件数据
 * Created by 白超 on 2018/6/24.
 */
public final class OnData {

    private String ownerTableName;

    private String ownerAlias;

    private String ownerColumnName;

    private OnType onType = OnType.EQUAL;

    private String targetTableName;

    private String targetAlias;

    private String targetColumnName;

    private Object targetValue;

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

    public OnType getOnType() {
        return onType;
    }

    public void setOnType(OnType onType) {
        this.onType = onType;
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

    public String getTargetColumnName() {
        return targetColumnName;
    }

    public void setTargetColumnName(String targetColumnName) {
        this.targetColumnName = targetColumnName;
    }

    public Object getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(Object targetValue) {
        this.targetValue = targetValue;
    }
}
