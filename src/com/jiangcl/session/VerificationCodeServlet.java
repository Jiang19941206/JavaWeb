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
import java.util.Random;

/**
 * @author jiangcl
 * @date 2019/12/17
 * @desc session 之验证码
 */
public class VerificationCodeServlet extends BaseServlet {

    /**
     * @desc 跳转登录页
     * @author jiangcl
     * @date 2019/12/17
     * @param request
     * @param response
     * @return void
     */
    public void goLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取验证码
        String code = getCode();
        HttpSession session = request.getSession();
        //将验证码放入session
        session.setAttribute("verificationCode",code);
        //将验证码返回页面
        request.setAttribute("verificationCode",code);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/sessionLogin");
        requestDispatcher.forward(request,response);
    }

    /**
     * @desc 校验验证码
     * @author jiangcl
     * @date 2019/12/17
     * @param request
     * @param response
     * @return void
     */
    public void checkCode(HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter("userName");
        if(!resMessege(response,userName,"用户名不能为空")){
            return;
        }
        String pwd = request.getParameter("pwd");
        if(!resMessege(response,pwd,"密码不能为空")){
            return;
        }
        //获取表单验证码
        String verificationCode = request.getParameter("verificationCode");
        if(!resMessege(response,verificationCode,"请输入验证码")){
            return;
        }
        //获取session中的验证码
        HttpSession session = request.getSession();
        String sessionValue = session.getAttribute("verificationCode") == null ? "" : (String)session.getAttribute("verificationCode");
        //验证码是否正确
        if(!(!StringUtils.isEmpty(sessionValue) && verificationCode.equals(sessionValue))){
            ResponseUtil.resp(response,"验证码不正确");
            return;
        }
        //验证用户名密码
        if("jiangcl".equals(userName) && "123456".equals(pwd)){
            ResponseUtil.resp(response,"登录成功");
            return;
        }else {
            //如果用户身份信息不正确，则将验证码重新写入session
            ResponseUtil.resp(response,"用户名或密码错误");
            return;
        }
    }

    /**
     * @desc 随机生成验证码
     * @author jiangcl
     * @date 2019/12/17
     * @param
     * @return java.lang.String
     */
    public String getCode(){
        String code = "";
        for(int i = 0; i < 4; i++){
            Random random = new Random();
            int i1 = random.nextInt(10);
            code = code + i1;
        }
        return code;
    }

    public boolean resMessege(HttpServletResponse response,String value,String message){
        if(StringUtils.isEmpty(value)){
            ResponseUtil.resp(response,message);
            return false;
        }else return true;
    }
}
