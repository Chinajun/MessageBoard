<%--
  Created by IntelliJ IDEA.
  User: 39826
  Date: 2020/7/6
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功界面</title>
</head>
<body>
<div>注册成功</div>
<span id="time">5</span>
<span>秒后回到登陆页</span>
<a href="javascript:back()">返回</a>

<script type="text/javascript">
    var num=document.getElementById("time").innerHTML;
    function count(){
        num--;
        document.getElementById("time").innerHTML=num;
        if(num==0){
            location.assign("/hello/login.jsp");
        }
    }
    setInterval("count()",1000);
    function back(){
        location.assign("/hello/login.jsp");
    }
</script>
</body>
</html>
