package com.dt.beans;

/**
 * 实体工具类
 *
 * @author 白超
 * @version 1.0
 * @since 2018/7/10
 */
public class BeanUtils {

    /**
     * 根据属性名获取对应的get方法名
     * @param property 属性名
     * @param isBooleanType 是否是boolean类型属性
     * @return get方法名
     */
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
