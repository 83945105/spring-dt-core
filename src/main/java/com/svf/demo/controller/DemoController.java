package com.svf.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.avalon.holygrail.ss.util.DataViewUtil;
import com.avalon.holygrail.ss.util.ExceptionUtil;
import com.avalon.holygrail.ss.view.DataView;
import com.avalon.holygrail.util.StringUtil;
import com.svf.demo.bean.Test;
import com.svf.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 演示接口
 * Created by 白超 on 2018/4/12.
 */
@RequestMapping("/demo")
@Controller
public class DemoController {

    @Autowired
    private DemoService DemoService;

    //获取用户信息
    @RequestMapping("/get/userInfo")
    @ResponseBody
    public DataView getUserInfo(HttpServletRequest request) throws Exception {

        Map<String, Object> user = (Map<String, Object>) request.getAttribute("user");
        if (user == null) {
            ExceptionUtil.throwNeedLoginException("该操作需要登陆后进行");
        }

        return DataViewUtil.getModelViewSuccess(user);
    }


    /**
     * get请求
     * 获取指定ID信息
     * 根据唯一标识获取唯一数据时,将标识写到路径中
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/get/test/{id}")
    @ResponseBody
    public DataView getTest(@PathVariable String id) throws Exception {

        //TODO 写你的业务调用

        return DataViewUtil.getMessageViewSuccess("成功获取id：" + id + " 的数据");
    }

    /**
     * get请求
     * 条件查询多条数据
     * 根据若干(必要或非必要)条件查询数据时,?传参
     *
     * @param name
     * @param age
     * @return
     * @throws Exception
     */
    @RequestMapping("/get/testList")
    @ResponseBody
    public DataView getTestList(String name, @RequestParam(required = false) String age) throws Exception {

        if (StringUtil.isEmpty(name)) {
            ExceptionUtil.throwFailException("请输入您要查询的name");
        }

        //TODO 写你的业务调用

        return DataViewUtil.getMessageViewSuccess("成功获取name：" + name + " age：" + age + " 的数据");
    }

    /**
     * post请求
     * 新增数据时使用
     *
     * @param id
     * @param name
     * @param age
     * @return
     * @throws Exception
     */
    @RequestMapping("/post/test")
    @ResponseBody
    public DataView postTest(String id, String name, String age) throws Exception {

        this.DemoService.addTest(id, name, age);

        return DataViewUtil.getMessageViewSuccess("成功新增id：" + id + " 的数据");
    }

    /**
     * post请求
     * 批量新增数据接收json后解析
     *
     * @param json
     * @return
     * @throws Exception
     */
    @RequestMapping("/post/testList")
    @ResponseBody
    public DataView postTestList(String json) throws Exception {

        List<Test> records = JSONArray.parseArray(json, Test.class);

        //TODO 写你的业务调用

        return DataViewUtil.getMessageViewSuccess("批量新增：" + records.size() + "条数据成功");
    }

    /**
     * put请求
     * 更新唯一一条数据
     * 数据唯一标识通过地址栏传参
     * 更新数据隐式传参
     *
     * @param id
     * @param name
     * @param age
     * @return
     * @throws Exception
     */
    @RequestMapping("/put/test/{id}")
    @ResponseBody
    public DataView putTest(@PathVariable String id, String name, String age) throws Exception {

        Test record = new Test();

        record.setId(id);
        record.setName(name);
        record.setAge(age);

        this.DemoService.updateTest(record);

        return DataViewUtil.getMessageViewSuccess("成功更新id：" + id + " 的数据");
    }

    /**
     * put请求
     * 批量更新数据
     * 使用json传参后解析
     *
     * @param json
     * @return
     * @throws Exception
     */
    @RequestMapping("/put/testList")
    @ResponseBody
    public DataView putTestList(String json) throws Exception {

        List<Test> records = JSONArray.parseArray(json, Test.class);

        //TODO 写你的业务调用

        return DataViewUtil.getMessageViewSuccess("批量更新：" + records.size() + "条数据成功");
    }

    /**
     * delete 请求
     * 删除唯一一条记录
     * 数据唯一标识通过地址栏传参
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete/test/{id}")
    @ResponseBody
    public DataView deleteTest(@PathVariable String id) throws Exception {

        //TODO 写你的业务调用

        return DataViewUtil.getMessageViewSuccess("成功删除id：" + id + " 的数据");
    }

    /**
     * delete 请求
     * 删除多条记录
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete/testList")
    @ResponseBody
    public DataView deleteTestList(String[] ids) throws Exception {

        //TODO 写你的业务调用

        return DataViewUtil.getMessageViewSuccess("批量删除：" + ids.length + "条数据成功");
    }

    //用于测试请求时间
    @RequestMapping("/get/delay/{timeout}")
    @ResponseBody
    public DataView getDelay(@PathVariable Long timeout) throws Exception {

        Thread.sleep(timeout);

        return DataViewUtil.getMessageViewSuccess();
    }
}
