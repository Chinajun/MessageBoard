<%--
  Created by IntelliJ IDEA.
  User: 39826
  Date: 2020/6/22
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<div class="login">
    <div class="header">
        <h1>
            <a href="">登录</a>
            <a href="">注册</a>
        </h1>
    </div>
    <form action="" method="post">
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
        <div class="btn">
            <input type="submit" value="登录" id="login-btn">
        </div>
    </form>
</div>
</body>
</html>
