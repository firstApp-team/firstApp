<%--
  Created by IntelliJ IDEA.
  User: duyuqiang
  Date: 2019/9/16
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改博客</title>
</head>
<body>
<h2 align="center"><font color="red" />修改博客</h2>
<form action="/doeditBlog" method="post">
<br/>
    <br/>
    <table align="center">
        <tr>
            <td>标题：</td>
            <td><input type="text" name="bname" value="${blog.bname}"/></td>
        </tr>
        <tr>
            <td>文章：</td>
            <td><input type="text" name="text" value="${blog.text}"></td>
        </tr>
    </table>
    <input type="submit" name=register value="提交">
</form>
</body>
</html>
