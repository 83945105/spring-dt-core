package com.global.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 视图
 * Created by 白超 on 2018-3-14.
 */
@RequestMapping("/view")
@Controller
public class ViewController {

    //演示页面
    @RequestMapping("/demo")
    public String demo() throws Exception {
        return "demo/index";
    }
}
