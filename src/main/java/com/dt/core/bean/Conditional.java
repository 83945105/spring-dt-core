package com.dt.core.bean;

/**
 * 条件体
 * 用于描述单个条件属性
 * Created by 白超 on 2018/6/7.
 */
public final class Conditional {

    private String tableName;

    private String columnName;

    private String fieldName;

    private ColumnFormatter columnFormatter;

    private Object value;

    private Object secondValue;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public ColumnFormatter getColumnFormatter() {
        return columnFormatter;
    }

    public void setColumnFormatter(ColumnFormatter columnFormatter) {
        this.columnFormatter = columnFormatter;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(Object secondValue) {
        this.secondValue = secondValue;
    }

    public enum ColumnFormatter {
        /**
         * 数据库字段值转为数值类型
         */
        TO_INT(" * 1");

        String value;

        ColumnFormatter(String value) {
            this.value = value;
        }
    }
}
