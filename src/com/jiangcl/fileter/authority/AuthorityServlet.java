package com.jiangcl.fileter.authority;

import com.jiangcl.publicservlet.BaseServlet;
import com.jiangcl.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jiangcl
 * @date 2019/12/18
 * @desc 小练习—权限验证servlet
 */
public class AuthorityServlet extends BaseServlet {

    public void add(HttpServletRequest req, HttpServletResponse resp){
        ResponseUtil.resp(resp,"添加成功");
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp){
        ResponseUtil.resp(resp,"删除成功");
    }

    public void update(HttpServletRequest req, HttpServletResponse resp){
        ResponseUtil.resp(resp,"修改成功");
    }

    public void select(HttpServletRequest req, HttpServletResponse resp){
        ResponseUtil.resp(resp,"查询成功");
    }
}
