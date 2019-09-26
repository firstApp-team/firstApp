<%--
  Created by IntelliJ IDEA.
  User: duyuqiang
  Date: 2019/9/22
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="width:100%">
    <tr>
        <td align="left">
            <input type="button" value="主页" onclick="window.location.href='/blog/show'"/>
        </td>
        <td align="right">
            <c:if test="${!empty userName}">
                <form action="/doexit">
                    <input type="submit" value="退出"/>
                </form>
            </c:if>
            <c:if test="${empty userName}">
                <input type="button" value="登录" onclick="window.location.href='/login'"/>
            </c:if>
        </td>
    </tr>
</table>
</body>
</html>
