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
    <title>首页</title>
    <%--
        相对路径说明: 不以 / 开始的是以当前资源为相对路径,/代表的是当前的服务器地址(客户端解析的时候)
    --%>
    <!-- Bootstrap -->
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${APP_PATH}/static/js/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript">

        //总页数
        var totalPages;
        //1.页面加载完成以后,直接发送Ajax请求
        $(function () {
            to_page(1);
            registerBtns();

        });

        function to_page(pn) {
            $.ajax({
                url: "${APP_PATH}/books",
                data: "pn=" + pn,
                type: "GET",
                success: function (result) {
                    //    1.解析书籍信息
                    build_book_info(result);
                    //    2.解析分页信息
                    build_page_info(result);
                    //    3.解析分页条信息
                    build_page_nav(result);
                }
            });
        }

        //构建书籍显示表格
        function build_book_info(result) {
            //清空数据
            $("#books_table tbody").empty();
            //获取书籍信息并添加进表格
            var books = result.data.page.list;
            $.each(books, function (index, book) {
                var bookId = $("<td></td>").append(book.id);
                var bookName = $("<td></td>").append(book.name);
                var bookAuthor = $("<td></td>").append(book.author);
                var bookPrice = $("<td></td>").append(book.price);
                var bookSales = $("<td></td>").append(book.sales);
                var bookStock = $("<td></td>").append(book.stock);
                var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm")
                    .append($("<span></span>").addClass("glyphicon glyphicon-pencil"))
                    .append("编辑");
                var deleteBtn = $("<button></button>").addClass("btn btn-danger btn-sm")
                    .append($("<span></span>").addClass("glyphicon glyphicon-trash"))
                    .append("删除");

                var btnTd = $("<td></td>").append(editBtn).append(" ").append(deleteBtn);
                $("<tr></tr>")
                    .append(bookId)
                    .append(bookName)
                    .append(bookAuthor)
                    .append(bookPrice)
                    .append(bookSales)
                    .append(bookStock)
                    .append(btnTd)
                    .appendTo("#books_table tbody");
            })

        }

        //构建页数信息
        function build_page_info(result) {
            $("#page_info").empty();
            $("#page_info").append("当前" + result.data.page.pageNum + "页,共" +
                result.data.page.pages + "页,共" +
                result.data.page.total + "条记录");
            totalPages = result.data.page.pages;
        }

        //构建导航栏信息
        function build_page_nav(result) {
            //清空元素
            $("#page_nav").empty();
            //首页 前一页等元素
            var nav = $("<nav></nav>");
            var ul = $("<ul></ul>").addClass("pagination");
            var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
            var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
            if (result.data.page.hasPreviousPage == false) {
                firstPageLi.addClass("disabled");
                prePageLi.addClass("disabled");
            } else {
                //绑定首页 前一页点击事件
                firstPageLi.click(function () {
                    to_page(result.data.page.navigateFirstPage);
                });
                prePageLi.click(function () {
                    to_page(result.data.page.prePage);
                });

            }
            var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
            var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
            if (result.data.page.hasNextPage == false) {
                nextPageLi.addClass("disabled");
                lastPageLi.addClass("disabled");
            } else {

                //绑定下一页 末页点击事件
                nextPageLi.click(function () {
                    to_page(result.data.page.nextPage);
                });
                lastPageLi.click(function () {
                    to_page(result.data.page.navigateLastPage);
                });
            }

            ul.append(firstPageLi).append(prePageLi);
            //数码框创建并绑定事件
            $.each(result.data.page.navigatepageNums, function (index, item) {
                var numLi = $("<li></li>").append($("<a></a>").append(item));
                if (item == result.data.page.pageNum) {
                    numLi.addClass("active");
                }
                numLi.click(function () {
                    to_page(item);
                })
                ul.append(numLi);
            })
            ul.append(nextPageLi).append(lastPageLi);
            nav.append(ul);
            $("#page_nav").append(nav);
        }

        //添加 和 删除按钮的事件绑定
        function registerBtns() {
            //添加按钮事件绑定
            $("#book_add_btn").click(function () {
                //获取信息并放在下拉列表中
                getSales();
                //弹出模态框
                $("#bookAddModal").modal({
                    backdrop: "static"
                });
            });

            //保存信息按钮事件绑定
            $("#book_save_btn").click(function () {

                //1.模态框中的表单数据提交,通过Ajax
                $.ajax({
                    url: "${APP_PATH}/book",
                    type: "POST",
                    data: $("#bookAddModal form").serialize(),
                    success: function (result) {
                        alert(result.msg);
                        //1.关闭模态框,到最后一页
                        $("#bookAddModal").modal("hide");
                        to_page(totalPages + 1);
                    }
                });

            });

            //注册删除按钮
            $("#book_delete_btn").click(function () {
                alert("hello");
            });

        }


        //获取信息并放在下拉列表中
        function getSales() {
            $.ajax({
                url: "${APP_PATH}/sales",
                type: "GET",
                success: function (result) {
                    // 添加下拉元素
                    $.each(result.data.sales, function (index, item) {
                        var opEle = $("<option></option>").append(item).attr("value", item);
                        opEle.appendTo($("#book_add_sales"));
                    });
                }
            });
        }


    </script>

</head>
<body>
<!-- Modal模态框,添加页面 -->
<div class="modal fade" id="bookAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">员工添加</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="book_add_name" class="col-sm-2 control-label">BookName</label>
                        <div class="col-sm-10">
                            <input type="text" name="name" class="form-control" id="book_add_name"
                                   placeholder="BookName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="book_add_author" class="col-sm-2 control-label">BookAuthor</label>
                        <div class="col-sm-10">
                            <input type="text" name="author" class="form-control" id="book_add_author"
                                   placeholder="BookAuthor">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="book_add_price" class="col-sm-2 control-label">BookPrice</label>
                        <div class="col-sm-10">
                            <input type="text" name="price" class="form-control" id="book_add_price"
                                   placeholder="BookPrice">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="book_add_stock" class="col-sm-2 control-label">BookStock</label>
                        <div class="col-sm-10">
                            <input type="text" name="stock" class="form-control" id="book_add_stock"
                                   placeholder="BookStock">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="book_add_sales" class="col-sm-2 control-label">BookSales</label>
                        <div class="col-sm-10">
                            <select id="book_add_sales" class="form-control" name="sales">

                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="book_save_btn">Save changes</button>
            </div>
        </div>
    </div>
</div>
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
            <button class="btn btn-primary" id="book_add_btn">新增</button>
            <button class="btn btn-danger" id="book_delete_btn">删除</button>
        </div>
    </div>
    <%--表格--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="books_table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>name</th>
                    <th>author</th>
                    <th>price</th>
                    <th>sales</th>
                    <th>stock</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>

                </tbody>

            </table>
        </div>
    </div>
    <%--分页--%>
    <div class="row">
        <%--分页信息--%>
        <div class="col-md-6" id="page_info"></div>
        <%--分页条--%>
        <div class="col-md-6" id="page_nav"></div>
    </div>
</div>

</body>
</html>
