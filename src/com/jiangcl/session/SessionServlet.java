package com.jiangcl.session;

import com.alibaba.druid.util.StringUtils;
import com.jiangcl.publicservlet.BaseServlet;
import com.jiangcl.util.ResponseUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author jiangcl
 * @date 2019/12/16
 * @desc session
 */
public class SessionServlet extends BaseServlet {

    public void sessionMethod(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        System.out.println(session.isNew());
        String id = session.getId();
        System.out.println(id);
        //销毁session
        //session.invalidate();
    }

    /**
     * 登录，将登录信息存到session中
     * @param req
     * @param res
     */
    public void login(HttpServletRequest req, HttpServletResponse res){
        String userName = req.getParameter("userName");
        String pwd = req.getParameter("pwd");

        HttpSession session = req.getSession();
        session.setAttribute("userName",userName);
        ResponseUtil.resp(res,"欢迎：" + userName);
    }

    /**
     * 重新登录，从session中取出已存在的登录信息
     * @param req
     * @param res
     */
    public void repeatLogin(HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession();
        String userName = session.getAttribute("userName") == null ? "":(String)session.getAttribute("userName") ;
        ResponseUtil.resp(res,"欢迎：" + userName);
    }

    /**
     * 注销登录，将session销毁
     * @param req
     * @param res
     */
    public void loginOut(HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession();
        String userName = session.getAttribute("userName") == null ? "":(String)session.getAttribute("userName") ;
        ResponseUtil.resp(res,"Bye：" + userName);
        //销毁session
        session.invalidate();
    }

    /**
     * session 防止请求响应不及时导致表单重复提交
     *          1、随机生成一个token值，将token放入session中，并将token返回到页面
     *          2、表单提交时，将token值传到后台，同时在后台从session中取出token，
     *              如果session中的token不为空且值与页面传过来的token一致，则表明是第一次提交，然后删除session中的token。
     *              如果session中已经没有token或者token值与页面传过来的不一致，则表明表单在进行重复提交。
     */

    /**
     * @desc 跳转页面
     * @author jiangcl
     * @date 2019/12/17
     * @param req
     * @param res
     * @return void
     */
    public void goPage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        HttpSession session = req.getSession();
        //使用sessionId作为token
        String sessionId = session.getId();
        session.setAttribute("token",sessionId);
        //将token传回页面
        req.setAttribute("token",sessionId);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/sessionForm");
        requestDispatcher.forward(req,res);
    }

    /**
     * @desc 验证表单是否重复提交
     * @author jiangcl
     * @date 2019/12/17
     * @param req
     * @param res
     * @return void
     */
    public void checkRepeat(HttpServletRequest req, HttpServletResponse res){
        //获取表单提交的token
        String parameter = req.getParameter("token");
        //获取session中的token
        HttpSession session = req.getSession();
        String token = session.getAttribute("token") == null ? "" : (String) session.getAttribute("token");
        //验证token是否存在
        if(!StringUtils.isEmpty(token) && token.equals(parameter)){
            //如果存在则表明表单是首次提交，此时从session中移除token
            session.removeAttribute("token");
        }else {
            //如果不存在则表明表单已经提交过了
            ResponseUtil.resp(res,"请勿重复提交表单！");
            return;
        }
        //暂停一分钟模拟响应不及时
        try {
            Thread.sleep(60l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
