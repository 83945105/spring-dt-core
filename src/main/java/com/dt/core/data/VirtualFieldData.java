package com.dt.core.data;

/**
 * Created by 白超 on 2018/7/3.
 */
public class VirtualFieldData {

    private Object value;

    private String alias;

    public Object getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
