<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2019-09-15
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新博客</title>
</head>
<body>
<%@ include file="common.jsp"%>
<h2 align="center"><font color="red" />新博客</h2>
<form action="/donewBlog" method="post">
<br/>
        <br/>
    <table align="center">
        <tr>
            <td>标题：</td>
            <td><input type="text" name="bname" /></td>
        </tr>
        <tr>
            <td>文章：</td>
            <td><input type="text" name="text"></td>
        </tr>
        <tr>
            <td align="centre">
                <input type="submit" name="register" value="提交">
            </td>
        </tr>
    </table>

</form>
</body>
</html>
