function change() {
    $("#type").click(function () {
        if($(this).attr("src")=="picsInHomepage/r_s1.png"){
            $(this).attr("src","picsInHomepage/r_s2.png");
        }
        else{
            $(this).attr("src","picsInHomepage/r_s1.png");
        }
    })
}
function search() {
    $("#question").click(function () {
        var searchBox=$("#search").val();
        if($("#type").attr("src")=="picsInHomepage/r_s1.png") {
            $.cookie('question', searchBox);
            $.cookie('resOrQues','question');
        }
        else {
            $.cookie('resource', searchBox);
            $.cookie('resOrQues','resource');
        }
        window.location.href="search.jsp";
    })
}
function download() {
    $("#download").click(function () {
        var id=$.cookie('user_id');
        //var id="111";
        var resource_id=$.cookie('resource_id');
        //var resource_id="4";
        var resource_title=$.cookie('resource_title');
        //var resource_title="Android.pdf";
        $.ajax({
            type: "post",
            url: "http://localhost:8080/webapp/user/download",
            contentType: "application/json",
            data: JSON.stringify({
                Id: id,
                resource_id:resource_id
            }),
            success: function (result) {
                if(result.status==200){
                    // alert(result.data.address);
                    // window.location.href=result.data.address;
                    // window.open(result.data.address);
                    var gotolink = document.createElement('a');
                    gotolink.href = result.data.address;
                    gotolink.setAttribute("download", resource_title);
                    document.body.appendChild(gotolink);
                    gotolink.click();
                }
                else if(result.status==300){
                    alert("找不到资源！");
                }
                else {
                    alert("积分不足，不能下载！");
                }
            },
            error:function () {
                alert("请求失败！");
            }
        })
    })
}
function shutUp(obj){
    var id = obj.getAttribute("id");
    // alert(id);
    // var punish_time="5";
    // var punish_point="5";
    $.ajax({
        type:"post",
        url:"http://localhost:8080/webapp/admin/mute",
        contentType:"application/json",
        data:JSON.stringify({
            Id:id
            // punish_time:punish_time,
            // punish_point:punish_point
        }),
        success:function(result){
            if(result.status==300)
                alert("该用户已被禁言！");
            else {
                alert("禁言成功！");
                location.reload();
            }
        },
        error:function () {
            alert("操作失败！");
        }
    })
}
function deleteResource() {
    $("#delete").click(function () {
        var resource_id=$.cookie('resource_id');
        //var resource_id="5";
        $.ajax({
            type: "post",
            url: "http://localhost:8080/webapp/admin/resource",
            contentType: "application/json",
            data: JSON.stringify({
                resource_id:resource_id
            }),
            success: function () {
                alert("资源删除成功！");
                $.cookie('resource_title','');
                $.cookie('resource_id','');
                window.history.go(-1);
            },
            error:function () {
                alert("资源删除失败！");
            }
        })
    })
}
function loadResource() {
    var user_name = $.cookie('name');
    //var user_name="aaaaa";
    var user_id = $.cookie('user_id');
    //var user_id="111";
    var resource_id = $.cookie('resource_id');
    //var resource_id="4";
    if (user_name != null && user_name != "") {
        $("#bt1").html("<a href='personalHomepage.jsp'id='style1'>" + user_name + "</a>");
        $("#bt2").html("<a href = 'javascript:void(0)' id='style2' onclick ='resign()'>退出</a>");
    }
    $.ajax({
        type: "post",
        url: "http://localhost:8080/webapp/common/search/res",
        contentType: "application/json",
        data: JSON.stringify({
            resource_id: resource_id,
            user_id: user_id
        }),
        success: function (result) {
            // alert(resource_id);
            // alert(result.data.viewer);
            if (result.data.shutup == "TRUE") {
                $("#ask").attr("src", "picsInHomepage/reticenting.png");
            }
            if (result.data.viewer != "admin") {
                document.getElementById("ask").style.display = "none";
                document.getElementById("delete").style.display = "none";
            }
            $.cookie('resource_title',result.data.resource);
            $("#ask").attr("id", result.data.uploader_id);
            $("#title").html(result.data.resource);
            $("#quesDate").html(result.data.time);
            $("#quesOwner").html(result.data.uploader);
            $("#gain").html("下载所需积分：" + result.data.point);
            $("#down").html("下载次数："+result.data.download_times);
            $("#desc").html(result.data.description);
             // alert(result.data.format);
            var preview="";
            if(result.data.format=="video"){
                // $("#preview").attr("src", result.data.address);
                // document.getElementById("video").style.display="";
                preview="<video width='100%' controls id='video'><source src='"+
                    result.data.address+
                    "' type='video/mp4' id='preview'>" +
                    "抱歉，您的浏览器不支持视频预览！" +
                    "</video>";
            }
            else if(result.data.format=="document"){
                // $("#pdfRead").attr("src", result.data.address);
                // document.getElementById("pdfRead").style.display="";
                preview="<iframe src='generic/web/viewer.html?file=../../"+
                    result.data.address+
                    "' width='100%' height='500px' id='pdfRead'></iframe>";
            }
            $("#allPre").html(preview);
            loadRelaRes();
        },
        error: function () {
            alert("资源详情载入失败！");
            window.history.go(-1);
        }
    })
}
function loadRelaRes(){
    var type="resource";
    var description=$.cookie('resource_title');
    //var description="肥皂";
    var index=1;
    var length=5;
    $.ajax({
        type:"post",
        url:"http://localhost:8080/webapp/common/search",
        contentType:"application/json",
        data:JSON.stringify({
            type:type,
            description:description,
            index:index,
            length:length
        }),
        success:function(result){
            var rele="";
            if(result.message!="ok"){
                rele="<div class='quesRela'><div class='relaTitle'>" +
                    result.message +
                    "</div></div>";
            }
            else{
                for(var key in result.data){
                    var subRele="<div class='quesRela'><div class='relaTitle'><a href='javascript:void(0)' style='color:#666' onclick=\"relaRes('" +
                        result.data[key].title+"','"+
                        result.data[key].id+"')\">"+
                        result.data[key].title +"</a>"+
                        "</div><div class='relaDate'>" +
                        result.data[key].time +
                        "</div></div>";
                    rele+=subRele;
                }
            }
            $("#rele").html(rele);
            document.getElementById("body_id").style.display="";
        },
        error:function () {
            alert("相关资源载入失败！");
            window.history.go(-1);
        }
    })
}
function relaRes(title,id) {
    $.cookie('resource_title',title);
    $.cookie('resource_id',id);
    window.location.href="detailsf.html";
}
function resign() {
    $.cookie('name','');
    location.reload();
}