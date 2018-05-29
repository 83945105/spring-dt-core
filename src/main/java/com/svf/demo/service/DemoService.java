package com.svf.demo.service;

import com.svf.demo.bean.Test;

/**
 * 演示接口
 * Created by 白超 on 2018/4/12.
 */
public interface DemoService {

    /**
     * 添加一条记录
     *
     * @throws Exception
     */
    void addTest(String id, String name, String age) throws Exception;

    void updateTest(Test record) throws Exception;
}
