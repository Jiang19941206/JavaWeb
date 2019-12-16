package com.jiangcl.elementary;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author jiangcl
 * @date 2019/12/16
 * @desc 重定向
 */
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("重定向");
        String attribute = req.getAttribute("myServlet") == null?"":String.valueOf(req.getAttribute("myServlet"));
        System.out.println("Redirect >>>>>>>>>>> " + attribute);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/Json");
        PrintWriter out = resp.getWriter();
        out.println("重定向");
    }
}
