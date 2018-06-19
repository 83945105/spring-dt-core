package com.dt.core.bean;

/**
 * Created by 白超 on 2018/6/19.
 */
public final class SortBuilder<S extends SortModel> {

    private S handleModel;

    public SortBuilder(S handleModel) {
        this.handleModel = handleModel;
    }

    public S asc() {
        return handleModel;
    }

    public S desc() {
        return handleModel;
    }
}
