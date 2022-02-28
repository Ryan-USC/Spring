<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>submit parameter to controller</p>
    <br>
    <form action="receive.do" method="post">
        Name:<input type="text" name="name">
        Age:<input type="text" name="age">
        <input type="submit" value="submit">
    </form>

    <br>
    <p>形参名和处理器方法的形参名不一样</p>
    <form action="receiveparam.do" method="post">
        Name:<input type="text" name="rname">
        Age:<input type="text" name="rage">
        <input type="submit" value="submit">
    </form>

    <br>
    <p>使用java对象接受请求参数</p>
    <form action="receiveobject.do" method="post">
        Name:<input type="text" name="name">
        Age:<input type="text" name="age">
        <input type="submit" value="submit">
    </form>
</body>
</html>
