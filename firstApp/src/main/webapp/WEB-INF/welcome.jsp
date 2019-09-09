<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<body>
<!-- 输出普通字符 -->
${message } <br/>
<!-- 输出List -->
<p>书籍列表</p>
<c:forEach items="${bookList}" var="node">
    <c:out value="${node}"></c:out>
</c:forEach>
<br/>
<br/>

${user }<br/>
<br/>
<table border="1">
    <tr>
        <th>Month</th>
        <th>Savings</th>
    </tr>
    <tr>
        <td>${user.name }</td>
        <td>${user.id }</td>
    </tr>
</table>
<br/>
<br/>
<!-- 输出Map -->
<c:forEach items="${map}" var="node">
    姓名：<c:out value="${node.key}"></c:out>
    住址：<c:out value="${node.value}"></c:out>
    <br/>
</c:forEach>
</body>
</body>
</html>