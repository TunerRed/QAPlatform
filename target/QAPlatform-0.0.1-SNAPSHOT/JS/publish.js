permission=false     //权限
targetURL='http://47.94.131.133:8080/QASite'

//获取资源还是问题
function change() {
    var ques=true  //判断当前是否发布问题
    $("#questionImg").click(function () {
        if ($("#questionImg").attr("src") === "picsInHomepage/question.png") {
            $("#questionImg").attr("src", "picsInHomepage/resource.png");
            $("#uploaddiv").show();
            isChooseFile();
        } else {
            $("#questionImg").attr("src", "picsInHomepage/question.png");
            $("#uploaddiv").hide();
        }
    });
    $("#publish").click(function () {
          
        if($("#questionImg").attr("src") === "picsInHomepage/question.png"){
            if(permission==true){
                publish()
            }
        }else{
            $("form").submit();
			alert('上传成功')
        }
        })
}
//判断是否选择了资源
function isChooseFile() {
    $("#inputfile").click(function () {
        $("#inputfile").mouseout(function () {
            if ($("#inputfile").val() != "") {
                $("#resourse_isclick").attr("src", "picsInHomepage/resource_clicked.png");
            } else {
                $("#resourse_isclick").attr("src", "picsInHomepage/resource_unclicked.png");
            }
        });
    });
}


//发布
function publish() {
    var date=new Date()
    var dateString=getNowFormatDate(date)
    $.ajax({
        type: "POST",
        url: targetURL+'/user/ask',
        contentType:'application/json',
        data: JSON.stringify({
            question: $("#question").val(),
            description: $("#description").val(),
            questioner:$.cookie('name'),
            questioner_id: $.cookie('user_id'),//$.cookie('questioner_id'),
            point: $("#wanted").val(),
            time: dateString,//问题发布的时间
        }),
        success: function (result) {
            if(result.status==200){
                alert("发布成功")
                }else{
                if(result.status==300){
                    alert('积分不足')
                }
            }
        }
    })
}

//发布权限检查
function publishPermissionCheck() {

    $.ajax({
        type: "POST",
        url: targetURL+'/user/newque/permission',
        contentType:'application/json',
        data: JSON.stringify({
            Id: $.cookie('user_id')
        }),
        success: function (result) {
            if(result.status==200){
                permission=true
            }else{
                if(result.status==400){
                    alert("禁言中!解禁天数还有："+result.data.time)
                    permission=false
                }
            }
        }
    });
}

//获取当前时间，格式YYYY-MM-DD
function getNowFormatDate(date) {
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();

    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}

function preSet() {   //本次修改
    isLogin()
    if(isLogin==true){
        $("#bt1").html("<a href='personalHomepage.jsp' id='style1'>"+$.cookie('name')+"<a>");
        $("#bt2").html("<a id='style2' onclick='quitFunc()'href=''>退出登录<a>");
        $("#userName").text($.cookie('name'))
		publishPermissionCheck()
    }else{
        $("#bt1").html("<a href='index.jsp' id='style1'>登录<a>")
        $("#bt2").html("<a href='register.html' id='style2'>注册<a>")
    }
}
function isLogin() {
    if($.cookie('stateVal')==undefined||$.cookie('stateVal').length==0||$.cookie('stateVal')==2){
        isLogin=false;
    }else{
        isLogin=true;
    }
}

function quitFunc() {
    $.cookie('stateVal',2);
    preSet();
}