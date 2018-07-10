package com.dt.beans;

import com.esotericsoftware.reflectasm.MethodAccess;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 用于缓存Access
 *
 * @author 白超
 * @version 1.0
 * @see MethodAccess
 * @since 2018/7/10
 */
public class ClassAccessCache {

    /**
     * MethodAccess缓存
     * {@link MethodAccess}
     */
    private ConcurrentHashMap<Class, MethodAccess> methodAccessConcurrentCache = new ConcurrentHashMap<>();

    /**
     * 获取指定类的MethodAccess
     * <p>存在返回、不存在新建
     * @param clazz 类的Class属性
     * @return {@link MethodAccess}
     */
    public MethodAccess getMethodAccess(Class clazz) {
        MethodAccess methodAccess = this.methodAccessConcurrentCache.get(clazz);
        if (methodAccess == null) {
            methodAccess = MethodAccess.get(clazz);
            this.methodAccessConcurrentCache.put(clazz, methodAccess);
        }
        return methodAccess;
    }

}
