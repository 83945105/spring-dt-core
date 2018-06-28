package com.dt.core.data;

import com.dt.core.bean.SortType;

/**
 * 排序数据
 * Created by 白超 on 2018/6/28.
 */
public final class SortData {

    private String ownerTableName;

    private String ownerAlias;

    private String ownerColumnName;

    private SortType sortType = SortType.ASC;

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

    public SortType getSortType() {
        return sortType;
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
    }
}
