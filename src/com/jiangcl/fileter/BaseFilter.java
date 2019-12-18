package com.jiangcl.fileter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jiangcl
 * @date 2019/12/18
 * @desc 创建一个公共的filter，让所有的filter都继承这个filter
 */
public abstract class BaseFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //System.out.println("the base filter init()");
        this.filterConfig = filterConfig;
        init();
    }

    /**
     * 供实现类重写的init方法
     */
    protected void init(){}

    /**
     * 供实现类获取filterConfig的方法
     * @return
     */
    public FilterConfig getFilterConfig(){
        return this.filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        //System.out.println("before base filter doFilter");
        doFilter(request,response,filterChain);
        //System.out.println("after base filter doFilter");
    }

    /**
     * 生命为abstract，只要创建的Filter类继承此Filter，则必须重写此方法
     * @param request
     * @param response
     * @param filterChain
     */
    public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException;

    @Override
    public void destroy() {

    }
}
