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
<%@ include file="common.jsp"%>
<c:if test="${!empty userName}">
<h2 align="center"><font color="red" />我的博客</h2>
<form action="/getBlog" method="post">
    <table align="center">
        <tr>
            <td><input type="button" value="写博客" onclick="window.location.href='/blog/new'" color="blue"/></td>
        </tr>
    </table>
    <br />
</form>
<p>我写过的博客</p>
<c:forEach items="${blog}" var="b">
    <a href="/blog/edit?bid=${b.bid}">
        <c:out value="${b.bname}"></c:out>
    </a>
    <br/>
</c:forEach>
</c:if>
<br/>
<br/>
<br/>
<p>推荐博客</p>
<c:forEach items="${recommendblog}" var="rb">
    <a href="/blog/OtherBlog?bid=${rb.bid}" >
        <c:out value="${rb.bname}"></c:out>
    </a>
    <br />
</c:forEach>

</body>
</html>
