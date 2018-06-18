package com.dt.core.bean;

/**
 * Created by 白超 on 2018/6/17.
 */
public class OnBuilder<O extends OnModel> {

    protected O handleModel;

    public OnBuilder(O handleModel) {
        this.handleModel = handleModel;
    }

    public O equalTo(Object value) {
        return handleModel;
    }
    public O equalTo(OnBuilder onBuilder) {
        return handleModel;
    }
}
