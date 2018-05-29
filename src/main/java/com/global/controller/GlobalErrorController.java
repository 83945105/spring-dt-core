package com.global.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 错误处理
 * Created by 白超 on 2018-3-15.
 */
@Controller
public class GlobalErrorController implements ErrorController {

    private final static String ERROR_PATH = "/error";

    @RequestMapping(ERROR_PATH)
    public String error(Model model, HttpServletRequest request) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
        model.addAttribute("basePath", basePath);
        model.addAttribute("errorMessageTitle", "非常抱歉");
        model.addAttribute("errorMessageContent", "您要访问的页面不存在");
        return getErrorPath();
    }

    @Override
    public String getErrorPath() {
        return "error/404";
    }
}
