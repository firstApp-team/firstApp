<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2019-09-13
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 align="center"><font color="red" />我的博客</h2>
<form action="/getBlog" method="post">
    <table align="center">
        <tr>
            <td><input type="button" value="写博客" onclick="window.location.href='newBlog'" color="blue"/></td>
            <td><input type="button" value="加好友" /></td>
        </tr>
    </table>
    <br />
    <p>我写过的博客</p>
    <c:forEach items="${map}" var="blog">
        <c:out value="${blog.value}"></c:out>
        <c:url value="${blog.key}"></c:url>
        <br/>
    </c:forEach>
</form>
</body>
</html>
