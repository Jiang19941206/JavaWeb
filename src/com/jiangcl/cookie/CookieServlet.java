package com.jiangcl.cookie;

import com.jiangcl.publicservlet.BaseServlet;
import com.jiangcl.util.ResponseUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author jiangcl
 * @date 2019/12/16
 * @desc cookie
 */
public class CookieServlet extends BaseServlet {

    /**
     * @desc cookie模拟
     * @author jiangcl
     * @date 2019/12/16
     * @param req
     * @param resp
     * @return void
     */
    public void cookieMethod(HttpServletRequest req, HttpServletResponse resp){
        //创建一个cookie对象
        Cookie cookie = new Cookie("user", "root");
        cookie.setMaxAge(600);
        Cookie cookie1 = new Cookie("pwd", "123456");
        //将cookie传给浏览器
        resp.addCookie(cookie);
        resp.addCookie(cookie1);
    }

    /**
     * @desc cookie模拟自动登录
     *      访问首页，如果未登录过则提示用户登录
     *                如果登录过，则使用cookie实现自动登录
     * @author jiangcl
     * @date 2019/12/16
     * @param
     * @return void
     */
    public void accessHome(HttpServletRequest req, HttpServletResponse resp){
        //获取cookie
        Cookie[] cookies = req.getCookies();
        boolean flag = false;//定义一个参数，判断cookie中是否有用户信息
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                if("userName".equals(name) && "jiangcl".equals(value)){
                    flag = true;
                    ResponseUtil.resp(resp,"成功进入首页");
                    break;
                }

            }
        }
        //如果没有cookie信息，则提示登录，并将用户信息放入cookie
        if(!flag){
            Cookie cookie = new Cookie("userName", "jiangcl");
            cookie.setMaxAge(60);
            //设置cookie的作用路径
            cookie.setPath(req.getRequestURI());
            resp.addCookie(cookie);
            ResponseUtil.resp(resp,"请登录");
        }
    }
}
