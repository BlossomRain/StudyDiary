<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/6 0006
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
    <style type="text/css">
        h1{
            color: mediumvioletred;
        }
        span{
            color: #1d224d;
            font-size: 22px;
        }
    </style>
</head>
<body>
<h1 >视图解析器转到的页面</h1>
<span>${requestScope.time}</span>
</body>
</html>
