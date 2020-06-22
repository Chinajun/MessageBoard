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
</head>
<body>
<div class="login">
    <form action="/hello/login" method="post">
        <table>
            <tr>
                <td class="td1">用户名</td>
                <td><input type="text" class="input1" name="username"></td>
            </tr>
            <tr>
                <td class="td1">密码</td>
                <td><input type="password" class="input1" name="password"></td>
            </tr>
            <%
                String msg = "";
                if(request.getAttribute("msg")!=null){
                    msg = (String)request.getAttribute("msg");
                }
            %>
            <h3 style="color: red"><%=msg %></h3>
            <tr>
                <td colspan="2">
                    <div class="btn-red">
                        <input type="submit" value="登录" id="login-btn">
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
