<%@ page import="msg.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 39826
  Date: 2020/7/5
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言板界面</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/message.css">
</head>
<body style="background-color: #123456">
<div class="container">
    <div class="jumbotron bg-white" style="padding: 4rem 4rem">
        <div class="header">
            <%
                String username = "";
                if(request.getSession().getAttribute("user")!=null){
                    User user = (User) request.getSession().getAttribute("user");
                    username = user.getUsername();
            %>
            <h1>欢迎<%=username%></h1>
            <h5><br>—— 留下你想说的话吧</h5>
            <br><hr>
            <%
                }else{
            %>
            <h1>欢迎来到我的论坛</h1>
            <p></p>
            <h5><a href="login.jsp">登录</a>后发表留言</h5>
            <br><hr>
            <%
                }
            %>
        </div>
        <c:forEach items="${list}" var="msg">
            <div class="message">
                <div class="title"><b>${msg.title}</b></div>
                <div class="content">${msg.content}</div>
                <div class="msg">
                    <div class="author"><b>${msg.username}</b></div>
                    <div class="date"><b>${msg.createTime}</b></div>
                </div>
                <div class="clear"></div>
            </div>
            <hr>
        </c:forEach>
        <p class="text-center text-muted">by <a href="https://github.com/Chinajun" target="_blank"><b>cyj</b></a></p>
    </div>
</div>
</body>
</html>
