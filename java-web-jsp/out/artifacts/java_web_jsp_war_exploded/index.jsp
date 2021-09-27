<%--
  Created by IntelliJ IDEA.
  User: lzf
  Date: 2021/9/21
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%--  jsp表达式
      作用：用来将程序的输出，输出到客户端
      <%= 变量或者表达式%>
--%>
<%
    int sum = 1;
//    html自动转义
    out.print("<h1>sum = " + sum + "</h1>");
%>
<%
    int x = 10;
    out.print(x);
%>
<p>这是一个jsp文档</p>
<%
    int y = 2;
    out.print(y);
%>
<h1>花里胡哨的写法,在代码中嵌入html元素</h1>
<%
    for (int i = 0; i < 5; i++) {
%>
<h1>hello,world <%=1%>
</h1>
<%
    }
%>

<%!
    static {
        System.out.println("loading servlet");

    }
    private int globalVar = 0;
    public void lzf(){
        System.out.println("进入了某方法");
    }

%>
</body>
</html>
