package com.jiangcl.session;

import com.jiangcl.publicservlet.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author jiangcl
 * @date 2019/12/16
 * @desc
 */
public class SessionServlet extends BaseServlet {

    public void sessionMethod(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        session.invalidate();
        String id = session.getId();
    }
}
