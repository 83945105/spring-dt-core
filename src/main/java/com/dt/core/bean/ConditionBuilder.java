package com.dt.core.bean;

import com.dt.core.data.ConditionalData;

import java.util.ArrayList;
import java.util.List;

/**
 * 条件构建器
 * Created by 白超 on 2018/6/7.
 */
public final class ConditionBuilder<C extends ConditionModel> {

    protected C handleModel;

    protected List<ConditionalData> conditionalDataList = new ArrayList<>();

    public ConditionBuilder(C handleModel) {
        this.handleModel = handleModel;
    }

    public void setHandler(String a, String b, String c, boolean d, boolean e) {
//        ConditionalData conditionalData = new ConditionalData();
    }

    public C equalTo() {
        return handleModel;
    }
}
