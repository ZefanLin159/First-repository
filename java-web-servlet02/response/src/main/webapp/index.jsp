<html>
<body>
<h2>Hello World!</h2>
<%--这里提交的路径，需要寻找到项目的类路径--%>
<%--${pageContext.request.ContextPath}代表当前的项目--%>
<%--这里还不是很理解，推荐写法？--%>
<form action="${pageContext.request.contextPath}/login" method="get">
    用户名： <input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit">
</form>
</body>
</html>
