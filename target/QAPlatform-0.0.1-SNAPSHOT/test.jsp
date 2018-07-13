<%--
  Created by IntelliJ IDEA.
  User: CodeVoid
  Date: 2018/7/12
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台测试</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <%
        pageContext.setAttribute("APP_PATH", "http://localhost:8080/webapp");
    %>
    <script type="text/javascript" src="JS\jquery-1.11.0.min.js"></script>
</head>
<body>
<input type="text" id="testInput" width="200px" height="30px"/><br />
<button class="btn btn-success" id="click2test" onclick="clickTest()">点我测试</button>
<script type="text/javascript">
    function clickTest() {
        console.log("----------");
        var input = document.getElementById("testInput");
        $.ajax({
            type:"post",
            url:'http://localhost:8080/webapp/common/search',
            contentType:'application/json',
            data:JSON.stringify({
                type:"question",
                description:"aaaaa",
                index:1,
                length:4
                //email:"9307a1@163.com",
                //password:"9307a1"
            }),
            success:function(result){
                alert(result.message);
                if(result.status==200){
                    console.log("----------------------------");
                }
                //alert(reult.data.userName);
                //alert(result.status+result.message);
            }
        });
    }
</script>
</body>
</html>
