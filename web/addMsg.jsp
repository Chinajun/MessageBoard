<%@ page import="msg.User" %><%--
  Created by IntelliJ IDEA.
  User: 39826
  Date: 2020/7/7
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增留言界面</title>
    <link rel="stylesheet" href="css/addMsg.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body style="background-color: #123456">
<div class="container">
    <div class="jumbotron bg-white" style="padding: 4rem 4rem">
        <%
            String username = "";
            if(request.getSession().getAttribute("user")!=null){
                User user = (User) request.getSession().getAttribute("user");
                username = user.getUsername();
        %>
        <h1>欢迎<%=username%></h1>
        <h5><br>—— <a href="index.jsp">返回留言板</a></h5>
        <br><hr>
        <form action="/hello/addMsgServlet" method="post" class="fm">
            <div class="title">
                <div class="word">标题</div>
                <input type="text" placeholder="请输入标题" class="inp1" name="title">
            </div>
            <div class="content">
                <div class="word">内容</div>
                <textarea placeholder="请输入内容" class="inp2" name="content"></textarea>
            </div>
            <input type="submit" value="发布" class="btn btn-info">
            <%
                String msg = "";
                if(request.getAttribute("msg")!=null){
                    msg = (String)request.getAttribute("msg");
                }
            %>
            <p style="color: red"><%=msg %></p>
        </form>
        <%
        }else{
        %>
        <h1>欢迎来到我的留言板</h1>
        <p></p>
        <h5><a href="login.jsp">登录</a>后发表留言</h5>
        <br>
        <%
            }
        %>
        <hr>
        <p class="text-center text-muted">by <a href="https://github.com/Chinajun" target="_blank"><b>cyj</b></a></p>
    </div>
</div>
</body>
</html>
