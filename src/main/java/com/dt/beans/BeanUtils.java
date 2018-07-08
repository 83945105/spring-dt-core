package com.dt.beans;

/**
 * Created by 白超 on 2018/7/7.
 */
public class BeanUtils {

    public static String getGetterMethodName(String property, boolean isBooleanType) {
        if (property == null || property.trim().length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(property);
        if (Character.isLowerCase(sb.charAt(0))) {
            if (sb.length() == 1 || !Character.isUpperCase(sb.charAt(1))) {
                sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            }
        }
        if (isBooleanType) {
            sb.insert(0, "is");
        } else {
            sb.insert(0, "get");
        }
        return sb.toString();
    }
}
