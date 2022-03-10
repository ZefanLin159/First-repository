<%--
  Created by IntelliJ IDEA.
  User: lzf
  Date: 2022/3/5
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column"></div>
        <div class="page-header">
            <h1>
                <small>修改书籍</small>
            </h1>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/books/updateBook" method="post">
        <%--        出现的问题：提交了sql修改请求，初次考虑是事务问题，配置完事务依旧失败--%>
        <%--        查看sql语句是否执行成功，sql执行失败未完成--%>
        <%--    前端传递隐藏域--%>
        <input type="hidden" name="bookID" value="${Qbooks.bookID}">
        书籍名称：<input type="text" name="bookName" value="${Qbooks.bookName}" required><br><br><br>
        书籍数量：<input type="text" name="bookCounts" value="${Qbooks.bookCounts}" required><br><br><br>
        书籍详情：<input type="text" name="detail" value="${Qbooks.detail}" required><br><br><br>
        <input type="submit" value="修改">
    </form>


</div>

</body>
</html>
