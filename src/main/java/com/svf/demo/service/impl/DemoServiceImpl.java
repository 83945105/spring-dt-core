package com.svf.demo.service.impl;

import com.avalon.holygrail.ss.util.ExceptionUtil;
import com.avalon.holygrail.util.StringUtil;
import com.svf.demo.bean.Test;
import com.svf.demo.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * Created by 白超 on 2018/4/12.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public void addTest(String id, String name, String age) throws Exception {
        if (StringUtil.isEmpty(id)) {
            ExceptionUtil.throwFailException("请输入id");
        }
        if (StringUtil.isEmpty(name)) {
            ExceptionUtil.throwFailException("请输入name");
        }
        if (StringUtil.isEmpty(age)) {
            ExceptionUtil.throwFailException("请输入age");
        }

        //TODO 业务逻辑
    }

    @Override
    public void updateTest(Test record) throws Exception {

        //TODO 业务逻辑
    }
}
