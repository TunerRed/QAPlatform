<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/18
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- 设置文档编码 -->
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <!-- 响应式布局设置-->
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <!-- 新 Bootstrap 核心 CSS 文件 -->

    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="JS/jquery-3.2.1.min.js"></script>
    <!--引入jquery.cookie插件-->
    <script src="JS/jquery.cookie.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <title>publish</title>
    <!--引入css样式表-->
    <link href="CSS/publish.css" rel="stylesheet" type="text/css">
    <!--引入JavaScript-->
    <script src="JS/publish.js"></script>
</head>
<body  onload="preSet()">
<div style="height:86px;">
    <img id="title" src="picsInHomepage/publish_title.png">
    <div class="login" id="bt1">
        <a href="index.jsp" id="style1">登录</a>
    </div>
    <div class="login" id="bt2" style="margin-left:92%;">
        <a href="register.html" id="style2">注册</a>
    </div>
</div>

<div id="user"><a  id='userName' style="color: white;"></a></div>
<form role="form" id="form" action="http://47.94.131.133:8080/QASite/user/upload"  method="post" enctype ="multipart/form-data" target="123">
    <div class="form-group">
        <img src="picsInHomepage/question.png" id="questionImg" style="cursor:pointer;">
        <input type="text" class="form-control" name="question" id="question" placeholder="请输入问题">
    </div>
    <div class="form-group">
        <img src="picsInHomepage/description.png" id="descriptionImg">
        <textarea  class="form-control" name='description' id="description" rows="10" placeholder="请输入具体描述"></textarea>
    </div>
    <div class="form-group" id="uploaddiv">
        <img src="picsInHomepage/upload.png" id="upload"><br>
        <img src="picsInHomepage/resource_unclicked.png" id="resourse_isclick">
        <input type="file" name="file" id="inputfile" style="width: 175px">
    </div>
    <div class="form-group">
        <img src="picsInHomepage/wanted.png" id="wantedImg">
        <input type="text" class="form-control" name="point" id="wanted" placeholder="请输入悬赏积分">
    </div>
    <div class="form-group" style="display: none">
        <input type="text" class="form-control" name="Id" id="user_id">
        <script>
            var i=$.cookie('user_id')
            $("#user_id").val(i)
        </script>
    </div>
    <input type="submit" class="btn btn-primary"  id="publish" value="立即发布">
</form>
<iframe name="123" style="display: none"></iframe>
<script>
    $(document).ready(function () {
     change();;
    });
</script>
</body>
</html>
