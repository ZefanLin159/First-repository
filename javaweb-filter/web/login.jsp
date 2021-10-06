<%--
  Created by IntelliJ IDEA.
  User: LZF
  Date: 2021/9/30
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--这个action提交的表单要和servlet的映射一样 为什么我暂时还不明白--%>
<form action="/servlet/login" method="post">
    用户名:<input type="text" name="username">
    <input type="submit" value="登录">
</form>
</body>
</html>
