<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>

    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            //给更新商品数量框绑定失去焦点事件
            $("input.updateCount").change(function () {
                var name = $(this).parent().parent().find("td:first").text();
                var count = $(this).val();
                var id = $(this).attr("bookId");
                if (confirm("确认修改商品<<" + name + ">>数量为" + count + "吗?")) {
                    location.href = "http://localhost:8081/book/cartServlet?action=updateCount&count=" + count + "&id=" + id;
                } else {
                    this.value = this.defaultValue;
                }
            });
            //给删除按钮绑定事件
            $("a.deleteItem").click(function () {
                return confirm("确认" + $(this).parent().parent().find("td:first").text() + "删除吗?");
            });
            //给清空按钮绑定事件
            $("#clear").click(function () {
                return confirm("确认清空购物车吗?");
            });
        })
    </script>

</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>

    <%--静态包含，登录 成功之后的菜单 --%>
    <%@ include file="/pages/common/login_success_menu.jsp" %>


</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <%--购物车为空--%>
        <c:if test="${empty sessionScope.cart.items}">
            <td colspan="5"><a href="index.jsp">当前购物车为空,点击去浏览</a></td>
        </c:if>
        <%--购物车不为空--%>
        <c:if test="${not empty sessionScope.cart.items}">
            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td><input bookId="${entry.value.id}" class="updateCount" type="text" style="width: 50px;"
                               value="${entry.value.count}"></td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>


    </table>
    <%--购物车非空才输出--%>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a id="clear" href="cartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>


</div>


<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>


</body>
</html>