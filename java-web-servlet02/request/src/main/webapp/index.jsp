<%--
  Created by IntelliJ IDEA.
  User: lzf
  Date: 2021/9/19
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>登录</h1>
<div>
<%--    这里表单表示的意思，以post方式提交表单，提交到我们的login请求--%>
<%--    原因是 ${} 没有解析出来。--%>
<%--    ＜%@ page isELIgnored＝"true|false"%＞如果设定为真，那么JSP中的表达式被当成字符串处理，我们通过字面意思理解一下：是否忽略el表达式，如果为true就是忽略el表达式，就是当做字符串来处理；反之，就是按el表达式来。--%>
<%--    如果通过简单的测试发现你的${pageContext.request.contextPath}为字符串，那么你把 isELIgnore 的 设置为 false 就好了。--%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text" name="username"> <br>
        密码：<input type="password" name="password"><br>
        爱好：
        <input type="checkbox" name="hobby" value="女孩"> 女孩
        <input type="checkbox" name="hobby" value="代码"> 代码
        <input type="checkbox" name="hobby" value="唱歌"> 唱歌
        <input type="checkbox" name="hobby" value="电影"> 电影
        <br>
        <input type="submit">
    </form>
</div>

</body>
</html>
