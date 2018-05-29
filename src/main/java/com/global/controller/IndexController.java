package com.global.controller;

import com.avalon.holygrail.ss.util.DataViewUtil;
import com.avalon.holygrail.ss.util.ExceptionUtil;
import com.avalon.holygrail.ss.view.DataView;
import com.avalon.holygrail.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 白超 on 2018-3-15.
 */
@RequestMapping("/")
@Controller
public class IndexController {

    //首页
    @RequestMapping("/")
    public String index() throws Exception {
        return "redirect:/view/login";
    }

    //登录
    @RequestMapping("/post/login")
    @ResponseBody
    public DataView login(String username, String password, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (StringUtil.isEmpty(username)) {
            ExceptionUtil.throwFailException("用户名不能为空");
        }
        if (StringUtil.isEmpty(password)) {
            ExceptionUtil.throwFailException("密码不能为空");
        }

        /*模拟一个用户开始,实际开发请根据自己业务编写登录*/
        Map<String, Object> user = new HashMap<>();
        user.put("id", 1024);
        user.put("username", username);
        /*模拟一个用户结束*/

        /*登录后的操作,需要写入cookie*/
        HttpSession session = request.getSession();
        Serializable sessionId = session.getId();
        request.setAttribute("token", sessionId.toString());
        Cookie cookie = new Cookie("token", sessionId.toString());
        cookie.setMaxAge(-1);
        cookie.setPath("/");
        response.addCookie(cookie);

        session.setAttribute("user", user);

        return DataViewUtil.getModelViewSuccess(sessionId);
    }


}
