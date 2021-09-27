
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--显示的声明表示这是一个错误页面--%>
<%@page isErrorPage="true" %>
<%--定制错误页面--%>
<%@ page errorPage="/error/500.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>测试页面</h1>
<%
    int x = 1/0;
//    int x =1;
%>
</body>
</html>
