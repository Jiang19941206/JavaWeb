<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/12
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>session管理</title>
  </head>
  <body>
    <a href="/session.do?method=sessionMethod">session测试</a>
    <br>
    <a href="/session.do?method=login&userName=jiangcl&pwd=123456">登录</a>
    <br>
    <a href="/session.do?method=repeatLogin">重新登录</a>
    <br>
    <a href="/session.do?method=loginOut">注销</a>
    <br>
    <a href="/session.do?method=goPage">跳转表单</a>
    <br>
    <a href="/verification.do?method=goLoginPage">登录验证</a>
  </body>
</html>
