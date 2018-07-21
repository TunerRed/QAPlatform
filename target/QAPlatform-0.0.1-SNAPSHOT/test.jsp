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
    <!--%
        pageContext.setAttribute("APP_PATH", "http://47.94.131.133:8080/QASite");
    %-->
    <script type="text/javascript" src="JS\jquery-1.11.0.min.js"></script>
    <script>
        var strCookie=document.cookie;
        var res="userName";
        var matchcookie=res;
        var getMatchCookie;
        function getdescookie(){
            var arrCookie=strCookie.split(";");
            for(var i=0;i<arrCookie.length;i++) {
                var arr = arrCookie[i].split("=");
                if (matchcookie == arr[0]) {
                    getMatchCookie = arr[1];
                    alert(getMatchCookie);
                    break;

                }
            }
        }
    </script>
</head>
<body onload="getdescookie();">
<div style="text-align: center" >
    <p>
        后台测试用jsp，若“点我测试”返回了了正常值<br>
        则证明接口没有明显问题<br>
        需要前端处理产生的问题<br>
        包括检查自己的配置与数据库是否符合要求等<br>
        否则是后台问题，包括修改了接口或没有考虑全部输入情况<br>
        或接口未开发完成
    </p>
</div>
<div style="text-align: center; margin-top: 30px">
    <p>登录测试</p>
    <br>
    <div>
        email：<span style="width: 30px"></span><input type="text" id="email" width="200px" height="30px" value=""/><br>
        password：<input type="text" id="password" width="200px" height="30px"/><br>
    </div>
    <br>
    <button class="btn btn-success" id="login" onclick="clickTest()">点我登录</button>
</div>
<br>
<div style="text-align: center; margin-top: 30px">
    <p>搜索测试</p>
    <br>
    <div>
        search question：<input type="text" id="search" width="400px" height="40px" value="肥皂泡和水为什么会被火柴爆炸？!"/>
    </div>
    <br>
    <button class="btn btn-success" id="searchBtn" onclick="searchTest()">点我搜索</button>
</div>
<br>
<div style="text-align: center; margin-top: 50px">
    <p>上传文件的接口，已与前端协商</p>
    <form action="user/upload" enctype="multipart/form-data" method="post">
        <input type = "file" name= 'file' style="width: 200px"/><br>
        <%--输入对文件的描述--%>
        文件描述：<span style="width: 30px"></span><input type="text" name="description"/><br>
        <%--输入文件的积分--%>
        下载积分：<span style="width: 30px"></span><input type="text" name="point"/><br>
        <%--前端还需要返回一个用户id，这里先用的输入--%>
        上传者id：<span style="width: 30px"></span><input type="text" name="Id"/><br>
        <input type ="submit" value="上传">
    </form>
</div>
<br>
<div style="margin-top: 50px; margin-bottom: 200px; text-align: center">
    <p>下载测试</p>
    <br>
    <div>
        资源id：<span style="width: 30px"></span><input type="text" id="resource_id" width="200px" height="30px" value=""/><br>
        下载者id：<input type="text" id="user_id" width="200px" height="30px"/><br>
    </div>
    <br>
    <button class="btn btn-success" id="download" onclick="downloadTest()">点我下载</button>
</div>

<script type="text/javascript">
    function keyOnClick(e){
        var theEvent = window.event || e;
        var code = theEvent.keyCode || theEvent.which;
        if (code==13) {  //回车键的键值为13
            clickTest();  //调用搜索事件
        }
    }
    function clickTest() {
        var user_email = document.getElementById("email").value;
        var password = document.getElementById("password").value;
        console.log("login email : "+user_email);
        console.log("login password : "+password);
        $.ajax({
            type:"post",
            //登录页面
            url:'http://localhost:8080/QASite/common/login',
            contentType:'application/json',
            data:JSON.stringify({
                email:user_email,
                password:password
            }),
            success:function(result){
                console.log("server return : "+result.message);
                console.log("login user : "+result.data.userName);
                console.log("login id: "+result.data.id);
            }
        });
    }
    function searchTest() {
        var searchContent = document.getElementById("search").value;
        console.log("search content : "+searchContent);
        $.ajax({
            type:"post",
            //问题详情页面
            url:'http://47.94.131.133:8080/QASite/common/search',
            contentType:'application/json',
            data:JSON.stringify({
                type:"question",
                description:searchContent,
                index:1,
                length:20
            }),
            success:function(result){
                console.log("server return : "+result.message);
                for (var i = 0; i < result.data.length; i++) {
                    console.log("search : "+result.data[i].title);
                }
            }
        });
    }
    function downloadTest() {
        var Id = document.getElementById("user_id").value;
        var resource_id = document.getElementById("resource_id").value;
        console.log("download user_id : "+Id);
        console.log("download resource_id : "+resource_id);
        $.ajax({
            type:"post",
            //问题详情页面
            url:'http://47.94.131.133:8080/QASite/user/download',
            contentType:'application/json',
            data:JSON.stringify({
                Id:Id,
                resource_id:resource_id
                //reply:"simple reply , to earn User.DEFAULT_CREDIT_POINT points"
            }),
            success:function(result){
                console.log("server return : "+result.message);
                console.log("download address : "+result.data.address);
                window.open(result.data.address);
            }
        });
    }
</script>
</body>
</html>