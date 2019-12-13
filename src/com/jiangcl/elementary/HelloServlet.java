package com.jiangcl.elementary;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author jiangcl
 * @date 2019/12/13
 * @desc
 */
public class HelloServlet implements Servlet {

    public HelloServlet(){
        System.out.println("***********构造器***********");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //获取ServletContext
        ServletContext context = servletConfig.getServletContext();
        //获取当前web应用的初始化参数
        String user = context.getInitParameter("user");
        String password = context.getInitParameter("password");
        System.out.println("user：" + user);
        System.out.println("password：" + password);
        System.out.println("***********servlet innit***********");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("***********servlet config***********");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("***********service***********");
    }

    @Override
    public String getServletInfo() {
        System.out.println("***********servlet info***********");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("***********destroy***********");
    }
}
