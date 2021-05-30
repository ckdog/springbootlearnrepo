package com.yxyc.springbootrestful.Service;

import java.io.InputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileUploadDownService {

    public void filedown(HttpServletRequest request, HttpServletResponse response){
        ServletContext servletContext = request.getServletContext();
        String filename ="";
        System.out.println("context path: "+servletContext.getContextPath());
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Content-Type","application/octet-stream");
        response.setHeader("Content-Type","attachment;filename="+filename);
        InputStream resourceAsStream = request.getServletContext().getResourceAsStream(filename);

    }
}
