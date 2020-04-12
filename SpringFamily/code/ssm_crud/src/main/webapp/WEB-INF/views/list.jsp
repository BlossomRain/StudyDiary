<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/11 0011
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <title>员工列表页面</title>
    <%--
        相对路径说明: 不以 / 开始的是以当前资源为相对路径,/代表的是当前的服务器地址(客户端解析的时候)
    --%>
    <!-- Bootstrap -->
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${APP_PATH}/static/js/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<%--搭建显示页面--%>
<div class="container">
    <%--标题--%>
    <div class="row">
        <div class="col-md-12">
            <h1 class="bg-info">SSM-CRUD</h1>
        </div>
    </div>
    <%--按钮--%>
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary">新增</button>
            <button class="btn btn-danger">删除</button>
        </div>
    </div>
    <%--表格--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <th>#</th>
                    <th>name</th>
                    <th>author</th>
                    <th>price</th>
                    <th>sales</th>
                    <th>stock</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${page.list}" var="book">
                    <tr>
                        <th>${book.id}</th>
                        <th>${book.name}</th>
                        <th>${book.author}</th>
                        <th>${book.price}</th>
                        <th>${book.sales}</th>
                        <th>${book.stock}</th>

                        <th>
                            <button class="btn btn-primary btn-sm">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                编辑
                            </button>
                            <button class="btn btn-danger btn-sm">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                删除
                            </button>
                        </th>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <%--分页--%>
    <div class="row">
        <%--分页信息--%>
        <div class="col-md-6">
            当前${page.pageNum}页,共${page.pages}页,共${page.total}条记录
        </div>
        <%--分页条--%>
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">

                    <li><a href="${APP_PATH}/books?pn=${page.navigateFirstPage}">首页</a></li>
                    <c:if test="${page.hasPreviousPage}">
                        <li>
                            <a href="${APP_PATH}/books?pn=${page.prePage}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach items="${page.navigatepageNums}" var="page_Num">
                        <c:if test="${page.pageNum == page_Num}">
                            <li class="active"><a href="#">${page_Num}</a></li>
                        </c:if>
                        <c:if test="${page.pageNum != page_Num}">
                            <li><a href="${APP_PATH}/books?pn=${page_Num}">${page_Num}</a></li>
                        </c:if>
                    </c:forEach>

                    <c:if test="${page.hasNextPage}">
                        <li>
                            <a href="${APP_PATH}/books?pn=${page.nextPage}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <li><a href="${APP_PATH}/books?pn=${page.navigateLastPage}">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
