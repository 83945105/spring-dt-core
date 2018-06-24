package com.dt.core.bean;

/**
 * 条件构建器
 * Created by 白超 on 2018/6/7.
 */
public final class WhereBuilder<C extends WhereModel> {

    private C handleModel;

    public WhereBuilder(C handleModel) {
        this.handleModel = handleModel;
    }

    public void setHandler(String tableName, String b, String c, boolean d, boolean e) {
    }

    public C equalTo() {
        return handleModel;
    }

}
