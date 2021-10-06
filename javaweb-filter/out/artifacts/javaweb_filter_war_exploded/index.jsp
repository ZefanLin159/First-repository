<%--
  Created by IntelliJ IDEA.
  User: LZF
  Date: 2021/9/29
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>
    当前有<span style="color: blue"><%=this.getServletConfig().getServletContext().
        getAttribute("onlineCount")%></span>人在线
</h1>
</body>
</html>
