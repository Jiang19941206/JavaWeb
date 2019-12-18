package com.jiangcl.fileter.authority;

import com.alibaba.druid.util.StringUtils;
import com.jiangcl.fileter.BaseFilter;
import com.jiangcl.util.ResponseUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangcl
 * @date 2019/12/18
 * @desc 小练习—权限验证Filter
 */
public class AuthorityFilter extends BaseFilter {

    /**
     * 定义一个管理员账号集合
     */
    private Map<String,String> map = new HashMap<>();

    /**
     * 初始化账号和权限
     */
    @Override
    protected void init() {
        map.put("admin","add、delete、update、select");
        map.put("jiangcl","add、select");
        map.put("zhangsan","select");
        map.put("tom","select");
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //获取用户名和其对应的权限
        String userName = request.getParameter("userName");
        if(StringUtils.isEmpty(userName)){
            ResponseUtil.resp(response,"请输入用户名");
            return;
        }
        String userAuthority = map.get(userName);
        //判断账号是否存在
        if(StringUtils.isEmpty(userAuthority)){
            ResponseUtil.resp(response,"账号不存在，请重新输入");
            return;
        }else {
            //当账号存在时，判断该账号是否有相应的操作权限
            String method = request.getParameter("method");
            //如果有对应的权限则放行
            if(userAuthority.contains(method)){
                filterChain.doFilter(request,response);
            }else {
                //如果没有权限则给出提示
                String operation = operation(method);
                ResponseUtil.resp(response,"对不起，您没有‘" + operation + "’操作权限");
            }
        }
    }


    public String operation(String method){
        String operation = "";
        switch (method){
            case "add":
                operation = "添加";
                break;
            case "delete":
                operation = "删除";
                break;
            case "update":
                operation = "更新";
                break;
            case "select":
                operation = "查询";
                break;
             default:
                 operation = "";
                 break;
        }
        return operation;
    }
}
