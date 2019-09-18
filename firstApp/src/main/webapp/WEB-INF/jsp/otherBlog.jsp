<%--
  Created by IntelliJ IDEA.
  User: duyuqiang
  Date: 2019/9/17
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的博客</title>
</head>
<body>
<form action="/dofirend" method="post">
<h2 align="center"><font color="red" />${user.name}</h2>
<table align="center">
    <tr>
        <td><button type="submit" value="${user.id}" color="blue" name="id">加好友</button></td>
    </tr>
    <tr>
        <td>${blog.text}</td>
    </tr>
</table>
</form>
<form action="/doremark" method="post">
    <table align="center">
        <tr>
            <td  align="center">
                <input type="text" name="remark" />
                <br/>
                <input type="submit" value="提交" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
