<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>书籍展示</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <%--    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->--%>

    <%--    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>--%>

    <%--    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->--%>

    <%--    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
</head>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column"></div>
        <div class="page-header">
            <h1>
                <small>书籍列表 ------ 显示所有书籍</small>
            </h1>
        </div>
        <div class="row">
            <div class="col-md-4 column">
                <%--                toAddBook--%>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/books/toAddBook">新增书籍</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/books/allBook">显示全部书籍</a>

            </div>
            <div class="col-md-4 column">
                <%-- toAddBook--%>
                <form action="${pageContext.request.contextPath}/books/queryBook" method="" class="form-inline">
                    <span style="color: red;font-weight: bold;">${error}</span>
                    <input type="text" placeholder="请输入要查询的书籍名称" class="form-control" name="queryBookName">
                    <input type="submit" value="查询" class="btn-primary btn">
                </form>

            </div>
        </div>
    </div>

    <div class=" row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名称</th>
                    <th>书籍数量</th>
                    <th>书籍详情</th>
                </tr>
                </thead>
                <tbody>
                <%--                    书籍从数据库查出来--%>
                <c:forEach var="books" items="${listBook}">
                    <tr>
                        <td>${books.bookID}</td>
                        <td>${books.bookName}</td>
                        <td>${books.bookCounts}</td>
                        <td>${books.detail}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/books/toUpdate?id=${books.bookID}">修改</a>
                            <a href="${pageContext.request.contextPath}/books/deleteBook?id=${books.bookID}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
