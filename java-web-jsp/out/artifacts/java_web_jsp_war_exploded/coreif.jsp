
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl核心标签--%>
<%--tomcat丢失jstl standard标签 非常难以发现的一个问题--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>if测试</h4>
<hr>
<form action="coreif.jsp" method="get">
<%--    el表达式获取表单中的数据${param.参数名}--%>
    <input type="text" name="username" value="${param.username}">
    <input type="submit" value="登录">
<%--    判断如果提交的用户名是管理员，则登录成功--%>
<%--    <%--%>
<%--        if(request.getParameter("username").equals("admin")){--%>
<%--            out.print("登陆成功");--%>
<%--        }--%>
<%--    %>--%>
    <c:if test="${param.username =='admin'}" var = "isAdmin">
        <c:out value="管理员欢迎您！"></c:out>
    </c:if>
    <c:out value="${isAdmin}"></c:out>

</body>
</html>
