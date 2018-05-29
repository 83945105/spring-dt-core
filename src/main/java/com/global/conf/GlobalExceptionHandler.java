package com.global.conf;

import com.avalon.holygrail.ss.exception.NeedLoginException;
import com.avalon.holygrail.ss.exception.NoAuthorityException;
import com.avalon.holygrail.ss.exception.NotFoundException;
import com.avalon.holygrail.ss.exception.ResultException;
import com.avalon.holygrail.ss.util.DataViewUtil;
import com.avalon.holygrail.ss.view.DataView;
import com.avalon.holygrail.ss.view.ExceptionView;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 * Created by 白超 on 2018-1-20.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @Value("${web.exception.default-message}")
    private String defaultMessage;

    //404异常
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    DataView NotFound(HttpServletRequest request, NotFoundException ex) throws Exception {

        ExceptionView view = new ExceptionView(ex.getResultInfo());

        return view;
    }

    //需要登录
    @ExceptionHandler(NeedLoginException.class)
    @ResponseBody
    DataView NeedLogin(HttpServletRequest request, NeedLoginException ex) throws Exception {

        ExceptionView view = new ExceptionView(ex.getResultInfo());

        return view;
    }

    //无权
    @ExceptionHandler(NoAuthorityException.class)
    @ResponseBody
    DataView NoAuthority(HttpServletRequest request, NoAuthorityException ex) throws Exception {

        ExceptionView view = new ExceptionView(ex.getResultInfo());

        return view;
    }

    @ExceptionHandler(ResultException.class)
    @ResponseBody
    DataView Result(HttpServletRequest request, ResultException ex) throws Exception {

        ExceptionView view = new ExceptionView(ex.getResultInfo());

        return view;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    DataView ExceptionHandler(HttpServletRequest request, Exception ex) throws Exception {
        ex.printStackTrace();
        return DataViewUtil.getMessageViewError(defaultMessage);

    }

}
