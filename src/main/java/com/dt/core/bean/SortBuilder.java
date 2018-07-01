package com.dt.core.bean;

import com.dt.core.data.SortData;
import com.dt.core.norm.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 白超 on 2018/6/19.
 */
public final class SortBuilder<S extends Model<S, SL, SO, SC, SS, SG>,
        SL extends ColumnModel<S, SL, SO, SC, SS, SG>,
        SO extends OnModel<S, SL, SO, SC, SS, SG>,
        SC extends WhereModel<S, SL, SO, SC, SS, SG>,
        SS extends SortModel<S, SL, SO, SC, SS, SG>,
        SG extends GroupModel<S, SL, SO, SC, SS, SG>> {

    private SS handleModel;

    public SortBuilder(SS handleModel) {
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

    public SS asc() {
        sortData.setSortType(SortType.ASC);
        sortDataList.add(sortData);
        return handleModel;
    }

    public SS desc() {
        sortData.setSortType(SortType.DESC);
        sortDataList.add(sortData);
        return handleModel;
    }

    public List<SortData> getSortDataList() {
        return sortDataList;
    }
}
