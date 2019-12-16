package com.jiangcl.publicservlet;

import com.jiangcl.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jiangcl
 * @date 2019/12/16
 * @desc
 */
public class RoleServlet extends BaseServlet {

    public void addRole(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("添加角色");
        ResponseUtil.resp(resp,"添加角色成功");
    }

    public void updateRole(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("更新角色");
        ResponseUtil.resp(resp,"更新角色成功");
    }
}
