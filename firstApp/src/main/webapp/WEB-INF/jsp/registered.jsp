<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: duyuqiang
  Date: 2019/9/10
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body align="center">
<h2>新用户注册</h2>
<form action="/doregist" method="post" align="center">
    <table align="center">
        <tr>
            <td>请输入用户名:</td>
            <td><input type="text" name=name autofocus="autofocus"></td>
        </tr>
        <tr align="right">
            <td>请输入密码:</td>
            <td><input type="text" name=password></td>
        </tr>
        <tr align="right">
            <td>请输入确认密码:</td>
            <td><input type="text" name=querypassword></td>
        </tr>
    </table>
    <input type="submit" name=register value="注册">
    <input type="reset" name=refill value="重填">
</form>
</body>
</html>
