package com.jiangcl.publicservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * @author jiangcl
 * @date 2019/12/16
 * @desc 公共的servlet（多个请求对应一个servlet）
 */
public class BaseServlet extends HttpServlet {

    /**
     * 使所有servlet都继承此servlet
     *      由于每次请求都会执行service方法，所以用反射执行某个servlet里面的某个方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodStr = req.getParameter("method");
        try {
            Method method = this.getClass().getDeclaredMethod(methodStr,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setCharacterEncoding("utf-8");
            PrintWriter out = resp.getWriter();
            out.print(e.toString());
        }
    }
}
