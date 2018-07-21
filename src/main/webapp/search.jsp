<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/18
  Time: 10:19
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
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <title>search</title>
    <!--引入css样式表-->
    <link href="CSS/search.css" rel="stylesheet" type="text/css">
    <!--引入JavaScript-->
    <script src="JS/search.js"></script>
</head>
<body onload=" preSet(),appendQuestionText()">
<div>
    <div style="height:86px;">
        <img src="picsInHomepage/top_bar.png" id="top_bar">
        <img src="picsInHomepage/r_s1.png" width="120" id="type">
        <input type="text" id="search">
        <img src="picsInHomepage/question_icon.png" width="30" id="question">
        <a href="publish.html">
            <img src="picsInHomepage/plus_icon.png" width="30" id="plus" style="z-index:100">
        </a>
        <div class="login" id="bt1">
            <a href="index.jsp" id="style1">登录</a>
        </div>
        <div class="login" id="bt2" style="margin-left:94%;">
            <a href="register.html" id="style2">注册</a>
        </div>
    </div>
    <div id="user"><a id="userName" style="color: white;"></a></div>
        <div id="quit">
            <p id="quitText" onclick="quitFunc()">退出登录</p>
        </div>
    <div id="bg">
        <div id="list"></div>
    </div>
    <script>
        $(document).ready(function () {
            search();
        });
    </script>
</div>
</body>
</html>
