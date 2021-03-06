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
                <form action="/friend/add" method="post">
                    <input type="hidden" name="bid" value="${blog.bid}" />
                    <button type="submit" value="${user.id}" color="blue" name="fid">加好友</button>
                </form>
            </c:if>
            <c:if test="${flag_enable==1}">
                <form action="/friend/delete" method="post">
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
            <!--form放在这里，会传三遍-->
            <!--form action="/comment/delete" method="post"-->
            <c:forEach items="${map}" var="remark" varStatus="n">
                <form action="/comment/delete" method="post">
                *<c:out value="${n.count}" />楼*  <c:out value="${remark.value.name}" />
                    <c:if test="${remark.key.remark_status==1}">
                        <input type="submit" value="删除" />
                        <input type="hidden" name="cid" value="${remark.key.cid}" />
                        <input type="hidden" name="bid" value="${remark.key.bid}" />
                    </c:if>
                <br />
                <c:out value="${remark.key.text}" />
                </form>
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
</table>
<c:if test="${! empty userName}">
    <table align="center">
        <tr>
            <td align="center">
                <form action="/comment/add" method="post">
                    <input type="hidden" name="bid" value="${blog.bid}" />
                    <input type="text" name="comment" />
                    <br/>
                    <input type="submit" value="提交" />
                </form>
            </td>
        </tr>
    </table>
</c:if>
</body>
</html>
