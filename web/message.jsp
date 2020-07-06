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
                //TODO 传参
                if(request.getSession().getAttribute("user")!=null){
                    username = (String)request.getSession().getAttribute("user");
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

        <div class="message">
            <div class="title"><b>测试</b></div>
            <div class="content">这里我们遇到了一点新东西。你看到的 v-bind attribute 被称为指令。指令带有前缀 v-，以表示它们是 Vue 提供的特殊 attribute。可能你已经猜到了，它们会在渲染的 DOM 上应用特殊的响应式行为。在这里，该指令的意思是：“将这个元素节点的 title attribute 和 Vue 实例的 message property 保持一致”。</div>
            <div class="msg">
                <div class="author"><b>admin</b></div>
                <div class="date"><b>2020-7-6 16:07:00</b></div>
            </div>
            <div class="clear"></div>
        </div>
        <hr>
        <div class="message">
            <div class="title"><b>测试</b></div>
            <div class="content">这里我们遇到了一点新东西。你看到的 v-bind attribute 被称为指令。指令带有前缀 v-，以表示它们是 Vue 提供的特殊 attribute。可能你已经猜到了，它们会在渲染的 DOM 上应用特殊的响应式行为。在这里，该指令的意思是：“将这个元素节点的 title attribute 和 Vue 实例的 message property 保持一致”。</div>
            <div class="msg">
                <div class="author"><b>admin</b></div>
                <div class="date"><b>2020-7-6 16:07:00</b></div>
            </div>
            <div class="clear"></div>
        </div>

        <hr>
        <p class="text-center text-muted">by <a href="https://github.com/Chinajun" target="_blank"><b>cyj</b></a></p>
    </div>
</div>
</body>
</html>
