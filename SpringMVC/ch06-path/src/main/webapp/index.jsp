<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basepath = request.getScheme() + "://" +
                request.getServerName() + ":" + request.getServerPort() +
                request.getContextPath() + "/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%basepath%>">
</head>
<body>
    <p>First SpringMVC project</p>
<%--    <p><a href="user/some.do">submit some.do get request</a> </p>--%>
<%--    <p><a href="${pageContext.request.contextPath}/user/some.do">submit some.do get request</a> </p>--%>
    <p><a href="user/some.do">submit some.do get request</a> </p>
    <br>


</body>
</html>
