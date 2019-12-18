package com.jiangcl.fileter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jiangcl
 * @date 2019/12/18
 * @desc 验证公共filter（主要是搞清楚逻辑和流程）
 *
 * 执行流程
 *  1、初始化，过滤器加载时会先执行BaseFilter的init(FilterConfig filterConfig)方法，
 *              若实现类filter中重写了BaseFilter的init()，则还会调用重写的init()。
 *  2、执行doFilter()时，先进入BaseFilter的doFilter()方法，然后通过BaseFilter的doFilter()方法调用实现类的doFilter()方法
 */
public class BaseTestFilter extends BaseFilter {

    /*
    可以通过重写BaseFilter中的init()方法，在初始化过滤器时进行想要的逻辑处理
    @Override
    protected void init() {
        System.out.println("the test filter init()");
        //通过BaseFilter的getFilterConfig()方法获取FilterConfig
        FilterConfig filterConfig = getFilterConfig();
    }*/

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("before the test filter doFilter");
        filterChain.doFilter(request,response);
        System.out.println("after the test filter doFilter");
    }
}
