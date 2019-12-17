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
    <form action="/verification.do?method=checkCode" method="post">
      用户名：<input value="" type="text" name="userName"><br>
      密&nbsp;&nbsp;&nbsp;码：<input value="" type="text" name="pwd"><br>
      验证码：<input value="${verificationCode}" type="text" name="verificationCode">
      <input type="submit" value="提交">
    </form>
  </body>
</html>
