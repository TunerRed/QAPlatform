<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- 设置文档编码 -->
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <!-- 响应式布局设置-->
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <title>个人管理</title>
    <!--引入css样式表-->
    <link href="CSS/personalHomepage.css" rel="stylesheet" type="text/css">
    <!--引入JavaScript-->
    <script src="JS/personalHomepage.js"></script>
    <script type="text/javascript" src="JS\jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="JS\jquery.cookie.js"></script>
</head>
<body onload="changePic1(); getDesCookie(); question(); reply(); resource(); getInfo();">

<img id="title" src="picsInHomepage\top.png"/>
<div id="personalInfo">
<div id="bird">
<img src="picsInHomepage\bird.png" style="width:75%; height:75%;"/> 
</div>
<div id="info">
<div id="name">
    <p id="getName">
    </p>
</div>
<div id="sex">
<!-- 根据数据库获取性别-->
<img id='genderPic'src="picsInHomepage\man_on.png" style="width:80%; height:80%;"\>
</div>
<div id="position">
<!-- 根据数据库获取职位---->
<img id="positionPic"src="picsInHomepage\student_on.png" style="width:80%; height:80%;"\>
</div>
</div>
<!-- 根据数据库获取积分---->
<div id="point">
    <p id="myCredit">
积分 120分
    </p>
</div>
<div id="question">
<img id="pic1" src="picsInHomepage\my_question_on.png" style="width:100%; height:100%; cursor:pointer;" onclick="changePic1()"\>
</div>
<div id="reply">
<img id="pic2" src="picsInHomepage\my_reply.png" style="width:100%; height:100%; cursor:pointer;" onclick="changePic2()"\>
</div>
<div id="resource">
<img id="pic3" src="picsInHomepage\my_resource.png" style="width:100%; height:100%; cursor:pointer;" onclick="changePic3()"\>
</div>
<div id="changeInfo">
<a style="pinter:cursor; text-decoration:none; color:#d4d4d4;" href="changeInfo.html">
修改密码\信息>>
</a>
</div>
</div>
<div id="my_question">
    <p id="queText">
        您还没有提问过哦~
    </p>
<table id="que_table">
    <tr>
        <thead>
        </thead>
        <tbody id="tbMain">
        </tbody>
    </tr>
</table>
</div>

<div id="my_reply">
    <p id="replyText">
        您还没有回答过哦~
    </p>
<table id="reply_table">
    <tr>
        <thead>
        </thead>
        <tbody id="tbMain1">
        </tbody>
    </tr>
</table>
</div>

<div id="my_resource">
    <p id="resText">
        您还没有资源哦~
    </p>
<table id="res_table">
    <tr>
        <thead>
        </thead>
        <tbody id="tbMain2">
        </tbody>
    </tr>
</table>
</div>
</body>
</html>