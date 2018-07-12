var id;
var userName;
var question;

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
        url:'http://localhost:8080/webapp/common/login',
        contentType:'application/json',
        data:JSON.stringify({
            email:mail.value,
            password:pwd.value
            //email:"9307a1@163.com",
            //password:"9307a1"
        }),
        success:function(result){
            if(result.status==200){
                alert("登陆成功");
                document.getElementById('getName').innerHTML=result.data.userName;
            }else{
                alert(result.message);
            }
            //alert(reult.data.userName);
            //alert(result.status+result.message);
        }
    });

}
function signclose(){
    document.getElementById('signform').style.display="none";
    document.getElementById('signUpDiv').style.display="none";
    document.getElementById('signInDiv').style.display="none";
    document.getElementById('nameId').style.display="block";
}
function searchOrResource(){
    var imgObj = document.getElementById("show");
    var textObj= document.getElementById("getName").innerHTML;
    if(imgObj.getAttribute("src",2)=="picsInHomepage\\r_s2.png"){
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
                console.log("resource");
            }
        });
    }else{
        $.ajax({
            type:"post",
            url:'http://localhost:8080/webapp/common/search',
            contentType:'application/json',
            data:{
                type:"question",
                description:"${textObj}",
                index:1,
                length:10
            },
            success:function(result){
                console.log("question:"+result.data[0].title);
            }
        });
    }
}
function setCookie(){
    var d = new Date();
    d.setTime(d.getTime()+(exdays*24*60*60*1000));
    var expires = "expires="+d.toGMTString();
    document.cookie = id + "=" + idValue + "; " + expires;
}
function setCookie(){
    var d = new Date();
    d.setTime(d.getTime()+(exdays*24*60*60*1000));
    var expires = "expires="+d.toGMTString();
    document.cookie = userName + "=" + userNameValue + "; " + expires;
}
function setCookie(){
    var d = new Date();
    d.setTime(d.getTime()+(exdays*24*60*60*1000));
    var expires = "expires="+d.toGMTString();
    document.cookie = question + "=" + questioinValue + "; " + expires;
}