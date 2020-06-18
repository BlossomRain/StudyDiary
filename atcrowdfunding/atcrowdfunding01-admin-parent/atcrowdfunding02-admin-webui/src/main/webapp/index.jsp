<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>HelloWorld</title>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <jsp:forward page="admin/to/login/page.html"></jsp:forward>
    <script src="jquery/jquery-2.1.1.min.js"></script>
    <script src="layer/layer.js"></script>
    <script>
        $(function () {
            $("#ajaxBtn").on(click, function () {
                alert("aaa");
                var array = [1, 2, 3];
                var reqBody = JSON.stringify("array", array);
                $.ajax({
                    url: "send/array.json",
                    type: "post",
                    data: reqBody,              //直接发送数据会产生奇怪的问题
                    contentType: "application/json;charset=UTF-8",
                    dataType: "json",           //改用json方式
                    success: function (response) {
                    },
                    error: function (response) {
                    }
                });
            });
            $("#layerBtn").on(click, function () {
                layer.msg("Layer Msg");
            });
        });
    </script>
</head>
<body>
<h1 style="color:bisque">Hello World!</h1>
<a href="test/ssm.html">ssm整合测试</a>
<br/>
<button id="ajaxBtn">Send [1,2,3] one</button>
<br>
<button id="layerBtn">layer</button>
</body>
</html>
