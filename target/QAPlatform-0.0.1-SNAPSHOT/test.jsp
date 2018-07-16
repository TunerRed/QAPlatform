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
<div style="text-align: center">
    <p>
        后台测试用jsp，若“点我测试”返回了了正常值<br>
        则证明接口没有明显问题<br>
        需要前端处理产生的问题<br>
        包括检查自己的配置与数据库是否符合要求等<br>
        否则是后台问题，包括修改了接口或没有考虑全部输入情况<br>
        或接口未开发完成
    </p>
    <br><br>
    <div>
        输入项1：<input type="text" id="testInput1" width="200px" height="30px" value="1"/><br>
        输入项2：<input type="text" id="testInput2" width="200px" height="30px"/><br>
        输入项3：<input type="text" id="testInput3" width="200px" height="30px"/>
    </div>
    <br><br>
    <button class="btn btn-success" id="click2test" onclick="clickTest()">点我测试</button>
</div>

<script type="text/javascript">
    function clickTest() {
        var input1 = document.getElementById("testInput1").value;
        var input2 = document.getElementById("testInput2").value;
        var input3 = document.getElementById("testInput3").value;

        if (input1 != ''){
            console.log("input1 : "+input1);
            $.ajax({
                type:"post",
                //问题详情页面
                url:'http://localhost:8080/webapp/user/best',
                contentType:'application/json',
                data:JSON.stringify({
                    //question_id:"10",
                    reply_id:"48",
                    //reply:"simple reply , to earn User.DEFAULT_CREDIT_POINT points"
                }),
                success:function(result){
                    console.log("server return : "+result.message);
                    console.log("new reply id : "+result.data.reply_id);
                }
            });
        } else if (input2 != '') {
            console.log("request : user/answers \tinput2 : "+input2)
            $.ajax({
                type:"post",
                url:'http://localhost:8080/webapp/user/answers',
                contentType:'application/json',
                data:JSON.stringify({
                    user_id:111,
                }),
                success:function(result){
                    console.log("server return : "+result.message);
                    if(result.status==200){
                        for (var key in result.data){
                            console.log("Question : "+result.data[key].title+
                                "\nreply time : "+result.data[key].time+
                                "\nquestion opening : "+result.data[key].status);
                        }
                    }
                }
            });
        }else if (input3 != '') {
            console.log("input3 : "+input3);
            $.ajax({
                type:"post",
                url:'http://localhost:8080/webapp/common/login',
                contentType:'application/json',
                data:JSON.stringify({
                    email:input3+"@163.com",
                    password:input3,
                }),
                success:function(result){
                    console.log("server return : "+result.message);
                    if(result.status==200){
                        console.log(result.data.userName);
                    }
                }
            });
        }

    }
</script>
</body>
</html>
