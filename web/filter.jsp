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
    <title>filter管理</title>
  </head>
  <body>
    <a href="/filter.do?method=filterStep">过滤器Servlet</a>
    <br>
    <form action="/authority.do" method="post">
      请输入用户名：<input type="text" value="" name="userName">
      <br>
      <br>
      请选择操作：
      <select name="method">
        <option value ="add">增加</option>
        <option value ="delete">删除</option>
        <option value="update">修改</option>
        <option value="select">查询</option>
      </select>
      <br>
      <input type="submit" value="提交">
    </form>
  </body>
</html>
