package com.yxyc.springbootrestful.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("name");
        if(name!=null){
            return true;
        }
        request.setAttribute("mesg","没有权限登录");
        request.getRequestDispatcher("/hello").forward(request,response);
        return false;
    }
}
