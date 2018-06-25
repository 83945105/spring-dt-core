package com.dt.core.data;

import com.dt.core.bean.OnType;

/**
 * 条件数据
 * Created by 白超 on 2018/6/24.
 */
public class OnData {

    private String mainTableName;

    private String mainAlias;

    private String mainColumnName;

    private OnType onType = OnType.EQUAL;

    private String targetTableName;

    private String targetAlias;

    private String targetColumnName;

    private Object targetValue;

    public String getMainTableName() {
        return mainTableName;
    }

    public void setMainTableName(String mainTableName) {
        this.mainTableName = mainTableName;
    }

    public String getMainAlias() {
        return mainAlias;
    }

    public void setMainAlias(String mainAlias) {
        this.mainAlias = mainAlias;
    }

    public String getMainColumnName() {
        return mainColumnName;
    }

    public void setMainColumnName(String mainColumnName) {
        this.mainColumnName = mainColumnName;
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
