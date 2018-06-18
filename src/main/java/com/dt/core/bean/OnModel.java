package com.dt.core.bean;

/**
 * Created by 白超 on 2018/6/16.
 */
public class OnModel<TO extends OnModel, T> {

    protected OnBuilder<TO> onBuilder = new OnBuilder<>((TO) this);

    protected Class<T> owner;
}
