<%--
  Created by IntelliJ IDEA.
  User: ryan
  Date: 2022/2/28
  Time: 6:49 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>功能入口</title>
    <base href="<%=basePath%>"/>
    <script src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous"></script>
</head>
<body>
    <div align="center">
        <p>ssm整合例子</p>
        <table>
            <tr>
                <td><a href="addStudent.jsp">注册学生</a> </td>
            </tr>
            <tr>
                <td><a href="listStudent.jsp">浏览学生</a> </td>
            </tr>
        </table>
    </div>


</body>
</html>
