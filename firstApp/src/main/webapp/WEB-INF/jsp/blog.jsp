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
<c:forEach items="${user}" var="u" >
<input type="text" id="${u.id}" value="${u.name}" hidden="hidden"/>
</c:forEach>
<%@ include file="common.jsp"%>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="application/javascript">
            var a = $(" input[ type='text' ] ").val()
            rs=confirm(a+"请求加你好友")
            window.onload=function () {
                $.ajax({
                    url:"/queryFriend",
                    data:{"rs":rs}
                });
            }
</script>


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

<c:if test="${!empty userName}">
    <p>我的好友</p>
    <c:forEach items="${friends}" var="f">
        <a href="/blog/show?uid=${f.id}">
            <c:out value="${f.name}"></c:out>
        </a>
        <br/>
    </c:forEach>
</c:if>

</body>
</html>
