<%--
  Created by IntelliJ IDEA.
  User: 39826
  Date: 2020/7/5
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>
<div class="register">
    <div class="header">
        <h1>
            <a href="login.jsp">登录</a>
            <a href="register.jsp">注册</a>
        </h1>
    </div>
    <form action="/hello/registerServlet" method="post">
        <div class="name">
            <p>用户名</p>
            <input type="text" id="name" name="username" placeholder="请输入用户名">
            <p></p>
        </div>
        <div class="pwd">
            <p>密码</p>
            <input type="password" id="pwd" name="password" placeholder="请输入密码">
            <p></p>
        </div>
        <div class="real">
            <p>真实姓名</p>
            <input type="text" id="real" name="realName" placeholder="请输入真实姓名">
            <p></p>
        </div>
        <div class="phone">
            <p>电话号码</p>
            <input type="text" id="phone" name="phone" placeholder="请输入电话号码">
            <p></p>
        </div>
        <div class="btn">
            <input type="submit" value="注册" id="register-btn">
        </div>
    </form>
</div>
</body>
</html>
