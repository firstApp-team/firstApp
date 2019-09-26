<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: duyuqiang
  Date: 2019/9/10
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body align="center">
<h2>新用户注册</h2>
<form action="/doregist" method="post" align="center">
    <table align="center">
        <tr>
            <td>请输入用户名:</td>
            <td><input type="text" name="name" id="username" autofocus="autofocus"></td>
            <td><span id="msg"></span></td>
        </tr>
        <tr align="right">
            <td>请输入密码:</td>
            <td><input type="text" name=password></td>
        </tr>
        <tr align="right">
            <td>请输入确认密码:</td>
            <td><input type="text" name=queryPassword></td>
        </tr>
    </table>
    <input type="submit" name=register value="注册">
    <input type="reset" name=refill value="重填">
</form>
</body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="application/javascript">
    window.onload=function () {
        //获取要判断的文本框
        var nameElenment = document.getElementById("username");
        //绑定失去焦点事件
        var username=$("#username").val()
        nameElenment.onblur=function () {
            $.ajax({
                url:"/ajax",
                data:{"name":$("#username").val()},
                success:function(data){
                    if(data.result=="true"){//说明改用户已经存在
                        msg.innerHTML="<font color='red'>该用户已存在</font>"
                    }else{
                        msg.innerHTML="恭喜你，可以注册"
                    }
                }
            });
//            var url = "/ajax";
//            $.post(url,name,function(result){
//                if(result.state=="true"){
//                    //跳转到indexUI对应的页面
//                    msg.innerHTML="<font color='red'>该用户已存在</font>"
//                }else{
//                    alert("error");
//                }
//                return false;//防止刷新时重复提交
//            });
        }

        }
</script>
</html>
