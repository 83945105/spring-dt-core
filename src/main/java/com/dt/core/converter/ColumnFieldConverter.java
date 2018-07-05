package com.dt.core.converter;

/**
 * Created by 白超 on 2018/7/5.
 */
public interface ColumnFieldConverter {

    String columnToField(String column);

    String fieldToColumn(String field);
}
