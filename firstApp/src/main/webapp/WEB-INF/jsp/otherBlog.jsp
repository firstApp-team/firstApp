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
<%@ include file="common.jsp"%>
<h2 align="center"><font color="red" />${user.name}</h2>
<table align="center">
    <tr>
        <td>
            <c:set var="flag_enable" scope="session" value="${flag}"/>
            <c:if test="${flag_enable==0}">
                <form action="/dofirend" method="post">
                    <input type="hidden" name="bid" value="${blog.bid}" />
                    <button type="submit" value="${user.id}" color="blue" name="fid">加好友</button>
                </form>
            </c:if>
            <c:if test="${flag_enable==1}">
                <form action="/dodelfirend" method="post">
                    <input type="hidden" name="bid" value="${blog.bid}" />
                    <button type="submit" value="${user.id}" color="blue" name="fid">删好友</button>
                </form>
            </c:if>
        </td>
    </tr>
    <tr>
        <td>${blog.text}</td>
    </tr>
</table>
<table align="center">
    <tr>
        <td align="center">
            <p>评论区</p>
            <br/>
            <form action="/dodelremark" method="post">
            <c:forEach items="${map}" var="remark" varStatus="n">
                *<c:out value="${n.count}" />楼*  <c:out value="${remark.value.name}" />
                    <c:if test="${remark.key.remark_status==1}">
                        <input type="submit" value="删除" />
                        <input type="hidden" name="rid" value="${remark.key.rid}" />
                        <input type="hidden" name="bid" value="${remark.key.bid}" />
                    </c:if>
                <br />
                <c:out value="${remark.key.text}" />
                <br/>
            </c:forEach>
            </form>
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
</table>
<c:if test="${! empty username}">
    <table align="center">
        <tr>
            <td align="center">
                <form action="/doremark" method="post">
                    <input type="hidden" name="bid" value="${blog.bid}" />
                    <input type="text" name="remark" />
                    <br/>
                    <input type="submit" value="提交" />
                </form>
            </td>
        </tr>
    </table>
</c:if>
</body>
</html>
