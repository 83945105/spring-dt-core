package com.dt.core.engine;

import com.dt.beans.BeanUtils;
import com.dt.beans.ClassMethodAccessCache;
import com.dt.core.data.ParseData;
import com.esotericsoftware.reflectasm.MethodAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 白超 on 2018/7/8.
 */
public class UpdateEngine {

    private ClassMethodAccessCache cache = new ClassMethodAccessCache();

    public String updateByPrimaryKey(String tableName, String primaryKeyName, Map<String, String> columnAliasMap) {
        StringBuilder sql = new StringBuilder(64);
        sql.append("update ")
                .append(tableName)
                .append(" set ");
        int i = 0;
        for (Map.Entry<String, String> entry : columnAliasMap.entrySet()) {
            if (entry.getKey().equals(primaryKeyName)) {
                continue;
            }
            if (i++ == 0) {
                sql.append("`").append(entry.getKey()).append("`");
            } else {
                sql.append(",`").append(entry.getKey()).append("`");
            }
            sql.append(" = ?");
        }
        return sql.append(" where ").append(primaryKeyName).append(" = ?").toString();
    }

    public ParseData updateMapByPrimaryKey(String tableName, String primaryKeyName, Object primaryKeyValue, Map<String, String> columnAliasMap, Map<String, ?> record) {
        StringBuilder sql = new StringBuilder(64);
        ParseData parseData = new ParseData();
        List<Object> args = new ArrayList<>();
        sql.append("update ")
                .append(tableName)
                .append(" set ");
        int i = 0;
        for (Map.Entry<String, String> entry : columnAliasMap.entrySet()) {
            if (i++ == 0) {
                sql.append("`").append(entry.getKey()).append("`");
            } else {
                sql.append(",`").append(entry.getKey()).append("`");
            }
            sql.append(" = ?");
            args.add(record.get(entry.getKey()));
        }
        args.add(primaryKeyValue);
        parseData.setSql(sql.append(" where ").append(primaryKeyName).append(" = ?").toString());
        parseData.setArgs(args);
        return parseData;
    }

    public ParseData updateMapByPrimaryKeySelective(String tableName, String primaryKeyName, Object primaryKeyValue, Map<String, String> columnAliasMap, Map<String, ?> record) {
        StringBuilder sql = new StringBuilder(64);
        ParseData parseData = new ParseData();
        List<Object> args = new ArrayList<>();
        sql.append("update ")
                .append(tableName)
                .append(" set ");
        int i = 0;
        Object value;
        for (Map.Entry<String, String> entry : columnAliasMap.entrySet()) {
            value = record.get(entry.getKey());
            if (value == null) {
                continue;
            }
            if (i++ == 0) {
                sql.append("`").append(entry.getKey()).append("`");
            } else {
                sql.append(",`").append(entry.getKey()).append("`");
            }
            sql.append(" = ?");
            args.add(value);
        }
        args.add(primaryKeyValue);
        parseData.setSql(sql.append(" where ").append(primaryKeyName).append(" = ?").toString());
        parseData.setArgs(args);
        return parseData;
    }

    public ParseData updateObjectByPrimaryKey(String tableName, String primaryKeyName, Object primaryKeyValue, Map<String, String> columnAliasMap, Object record) {
        Class clazz = record.getClass();
        MethodAccess methodAccess = this.cache.getMethodAccess(clazz);
        StringBuilder sql = new StringBuilder(64);
        ParseData parseData = new ParseData();
        List<Object> args = new ArrayList<>();
        sql.append("update ")
                .append(tableName)
                .append(" set ");
        int i = 0;
        for (Map.Entry<String, String> entry : columnAliasMap.entrySet()) {
            if (i++ == 0) {
                sql.append("`").append(entry.getKey()).append("`");
            } else {
                sql.append(",`").append(entry.getKey()).append("`");
            }
            sql.append(" = ?");
            //暂不支持Boolean类型获取Get方法
            args.add(methodAccess.invoke(record, BeanUtils.getGetterMethodName(entry.getValue(), false)));
        }
        args.add(primaryKeyValue);
        parseData.setSql(sql.append(" where ").append(primaryKeyName).append(" = ?").toString());
        parseData.setArgs(args);
        return parseData;
    }

    public ParseData updateObjectByPrimaryKeySelective(String tableName, String primaryKeyName, Object primaryKeyValue, Map<String, String> columnAliasMap, Object record) {
        Class clazz = record.getClass();
        MethodAccess methodAccess = this.cache.getMethodAccess(clazz);
        StringBuilder sql = new StringBuilder(64);
        ParseData parseData = new ParseData();
        List<Object> args = new ArrayList<>();
        sql.append("update ")
                .append(tableName)
                .append(" set ");
        int i = 0;
        Object value;
        for (Map.Entry<String, String> entry : columnAliasMap.entrySet()) {
            //暂不支持Boolean类型获取Get方法
            value = methodAccess.invoke(record, BeanUtils.getGetterMethodName(entry.getValue(), false));
            if (value == null) {
                continue;
            }
            if (i++ == 0) {
                sql.append("`").append(entry.getKey()).append("`");
            } else {
                sql.append(",`").append(entry.getKey()).append("`");
            }
            sql.append(" = ?");
            args.add(value);
        }
        args.add(primaryKeyValue);
        parseData.setSql(sql.append(" where ").append(primaryKeyName).append(" = ?").toString());
        parseData.setArgs(args);
        return parseData;
    }

    public ClassMethodAccessCache getCache() {
        return cache;
    }
}
