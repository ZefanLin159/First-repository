
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<h1>1</h1>--%>
<%--取出参数--%>

<jsp:forward page="jspTag2.jsp">
    <jsp:param name="name" value="lzf"/>
    <jsp:param name="age" value="20"/>
</jsp:forward>
</body>
</html>
