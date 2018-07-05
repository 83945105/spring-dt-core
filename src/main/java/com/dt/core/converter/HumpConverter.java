package com.dt.core.converter;

/**
 * 驼峰转换器
 * Created by 白超 on 2018/6/28.
 */
public final class HumpConverter implements ColumnFieldConverter {

    @Override
    public String columnToField(String column) {
        String[] names = column.trim().split("_");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < names.length; i++) {
            if (names[i].length() == 0) {
                continue;
            }
            char[] cs = names[i].toLowerCase().toCharArray();
            cs[0] -= 32;
            sb.append(String.valueOf(cs));
        }
        char[] cs = sb.toString().toCharArray();
        cs[0] += 32;
        return String.valueOf(cs);
    }

    @Override
    public String fieldToColumn(String field) {
        if (field == null || "".equals(field.trim())) {
            return null;
        }
        int len = field.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = field.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append("_");
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
