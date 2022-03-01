<%--
  Created by IntelliJ IDEA.
  User: ryan
  Date: 2022/2/28
  Time: 10:57 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  退出系统
  <%
    session.removeAttribute("name");
  %>
</body>
</html>
