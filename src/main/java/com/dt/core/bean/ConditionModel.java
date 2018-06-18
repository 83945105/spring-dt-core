package com.dt.core.bean;

public class ConditionModel<TC extends ConditionModel, T> {

    protected ConditionBuilder<TC> conditionBuilder = new ConditionBuilder<>((TC) this);

    protected Class<T> owner;
}
