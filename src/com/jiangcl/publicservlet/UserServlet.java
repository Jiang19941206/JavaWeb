package com.jiangcl.publicservlet;

import com.jiangcl.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jiangcl
 * @date 2019/12/16
 * @desc
 */
public class UserServlet extends BaseServlet {

    public void addUser(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("添加用户");
        ResponseUtil.resp(resp,"添加用户成功");
    }

    public void updateUser(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("更新用户");
        ResponseUtil.resp(resp,"更新用户成功");
    }
}
