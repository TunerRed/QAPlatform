function change() {
    $(".roundImg").click(function () {
		var id=$(this).attr("id");
		if(id=="woman"){
			if($(this).attr("src")==getName(id,0)){
            	$(this).attr("src",getName(id,1));
				$("#man").attr("src",getName("man",0));
			}
		}
		if(id=="man"){
			if($(this).attr("src")==getName(id,0)){
            	$(this).attr("src",getName(id,1));
				$("#woman").attr("src",getName("woman",0));
			}
		}
		if(id=="teacher"){
			if($(this).attr("src")==getName(id,0)){
            	$(this).attr("src",getName(id,1));
				$("#student").attr("src",getName("student",0));
			}
		}
		if(id=="student"){
			if($(this).attr("src")==getName(id,0)){
            	$(this).attr("src",getName(id,1));
				$("#teacher").attr("src",getName("teacher",0));
			}
		}
    })
}
function submit(){
	$("#register").click(function () {
        var user = document.getElementById("inputName");
		var man=document.getElementById("man");
		var sex;
		if(man.src==getName("man",1))
			sex="MALE";
		else
			sex="FEMALE";
		var teacher=document.getElementById("teacher");
		var type;
        if(teacher.src==getName("teacher",1))
			type="teacher";
		else
			type="student";
		var password=document.getElementById("inputPassword");
		var confirm=document.getElementById("inputConfirmPassword");
		var email=document.getElementById("inputMail");
        if(user.value==""||password.value==""||confirm.value==""||email.value=="") {
			alert("必填内容不能为空！");
			return;
		}
		if(password.value!=confirm.value) {
			alert("两次输入的密码不一致！");
            return;
        }
        $.ajax({
			type:"post",
			url:"http://localhost:8080/webapp/common/register",
			contentType:"application/json",
			data:JSON.stringify({
				userName:user.value,
				password:password.value,
				gender:sex,
				email:email.value,
				type:type
			}),
			success:function(result){
               if(result.status==200) {
                   alert("注册成功！");
                   window.location.href = "index.jsp";
               }
               else{
					alert("注册失败！该邮箱已被使用！");
				}
			},
			error:function () {
				alert("注册失败！");
            }
		});
    })
}
function getName(id,state){
    var name;
    if(state==1)
        name="picsInHomepage/"+id+"_on.png";
    if(state==0)
        name="picsInHomepage/"+id+"_off.png";
    return name;
}