package com.dt.core.bean;

import com.dt.core.data.SortData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 白超 on 2018/6/19.
 */
public final class SortBuilder<S extends SortModel> {

    private S handleModel;

    public SortBuilder(S handleModel) {
        this.handleModel = handleModel;
    }

    private SortData sortData;

    private List<SortData> sortDataList = new ArrayList<>();

    public SortBuilder handler(String ownerTableName, String ownerAlias, String ownerColumnName) {
        sortData = new SortData();
        sortData.setOwnerTableName(ownerTableName);
        sortData.setOwnerAlias(ownerAlias);
        sortData.setOwnerColumnName(ownerColumnName);
        return this;
    }

    public S asc() {
        sortData.setSortType(SortType.ASC);
        sortDataList.add(sortData);
        return handleModel;
    }

    public S desc() {
        sortData.setSortType(SortType.DESC);
        sortDataList.add(sortData);
        return handleModel;
    }

    public List<SortData> getSortDataList() {
        return sortDataList;
    }
}
