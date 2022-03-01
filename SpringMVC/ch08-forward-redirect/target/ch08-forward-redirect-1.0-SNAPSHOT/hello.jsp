<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h3>hello.jsp</h3>
  <h3>msg data: ${param.myName}</h3>
  <h3>fun data: ${param.myAge}</h3>
<h3>取参数数据：<%=request.getParameter("myName")%></h3>
</body>
</html>
