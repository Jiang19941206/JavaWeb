package com.jiangcl.elementary;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author jiangcl
 * @date 2019/12/16
 * @desc httpServlet转发和重定向
 */
public class MyHttpServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("myServlet");
        String method = req.getParameter("method");
        /**
         * 转发的Request对象和中转的Request是同一个对象
         * 重定向的Request对象和中转的Request不是同一个对象
         */
        req.setAttribute("myServlet","这是我的转发和重定向测试");
        String attribute = req.getAttribute("myServlet") == null?"":String.valueOf(req.getAttribute("myServlet"));
        System.out.println("myServlet >>>>>>>>>>> " + attribute);
        //转发
        if("forWard".equals(method)){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/forWardServlet");
            requestDispatcher.forward(req,resp);
        }else if("redirect".equals(method)){
            //重定向
            resp.sendRedirect("/redirectServlet");
        }else {
            resp.sendRedirect("/index1");
        }

    }


}
