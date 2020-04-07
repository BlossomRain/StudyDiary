<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/6 0006
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>spring-mvc</title>
</head>
<body>


<a href="springMVC/testRedirect"> Test Redirect" </a>
<br><br>
<a href="springMVC/testView"> Test View" </a>
<br><br>
<%--模拟修改操作,其中密码不能修改,id为隐藏属性 回显--%>
<form action="springMVC/testModelAttribute" method="post">
    <input type="hidden" name="id" value="1"><br>
    username: <input type="text" name="username" value="David"> <br>
    age: <input type="text" name="age" value="11"> <br>
    <input type="submit" value="submit"> <br>
</form>
<br><br>
<a href="springMVC/testModelAndView"> Test ModelAndView" </a>
<br><br>
<form action="springMVC/testPojo" method="post">
    username: <input type="text" name="username"> <br>
    password: <input type="password" name="password"> <br>
    age: <input type="text" name="age"> <br>
    province: <input type="text" name="address.province"> <br>
    city: <input type="text" name="address.city"> <br>
    <input type="submit" value="submit"> <br>
</form>
<br><br>
<a href="springMVC/testCookieValue"> Test testCookieValue </a>
<br><br>

<a href="springMVC/testRequestParam?username=aaa&age=123"> Test RequestParam </a>
<br><br>
<form action="springMVC/testRest/1" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="Test Rest PUT">
</form>
<br> <br>
<form action="springMVC/testRest/1" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="Test Rest Delete">
</form>
<br> <br>
<form action="springMVC/testRest/" method="post">
    <input type="submit" value="Test Rest Post">
</form>
<br> <br>
<a href="springMVC/testRest/1"> Test Rest Get </a>
<br> <br>
<a href="springMVC/testPathVariable/1">testPathVariable</a> <br>
<a href="springMVC/testParamAndHeader?username=aaa&age=10">testParamAndHeader</a> <br>
<a href="springMVC/testMethod">testMethod</a> <br>
<a href="springMVC/testRequsetMapping">testRequsetMapping</a> <br>
<a href="helloWorld">HelloWorld</a> <br>
</body>
</html>
