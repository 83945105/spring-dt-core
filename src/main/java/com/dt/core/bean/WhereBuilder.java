package com.dt.core.bean;

import com.dt.core.data.WhereData;

import java.util.ArrayList;
import java.util.List;

/**
 * 条件构建器
 * Created by 白超 on 2018/6/7.
 */
public final class WhereBuilder<C extends WhereModel> {

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

    public C equalTo(String value) {
        whereData.setWhereType(WhereType.EQUAL);
        whereData.setTargetValue(value);
        whereDataList.add(whereData);
        return handleModel;
    }

    public List<WhereData> getWhereDataList() {
        return whereDataList;
    }
}
