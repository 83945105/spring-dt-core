package com.dt.beans;

import com.esotericsoftware.reflectasm.MethodAccess;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 白超 on 2018/7/7.
 */
public class ClassMethodAccessCache {

    private ConcurrentHashMap<Class, MethodAccess> accessConcurrentCache = new ConcurrentHashMap<>();

    public MethodAccess getMethodAccess(Class clazz) {
        MethodAccess methodAccess = accessConcurrentCache.get(clazz);
        if (methodAccess == null) {
            methodAccess = MethodAccess.get(clazz);
            accessConcurrentCache.put(clazz, methodAccess);
        }
        return methodAccess;
    }

}
