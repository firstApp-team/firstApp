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
<p>推荐博客</p>
<c:forEach items="${recommendblog}" var="rb">
    <a href="OtherBlog?bid=${rb.bid}" >
        <c:out value="${rb.bname}"></c:out>
    </a>
    <br />
</c:forEach>
</body>
</html>
