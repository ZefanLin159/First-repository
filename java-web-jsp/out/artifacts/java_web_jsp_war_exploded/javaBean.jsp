<%@ page import="com.lzf.entity.People" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%--%>
<%--    People people = new People();--%>
<%--    people.setAddress();--%>
<%--    people.setAge();--%>
<%--    people.setName();--%>
<%--    people.setId();--%>
<%--%>--%>
<jsp:useBean id="people" class="com.lzf.entity.People" scope="page"/>
<%--低级错误，数据类型不对应，要注意--%>
<jsp:setProperty name="people" property="id" value='1'/>
<jsp:setProperty name="people" property="name" value='小林'/>
<jsp:setProperty name="people" property="age" value='3'/>
<jsp:setProperty name="people" property="address" value='西安'/>
id：<jsp:getProperty name="people" property="id"/>
姓名：<jsp:getProperty name="people" property="name"/>
年龄：<jsp:getProperty name="people" property="age"/>
地址：<jsp:getProperty name="people" property="address"/>
</body>
</html>
