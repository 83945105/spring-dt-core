package com.dt.core.converter;

/**
 * 驼峰转换器
 * Created by 白超 on 2018/6/28.
 */
public class HumpConverter {

    public String columnToField(String columnName) {
        StringBuilder sb = new StringBuilder(8);
        return columnToField(columnName, new StringBuilder(8));
    }

    public String columnToField(String columnName, StringBuilder stringBuilder) {
        if (columnName == null || columnName.isEmpty()) {
            return "";
        } else if (!columnName.contains("_")) {
            return columnName.substring(0, 1).toLowerCase() + columnName.substring(1);
        }
        String camels[] = columnName.split("_");
        stringBuilder.replace(0, stringBuilder.length(), "");
        for (String camel : camels) {
            if (camel.isEmpty()) {
                continue;
            }
            if (stringBuilder.length() == 0) {
                stringBuilder.append(camel.toLowerCase());
            } else {
                stringBuilder.append(camel.substring(0, 1).toUpperCase());
                stringBuilder.append(camel.substring(1).toLowerCase());
            }
        }
        return stringBuilder.toString();
    }

}
