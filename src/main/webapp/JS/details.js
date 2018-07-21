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
function answer(){
	$("#answerImg").click(function(){
		if($(this).attr("class")=="active"){
			$(".answerArea").slideUp(180);
			$(this).removeClass("active");
		}
		else{
			$(".answerArea").slideDown(180);
			$(this).addClass("active");
		}
	})
}
function chooseBest(obj){
    var question_id=$.cookie('question_id');
    // var question_id="19";
    var user_id=$.cookie('user_id');
	// var user_id="111";
    $.ajax({
        type:"post",
        url:"http://47.94.131.133:8080/QASite/common/search/que",
        contentType:"application/json",
        data:JSON.stringify({
            question_id:question_id,
            user_id:user_id
        }),
        success:function(result){
        	if(result.data.status=="closed")
                alert("当前问题已有最佳答案！");
            else {
                var reply_id = obj.getAttribute("id");
                $.ajax({
                    type: "post",
                    url: "http://47.94.131.133:8080/QASite/user/best",
                    contentType: "application/json",
                    data: JSON.stringify({
                        reply_id:reply_id
                    }),
                    success: function (){
                        alert("最佳答案设置成功！");
                        location.reload();
                    },
                    error:function () {
                        alert("最佳答案设置失败！");
                    }
                })
                // //设置最佳答案接口
                // alert("dekiru");
            }
        },
        error:function () {
            alert("最佳答案设置失败！");
        }
    })
}
function shutUp(obj){
    var id = obj.getAttribute("id");
     // alert(id);
    // var punish_time="5";
    // var punish_point="5";
    $.ajax({
        type:"post",
        url:"http://47.94.131.133:8080/QASite/admin/mute",
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
function submitAnswer() {
	$("#submitImg").click(function () {
	    var user_id=$.cookie('user_id');
        // var user_id="118";
        var question_id=$.cookie('question_id');
        // var question_id="19";
        $.ajax({
            type: "post",
            url: "http://47.94.131.133:8080/QASite/user/newque/permission",
            contentType: "application/json",
            data: JSON.stringify({
                Id: user_id
            }),
            success: function (result) {
            	if(result.data.time>0){
            		alert("您已被禁言，不能回答！");
				}
				else{
            		var reply=document.getElementById("answerDesc").innerHTML;
            		$.ajax({
                        type: "post",
                        url: "http://47.94.131.133:8080/QASite/user/reply",
                        contentType: "application/json",
                        data: JSON.stringify({
							question_id:question_id,
                            replier_id: user_id,
							reply:reply
                        }),
                        success: function () {
                        	alert("回答成功！");
                        	location.reload();
						},
						error:function () {
							alert("回答失败！");
                        }
					})
				}
            },
			error: function () {
				alert("请求失败！");
            }
        })
    })
}
function closeQues(){
    $("#close").click(function() {
        var question_id=$.cookie('question_id');
        // var question_id="17";
        if ($("#close").attr("src") != "picsInHomepage/mute.png"&&$.cookie('isAd')=='TRUE') {
            $.ajax({
                type: "post",
                url: "http://47.94.131.133:8080/QASite/admin/question/close",
                contentType: "application/json",
                data: JSON.stringify({
                    question_id: question_id
                }),
                success: function () {
                    alert("关闭问题成功！");
                    $("#close").attr("src", "picsInHomepage/mute.png");
                    document.getElementById("answerContent").style.display = "none";
                },
				error:function () {
					alert("关闭问题失败！");
                }
            })
        }
    })
}
function deleteQues() {
	$("#delete").click(function () {
	    var question_id=$.cookie('question_id');
		// var question_id="20";
        $.ajax({
            type: "post",
            url: "http://47.94.131.133:8080/QASite/admin/question/delete",
            contentType: "application/json",
            data: JSON.stringify({
                question_id: question_id
            }),
            success: function () {
                alert("问题删除成功！");
                $.cookie('question_title','');
                $.cookie('question_id','');
                window.history.go(-1);
            },
            error:function () {
                alert("问题删除失败！");
            }
        })
    })
}
function loadQuestion(){
	var user_name=$.cookie('name');
	// var user_name=getCookie("name");
    var user_id=$.cookie('user_id');
    // var user_id="111";
    var question_id=$.cookie('question_id');
    // var question_id="19";
	if(user_name!=null&&user_name!=""){
        $("#bt1").html("<a href='personalHomepage.jsp'id='style1'>"+user_name+"</a>");
        $("#bt2").html("<a href = 'javascript:void(0)' id='style2' onclick ='resign()'>退出</a>");
    }
	$.ajax({
        type:"post",
        url:"http://47.94.131.133:8080/QASite/common/search/que",
        contentType:"application/json",
        data:JSON.stringify({
			question_id:question_id,
			user_id:user_id
        }),
        success:function(result){
        	// alert(question_id);
            // alert(result.data.viewer);
            if(result.data.shutup=="TRUE"){
                $("#ask").attr("src","picsInHomepage/reticenting.png");
            }
            if(result.data.viewer!="admin") {
                document.getElementById("ask").style.display = "none";
                document.getElementById("delete").style.display = "none";
                $.cookie('isAd','FALSE');
            }
            else{
                document.getElementById("answerContent").style.display = "none";
                $.cookie('isAd','TRUE');
            }
            $("#ask").attr("id",result.data.ariser_id);
            if(user_id==result.data.ariser_id){
                document.getElementById("answerContent").style.display = "none";
			}
			if(result.data.status=="closed"){
                $("#close").attr("src","picsInHomepage/mute.png");
                document.getElementById("answerContent").style.display = "none";
            }
            $("#title").html(result.data.question);
            $("#quesDate").html(result.data.time);
            $("#quesOwner").html(result.data.ariser);
            $("#gain").html("悬赏分："+result.data.credit);
            $("#desc").html(result.data.description);
            var normalAnswers="";
            var hasBest=false;
            for(var key in result.data.replies){
            	var answer="<div class='answerBlock'><div class='writing'>"+
					result.data.replies[key].content+
					"</div><div class='userRela' style='float: right;margin-top: 10px;margin-right: 17%'>" +
					"<a href='javascript:void(0)' onclick='chooseBest(this)'id='"+
					result.data.replies[key].reply_id+
					"' ><img src='picsInHomepage/star_normal.png' width='20px' id='bestAnswer'";
                if(user_id!=result.data.ariser_id)
                	answer+="style='display:none'";
                answer+= "></a><div class='date'>" +
					result.data.replies[key].time+
					"</div><div class='userID'>" +
					result.data.replies[key].replier+
					"</div><a href='javascript:void(0)' onclick='shutUp(this)' id='"+
					result.data.replies[key].replier_id+
					"'><img src='picsInHomepage/speaking.png' width='20px' class='speaking' ";
                if(result.data.viewer!="admin")
                    answer+="style='display:none'";
            	answer+="></a></div></div>";
            	//alert(result.data.replies[0].best);
                // alert(result.data.replies[key].shutup);
				if(result.data.replies[key].shutup=="TRUE")
					answer=answer.replace(/speaking.png/g, "reticenting.png");
                if(result.data.replies[key].best=="YES") {
                	answer=answer.replace(/star_normal/g, "star_best");
                	$("#best").html("<div class='subtitle'>最佳答案</div>" + answer +
                        "<hr style='height:2px;border:none;width:80%;float:left' color='#CCCCCC'/>");
                	hasBest=true;
				}
				else{
                	if(normalAnswers=="")
                		normalAnswers+=answer;
                	else
                		normalAnswers=normalAnswers+
							"<hr style='height:2px;border:none;width:73%;float:left;margin-left:5%' color='#CCCCCC'/>"+
							answer;
				}
            }
            if(normalAnswers==""){
            	if(!hasBest){
            		normalAnswers="<div class='subtitle'>一般答案</div>"+
                        "<div class='quesRela'><div class='relaTitle'>尚无答案，等你来回答</div></div>";
				}
			}
			else{
            	normalAnswers="<div class='subtitle'>一般答案</div>"+normalAnswers;
			}
            $("#normal").html(normalAnswers);
            loadRelaQues();
        },
		error:function () {
            alert("问题详情载入失败！");
            window.history.go(-1);
        }
	})
}
function loadRelaQues(){
	var type="question";
	var description=$.cookie('question_title');
	// var description=getCookie("description");
	// description="肥皂";
	var index=1;
	var length=5;
	$.ajax({
        type:"post",
        url:"http://47.94.131.133:8080/QASite/common/search",
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
        			var subRele="<div class='quesRela'><div class='relaTitle'><a href='javascript:void(0)' style='color:#666' onclick=\"relaQues('" +
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
        	alert("相关问题载入失败！");
        	window.history.go(-1);
        }
	})
}
function relaQues(title,id) {
    $.cookie('question_title',title);
    $.cookie('question_id',id);
    window.location.href="details.html";
}
function resign() {
    $.cookie('stateVal',2);
    $.cookie('name','');
    $.cookie('user_id','0');
    $.cookie('isAd','FALSE');
    location.reload();
}