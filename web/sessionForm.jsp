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
    <title>session表单</title>
  </head>
  <body>
    <form action="/session.do?method=checkRepeat" method="post">
      <input type="hidden" value="<%= request.getAttribute("token") %>" name="token">
      请输入信息：<input value="info" type="text" name="info">
      <input type="submit" value="提交">
    </form>
  </body>
</html>
