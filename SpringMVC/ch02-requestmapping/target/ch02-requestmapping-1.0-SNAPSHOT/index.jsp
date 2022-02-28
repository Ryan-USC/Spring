<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>First SpringMVC project</p>
    <p><a href="test/some.do">submit some.do get request</a> </p>
    <br>
    <form action="test/other.do" method="post">
        <input type="submit" value="post请求other.do">
    </form>
    <p><a href="test/other.do">submit other.do request</a> </p>
</body>
</html>
