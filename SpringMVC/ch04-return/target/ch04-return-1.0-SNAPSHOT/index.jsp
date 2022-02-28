<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script
            src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous"></script>
    <script type="text/javascript">
        $(function (){
            $("button").click(function (){
                // alert("button click")
                $.ajax({
                    url:"returnStudentJsonArray.do",
                    data:{
                        name:"zhangsan",
                        age:20
                    },
                    type:"post",
                    dateType:"json",
                    success:function (resp){
                        // resp从服务器端返回的事json格式的字符串
                        //jquery会把字符串转为json对象，赋值给resp形参
                        // alert(resp.name + "  " + resp.age);
                        $.each(resp, function (i,n){
                            alert(n.name + "  " + n.age);
                        })
                    }
                })
            })
        })
    </script>

</head>
<body>
    <p>处理器方法返回String表示视图名称</p>
    <br>
    <form action="returnString-view.do" method="post">
        Name:<input type="text" name="name">
        Age:<input type="text" name="age">
        <input type="submit" value="submit">
    </form>

    <br>
    <p>处理器方法返回String表示视图完整路径</p>
    <form action="returnString-view2.do" method="post">
        Name:<input type="text" name="name">
        Age:<input type="text" name="age">
        <input type="submit" value="submit">
    </form>
    <br>
<button id="btn">发起ajax</button>



</body>
</html>
