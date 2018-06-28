package com.dt.core.converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 白超 on 2018/6/28.
 */
public class UnderLineString2Camel {

    /**
     * 下划线转驼峰
     *
     * @param underline
     * @return
     */
    public static String underline2Camel(String underline) {
        Pattern pattern = Pattern.compile("[_]\\w");
        String camel = underline.toLowerCase();
        Matcher matcher = pattern.matcher(camel);
        while (matcher.find()) {
            String w = matcher.group().trim();
            camel = camel.replace(w, w.toUpperCase().replace("_", ""));
        }
        return camel;
    }

    /**
     * 驼峰转下划线
     *
     * @param camel
     * @return
     */
    public static String Camel2Underline(String camel) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(camel);
        while (matcher.find()) {
            String w = matcher.group().trim();
            camel = camel.replace(w, "_" + w);
        }
        return camel.toUpperCase();
    }

    /**
     * 驼峰转下划线。
     *
     * @param camel
     * @return
     */
    public static String Camel2Underline2(String camel) {
        char[] chars = camel.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < chars.length; i++, j++) {
            char s = chars[i];
            if (s + 1 > 65 && s + 1 < 91) {
                char _ = 95;
                sb.append(_);
                j++;
                sb.append(s);
                continue;
            }
            sb.append(s);
        }
        return sb.toString().toUpperCase();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            camelNamesb("QW_ABD_XYZN");
            System.out.println(System.nanoTime() - start);
        }
    }

    public static String camelName(String name) {
        String result = "";
        // 快速检查
        if (name == null || name.isEmpty()) {
            // 没必要转换
            return "";
        } else if (!name.contains("_")) {
            // 不含下划线，仅将首字母小写
            return name.substring(0, 1).toLowerCase() + name.substring(1);
        }
        // 用下划线将原始字符串分割
        String camels[] = name.split("_");
        for (String camel : camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 处理真正的驼峰片段
            if (result.length() == 0) {
                // 第一个驼峰片段，全部字母都小写
                result += camel.toLowerCase();
            } else {
                // 其他的驼峰片段，首字母大写
                result += camel.substring(0, 1).toUpperCase();
                result += camel.substring(1).toLowerCase();
            }
        }
        return result;
    }

    public static String camelNamesb(String name) {
        StringBuilder sb = new StringBuilder();
        // 快速检查
        if (name == null || name.isEmpty()) {
            // 没必要转换
            return "";
        } else if (!name.contains("_")) {
            // 不含下划线，仅将首字母小写
            return name.substring(0, 1).toLowerCase() + name.substring(1);
        }
        // 用下划线将原始字符串分割
        String camels[] = name.split("_");
        for (String camel : camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 处理真正的驼峰片段
            if (sb.length() == 0) {
                // 第一个驼峰片段，全部字母都小写
                sb.append(camel.toLowerCase());
            } else {
                // 其他的驼峰片段，首字母大写
                sb.append(camel.substring(0, 1).toUpperCase());
                sb.append(camel.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }

    public static String underscoreName(String name) {
        StringBuilder result = new StringBuilder();
        if (name != null && name.length() > 0) {
            // 将第一个字符处理成大写
            result.append(name.substring(0, 1).toUpperCase());
            // 循环处理其余字符
            for (int i = 1; i < name.length(); i++) {
                String s = name.substring(i, i + 1);
                // 在大写字母前添加下划线
                if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
                    result.append("_");
                }
                // 其他字符直接转成大写
                result.append(s.toUpperCase());
            }
        }
        return result.toString();
    }

    public static String camelToUnderline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
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