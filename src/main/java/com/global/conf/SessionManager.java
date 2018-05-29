package com.global.conf;

import com.avalon.holygrail.ss.util.ExceptionUtil;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

/**
 * session管理器
 * Created by 白超 on 2018-3-22.
 */
@Component
@WebFilter(urlPatterns = "/", filterName = "sessionFilter")
@WebListener
public class SessionManager implements Filter, HttpSessionListener, HandlerInterceptor {

    private static Map<String, HttpSession> SESSIONS = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        RequestFacade req = (RequestFacade) request;
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            chain.doFilter(request, response);
            return;
        }
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())) {
                HttpSession session = SESSIONS.get(cookie.getValue());
                if (session == null) {
                    continue;
                }
                Enumeration<String> enumeration = session.getAttributeNames();
                while (enumeration.hasMoreElements()) {
                    String name = enumeration.nextElement();
                    req.setAttribute(name, session.getAttribute(name));
                    req.setAttribute("session", session);
                }
                break;
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        session.setMaxInactiveInterval(24 * 60 * 60);
        SESSIONS.put(session.getId(), session);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        SESSIONS.remove(session.getId());
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
/*        if (path.startsWith("/jp")) {//放行静态资源
            return true;
        }*/
        if ("/error".equals(path) || "/login".equals(path) || "/view/login".equals(path)) {
            return true;
        }
        if (request.getAttribute("user") == null) {
            ExceptionUtil.throwNeedLoginException("该操作需要登陆后进行");
        }
        return true;
    }
}
