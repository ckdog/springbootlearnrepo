package com.yxyc.springbootrestful.controller;

import com.yxyc.springbootrestful.exception.UserNotFoundException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyErrorExceptionHandler  {

    @ExceptionHandler(UserNotFoundException.class)
    public String handlerException(HttpServletRequest request){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("code","444");
        errorMap.put("msg","user not found");
        //错误码放在request中，这样才能找到我们制定的错误页面
        request.setAttribute("javax.servlet.error.status_code",500);
        request.setAttribute("error",errorMap);
        //通过请求转发跳转到basicerrorExceptionHandler自适应html、json数据处理
        return "forward:/error";
    }
}
