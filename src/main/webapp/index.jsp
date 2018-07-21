<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
    <title>
        智能问答平台
    </title>
    <%
        pageContext.setAttribute("APP_PATH", "http://47.94.131.133:8080/QASite");
    %>
    <style>
        *{
            box-sizing:border-box;
        }
        html,body,div,span,applet,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,big,cite,code,del,dfn,em,img,ins,kbd,q,s,samp,small,strike,strong,sub,sup,tt,var,b,u,i,dl,dt,dd,ol,nav ul,nav li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td,article,aside,canvas,details,embed,figure,figcaption,footer,header,hgroup,menu,nav,output,ruby,section,summary,time,mark,audio,video{
            margin:0;
            padding:0;
            border:0;
            font-size:100%;
            font:inherit;
            vertical-align:baseline;
            color:inherit;
            outline:0;
        }
        article, aside, details, figcaption, figure,footer, header, hgroup, menu, nav, section {
            display: block;
        }
        ol,ul{
            list-style:none;
            margin:0px;
            padding:0px;
        }
        blockquote,q{
            quotes:none;
        }
        blockquote:before,blockquote:after,q:before,q:after{
            content:'';
            content:none;
        }

    </style>
    <link rel="stylesheet" type="text/css" href="CSS\sign.css" />
    <script type="text/javascript" src="JS\signformchange.js"></script>
    <script type="text/javascript" src="JS\jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="JS\jquery.cookie.js"></script>
</head>
<body background="picsInHomepage\bg.jpg" style=" background-repeat:no-repeat ;background-size:100% 100%; background-attachment: fixed;" onload="getState()">
<div style="position:relative; height:5%; width:100%">
</div>
<div id="nameId">
    <a style="cursor: pointer; text-decoration:none;" href="personalHomepage.jsp">
    <p id="getName">
    </p>
    </a>
</div>
<div id="quit">
    <a style="cursor: pointer; text-decoration:none;">
        <p id="quitText" onclick="quitFunc();">
            退出登录
        </p>
    </a>
</div>
<div id="signUpDiv" style="position:relative; float:left; width:85%; height:10%; text-align:right;">
    <a onclick="start()" style="color:white; font-size:1.3em; cursor:pointer">
        登 录
    </a>
</div>
<div id="signInDiv" style="position:relative; float:right; width:13%; height:10%; text-align:left;">
    <a style="text-decoration:none; color:white; font-size:1.3em; cursor:pointer" href="register.html">
        注 册
    </a>
</div>
<div style="position:relative;height:5%;float:left; width:100%">
</div>
<div style="position:relative; float:left; height:25%; width:100%;">
    <img src="picsInHomepage\title.png" style="width:60%;">
</div>
</div>
<div style="position:relative; height:8em;float:left; width:100%">
</div>
</div>
<div style="position:relative; height:15%;float:left; width:20%">
</div>
<div style="position:relative; float:left; height:15%; width:10%;">
    <img id="show" src="picsInHomepage\r_s1.png" onclick="changePic()" style="cursor:pointer; width:100%;" />
</div>
<div style="position:relative; float:left; width:47%;border-bottom:.1em solid #fff;margin-left:1em">
    <input id="des" style="display:inline-block;margin-left:0%; width:85%;border:none; BACKGROUND-COLOR: transparent;  outline:none; color:white; font-size:1.3em;">
    <div style="display:inline-block">
        <a style="cursor:pointer;">
            <img src="picsInHomepage\question_icon.png" style="width:60%" onclick="searchOrResource()" href="publish.jsp"/>
        </a>
    </div>
    <div style="display:inline-block">
        <a style="cursor:pointer;">
            <img src="picsInHomepage\plus_icon.png" style="width:60%" onclick="searchOrResource1()" href="search.jsp"/>
        </a>
    </div>
</div>


<div class="signform" id="signform" style="display: none">
    <div class="signclose">
        <a  onclick="signclose()" style="color:#5f9fc9; font-size:2em;">
            X
        </a>
    </div>
    <div style="position:relative; height:20%; width:100%; margin-top:12%;">
        <img src="picsInHomepage\login_logo.png" style="width:120px; height:65px;">
    </div>
    <div style="position:relative; height:10%; width:100%; margin-left:5%; color:#5f9fc9; font-size:1.3em; text-align:left;">
        用 户 名
    </div>
    <div class="userdiv">
        <input id="user" class="signinput" type="text" name="user" value="1234@163.com">
    </div>
    <div style="margin-top:3%; position:relative; height:10%; width:100%; margin-left:5%; color:#5f9fc9; font-size:1.3em; text-align:left;">
        密 码
    </div>
    <div class="pwddiv">
        <input id="pwd" class="signinput" type="password" name="pwd" value="123456">
    </div>
    <div class="postdiv" >
        <img src="picsInHomepage\login_button.png" style="width:75%; cursor:pointer;" onclick="sign_in()"/>
    </div>
    <br>
</div>
</body>
</html>