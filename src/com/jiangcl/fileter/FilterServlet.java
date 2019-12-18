package com.jiangcl.fileter;

import com.jiangcl.publicservlet.BaseServlet;
import com.jiangcl.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jiangcl
 * @date 2019/12/18
 * @desc 过滤器servlet
 */
public class FilterServlet extends BaseServlet {

    /**
     * @desc 验证过滤器的执行流程（配合HelloFilter实现）
     *         1、执行对应filter中doFilter()方法之前的逻辑
     *         2、执行servlet中对应的方法
     *         3、执行对应filter中doFilter()方法之后的逻辑
     * @author jiangcl
     * @date 2019/12/18
     * @param req
     * @param resp
     * @return void
     */
    public void filterStep(HttpServletRequest req, HttpServletResponse resp){
        //System.out.println("before response");
        ResponseUtil.resp(resp,"filter servlet response");
        //System.out.println("after response");
    }
}
