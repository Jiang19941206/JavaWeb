package com.jiangcl.elementary;

import com.alibaba.druid.util.StringUtils;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author jiangcl
 * @date 2019/12/13
 * @desc
 */
public class LoginServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String returnStr = "登录成功";
        if(!StringUtils.isEmpty(userName) && !userName.equals("root")){
            returnStr = "用户名错误";
        }if(!StringUtils.isEmpty(password) && !password.equals("123456")){
            returnStr = "密码错误";
        }
        //设置响应的类型
        //response.setContentType("");
        //解决中文乱码
        response.setCharacterEncoding("utf-8");
        //响应数据
        PrintWriter printWriter = response.getWriter();
        printWriter.print(returnStr);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
