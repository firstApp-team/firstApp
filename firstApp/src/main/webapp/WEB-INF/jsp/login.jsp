<%--
  Created by IntelliJ IDEA.
  User: duyuqiang
  Date: 2019/9/10
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<h2 align="center"><font color="red" />用户登录页面</h2>
<form action="success.jsp" method="post">
    <table align="center" border="1">
    <tr>
        <td>用户名:</td>
        <td><input type="text" name="name"></td>
    </tr>
    <tr>
        <td>密&nbsp;&nbsp;码:</td>
        <td><input type="text" name="password"></td>
    </tr>
    <tr>
        <td><input type="submit" value="登录" name="login"></td>
        <td><input type="reset" value="重置" name="reset"></td>
    </tr>
    </table>
    <p align="center"><a href="register" color=blue>注册用户</a></p>
</form>
</body>
</html>
