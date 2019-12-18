package com.jiangcl.fileter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author jiangcl
 * @date 2019/12/17
 * @desc
 */
public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //System.out.println("hello filter init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*
        过滤器禁用浏览器缓存
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        response.setDateHeader("Expires",01);
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");*/

        /*
        利用过滤器进行字符编码过滤
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        request.setCharacterEncoding("utf-8");*/

        //System.out.println("before filter doFilter");
        filterChain.doFilter(servletRequest,servletResponse);
        //System.out.println("after filer doFilter");
    }

    @Override
    public void destroy() {
        //System.out.println("filter destroy");
    }
}
