var idValue;
var userNameValue;
var requestValue;
var state;
function getState() {
    if($.cookie('name')==undefined){
        $.cookie('name','');
        $.cookie('user_id',0);
    }
    //alert($.cookie('stateVal'));
    if($.cookie('stateVal')==undefined||$.cookie('stateVal').length==0||$.cookie('stateVal')==2){
        state=0;
        signclose();
    }else{
        state=1;
        signclose();
        document.getElementById('getName').innerHTML=$.cookie('name')
    }
}
//var exdays=1;
var APP_PATH='http://47.94.131.133:8080/QASite';
(function ()
{
    $('.change a').click(function ()
    {
        $('.signform').animate({height: 'toggle', opacity: 'toggle'}, 'slow');
    });
})

function start() {
    document.getElementById('signform').style.display="";
}

function loading() {
    document.getElementById('registerloading').style.display=""
}
function changePic(){
    var imgObj = document.getElementById("show");
    if(imgObj.getAttribute("src",2)=="picsInHomepage\\r_s2.png"){
        imgObj.src="picsInHomepage\\r_s1.png";
    }else{
        imgObj.src="picsInHomepage\\r_s2.png";
    }
}
function sign_in(){
    var mail = document.getElementById("user");
    var pwd = document.getElementById("pwd");
    $.ajax({
        type:"post",
        //url:'http://47.94.131.133:8080/QASite/common/login',
        url:APP_PATH+'/common/login',
        contentType:'application/json',
        data:JSON.stringify({
            email:mail.value,
            password:pwd.value
            //email:"9307a1@163.com",
            //password:"9307a1"
        }),
        success:function(result){
            if(result.status=='200'){
                document.getElementById('getName').innerHTML=result.data.userName;
                alert("登陆成功");
                $.cookie('stateVal',1);
                state=1;
                signclose();
                idValue=result.data.id;
                //alert(result.data.id);
                //document.cookie = "id=" + idValue + ";";
                $.cookie('user_id', idValue);
                userNameValue=result.data.userName;
                //alert(userNameValue);
                //document.cookie = "name=" + userNameValue + ";";
                $.cookie('name', userNameValue);
            }
            if(result.status=='300'){
                alert("用户名或密码不正确");
                state=0;
            }
            if(result.status=='400'){
                alert("请确保您有正确的权限");
                state=0;
            }
            //alert(result.status);
            //alert(reult.data.userName);

            //alert(result.status+result.message);
        }
    });

}
function signclose(){
    if(state==1) {
        document.getElementById('signform').style.display = "none";
        document.getElementById('signUpDiv').style.display = "none";
        document.getElementById('signInDiv').style.display = "none";
        document.getElementById('nameId').style.display = "block";
        document.getElementById('quit').style.display = "block";
    }else{
        document.getElementById('signform').style.display = "none";
        document.getElementById('signUpDiv').style.display = "";
        document.getElementById('signInDiv').style.display = "";
        document.getElementById('nameId').style.display = "none";
        document.getElementById('quit').style.display = "none";
    }
}
function searchOrResource(){
    var imgObj = document.getElementById("show");
    var textObj= document.getElementById("des").value;
    requestValue=textObj;
    if(imgObj.getAttribute("src",2)=="picsInHomepage\\r_s2.png"){
        $.cookie('resOrQues',"resource");
        $.cookie('resource', requestValue);
        $.cookie('resource_s',requestValue)
        window.location.href="search.jsp";
    }else{
        $.cookie('resOrQues',"question");
        $.cookie('question', requestValue);
        $.cookie('question_s',requestValue)
        window.location.href="search.jsp";
    }
}
function searchOrResource1(){
    if($.cookie('name')==''||
	$.cookie('stateVal')==undefined||
	$.cookie('stateVal').length==0||
	$.cookie('stateVal')==2){
        alert("您还没有登录");
    }else{
        window.location.href="publish.jsp";
    }
}

function quitFunc() {
    $.cookie('stateVal', '');
    //getState();
    location.reload();
}
