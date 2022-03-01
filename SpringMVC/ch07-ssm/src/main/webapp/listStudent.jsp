<%--
  Created by IntelliJ IDEA.
  User: ryan
  Date: 2022/2/28
  Time: 8:04 下午
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
    <title>Title</title>
  <base href="<%=basePath%>">
  <script src="https://code.jquery.com/jquery-3.4.1.js"
          integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
          crossorigin="anonymous"></script>
  <script type="text/javascript">
      $(function (){
        //在当前的页面dom对象加载后，执行
        loadStudentData()
        $("#btnLoader").click(function (){
            loadStudentData();
        })
      })

      function loadStudentData(){
        $.ajax({
          url:"student/queryStudent.do",
          type:"get",
          dataType:"json",
          success:function (data){
            //清除旧的数据
            $("#info").html("");
            $.each(data,function (i,n){
              $("#info").append("<tr>").
              append("<td>" + n.id + "</td>").
              append("<td>" + n.name + "</td>").
              append("<td>" + n.age + "</td>").
              append("</tr>")
            })
          }
        })
      }
  </script>
</head>
<body>
  <div align="center">
    <table>
      <thead>
      <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>年龄</td>
      </tr>
      </thead>
      <tbody id="info">

      </tbody>
    </table>
    <input type="button" id="btnLoader" value="加载数据">
  </div>

</body>
</html>
