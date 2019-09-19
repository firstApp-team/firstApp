<%--
  Created by IntelliJ IDEA.
  User: duyuqiang
  Date: 2019/9/17
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>我的博客</title>
</head>
<body>

<h2 align="center"><font color="red" />${user.name}</h2>
<table align="center">
    <tr>
        <td>
                <c:set var="flag_enable" scope="session" value="${flag}"/>
                <c:if test="${flag_enable==0}">
                    <form action="/dofirend" method="post">
                        <button type="submit" value="${user.id}" color="blue" name="id">加好友</button>
                    </form>
                </c:if>
                <c:if test="${flag_enable==1}">
                    <form action="/dodelfirend" method="post">
                        <button type="submit" value="${user.id}" color="blue" name="id">删好友</button>
                    </form>

                </c:if>
                </td>

    </tr>
    <tr>
        <td>${blog.text}</td>
    </tr>
</table>
<form action="/doremark" method="post">
    <table align="center">
        <tr>
            <td align="center">
                <p>评论区</p>
                <br/>
                <c:forEach items="${map}" var="remark">
                    *<c:out value="${remark.key}" />*
                    <br/>
                    <c:out value="${remark.value}" />
                    <br/>
                </c:forEach>
            </td>
        </tr>
        <br />
        <tr/>
        <br />
        <tr/>
        <br />
        <tr/>
        <br />
        <tr/>
        <br />
        <tr/>
        <br />
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
