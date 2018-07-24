var APP_PATH='http://47.94.131.133:8080/QASite';
var myId;
var quesArr=new Array();
var replyArr=new Array();
var resArr=new Array();
var queExist;
var replyExit;
var resExit;
var myPage=1;
//var strCookie=document.cookie;
//var matchCookie=" name";
//var getMatchCookie;
function getDesCookie(){
    //alert($(window).height());
    myId=$.cookie('user_id');
    //alert(myId)
    document.getElementById('getName').innerHTML=$.cookie('name');
    if($.cookie('stateVal')==2){
        $.cookie('stateVal','');
        window.location.href="index.jsp";
    }else{
        $.cookie('stateVal',1);
    }
}
// function changeStyle(){
//     wHeight=$(window).height();
//     var img=new Image();
//     img.src="picsInHomepage\\top.png";
//     // alert(wHeight);
//     // alert(img.height);
//      document.getElementById('personalInfo').style.height=(wHeight-img.height).toString()+"px";
//     // alert((wHeight-img.height).toString());
//     //document.getElementById('personalInfo').style.height="400px";
// }
function getInfo(){
    $.ajax({
        type:'post',
        url:APP_PATH+'/user/info',
        contentType:'application/json',
        data:JSON.stringify({
            id:myId,
        }),
        success:function(result){
            //alert(result.gender);
            var imgObj1 = document.getElementById("genderPic");
            var imgObj2 = document.getElementById("positionPic");
            if(result.data.gender=="MALE"){
                imgObj1.src="picsInHomepage/man_on.png";
            }else{
                imgObj1.src="picsInHomepage/woman_on.png";
            }
            if(result.data.type=="student"){
                imgObj2.src="picsInHomepage/student_on.png";
            }else{
                imgObj2.src="picsInHomepage/teacher_on.png";
            }
            var credits=result.data.credit;
            //alert(result.data.credit);
            document.getElementById('myCredit').innerHTML="积分 "+credits;
        },
    })
}
function question(){
	 $.ajax({
            type:'post',
            url:APP_PATH+'/user/questions',
            contentType:'application/json',
            data:JSON.stringify({
                Id:myId,
                //page:myPage,
         }),
            success:function(result){
                var tbody =document.getElementById('tbMain')
                //var tr = "<tr>";
                if(result.data != null && result.data.length!=0){
                    for(var i=0;i<result.data.length;i++){
                    quesArr[i]=result.data[i].question_id;
                    var row = document.createElement('tr');
                    var titleCell = document.createElement('td');
                    titleCell.innerHTML = result.data[i].title;
                    row.appendChild(titleCell);
                    titleCell.style.cursor="pointer";
                    titleCell.onclick=function () {
                        setThisCookie(this);
                        //alert(row.rowIndex);
                        // $.cookie('question_title', result.data[row.rowIndex].title);
                        // $.cookie('question_id', result.data[i].question_id);
                         window.location.href="details.html";
                    }
                    var dateCell = document.createElement('td');
                    dateCell.innerHTML = result.data[i].date;
                    row.appendChild(dateCell);
                    var replyCell = document.createElement('td');
                    replyCell.innerHTML = result.data[i].reply_count+"个回复";
                    row.appendChild(replyCell);
                    var statusCell = document.createElement('td');
                    if(result.data[i].status=="closed"){
                        statusCell.innerHTML = "有最佳答案";
                    }else{
                        statusCell.innerHTML = "无最佳答案";
                    }
                    //statusCell.innerHTML = result.data[i].status;
                    row.appendChild(statusCell);
                    tbody.appendChild(row);
                    }
                }else{
                    document.getElementById('que_table').style.display="none";
                    document.getElementById('queText').style.display="block";
                }
            },
            
        })
}
function reply(){
    $.ajax({
        type:'post',
        url:APP_PATH+'/user/answers',
        contentType:'application/json',
        data:JSON.stringify({
            user_id:myId,
            //page:myPage,
        }),
        success:function(result){
            var tbody =document.getElementById('tbMain1')
            //var tr = "<tr>";
            //alert(result.data);
            if(result.data != null && result.data.length !=0){
                for(var i=0;i<result.data.length;i++){
                replyArr[i]=result.data[i].question_id;
                var row = document.createElement('tr');
                var titleCell = document.createElement('td');
                titleCell.innerHTML = result.data[i].title;
                //var titleVal=result.data[i].title;
                row.appendChild(titleCell);
                //$.cookie('qustion_title', result.data[i].title);
                titleCell.style.cursor="pointer";
                titleCell.onclick=function () {
                    setThisCookie1(this);
                    ///alert(result.data[i].title);
                    //$.cookie('question_title', result.data[i].title);
                    //$.cookie('question_id', result.data[i].question_id);
                    window.location.href="details.html";
                }
                var dateCell = document.createElement('td');
                dateCell.innerHTML = result.data[i].time;
                row.appendChild(dateCell);

                var statusCell = document.createElement('td');
                if(result.data[i].status=="closed"){
                    statusCell.innerHTML = "有最佳答案";
                }else{
                    statusCell.innerHTML = "无最佳答案";
                }
                row.appendChild(statusCell);
                //alert(result.data[i].mybest);
                var replyCell = document.createElement('td');
                if(result.data[i].mybest=="NO"){
                    replyCell.innerHTML==" ";
                }else{
                    replyCell.innerHTML=="我是最佳";
                }
                row.appendChild(replyCell);

                tbody.appendChild(row);
                //alert("123");
                //alert(tbody);
                }
            }else {
                //alert("123");
                document.getElementById('reply_table').style.display="none";
                document.getElementById('replyText').style.display="block";
            }
        },

    })
}
function resource(){
    $.ajax({
        type:'post',
        url:APP_PATH+'/user/resources',
        contentType:'application/json',
        data:JSON.stringify({
            Id:myId,
            //page:myPage,
        }),
        success:function(result){
            var tbody =document.getElementById('tbMain2')
            //var tr = "<tr>";
            //alert(result.data);
            if(result.data != null && result.data.length !=0) {
                for (var i = 0; i < result.data.length; i++) {
                    resArr[i]=result.data[i].resource_id;
                    var row = document.createElement('tr');
                    var titleCell = document.createElement('td');
                    titleCell.innerHTML = result.data[i].name;
                    row.appendChild(titleCell);
                    //$.cookie('qustion_title', result.data[i].title);
                    titleCell.style.cursor = "pointer";
                    titleCell.onclick = function () {
                        setThisCookie2(this);
                        //$.cookie('resource_title', result.data[i].name);
                        //$.cookie('resource_id', result.data[i].resource_id);//待定
                        window.location.href = "detailsf.html";
                    }
                    var dateCell = document.createElement('td');
                    dateCell.innerHTML = result.data[i].date;
                    row.appendChild(dateCell);
                    var replyCell = document.createElement('td');
                    replyCell.innerHTML = result.data[i].point + "积分";
                    row.appendChild(replyCell);
                    tbody.appendChild(row);
                }
            }else {
                document.getElementById('res_table').style.display="none";
                document.getElementById('resText').style.display="block";
            }
        },

    })
}
function changePic1(){
	var imgObj1 = document.getElementById("pic1");
		imgObj1.src="picsInHomepage/my_question_on.png";
	var imgObj2 = document.getElementById("pic2");
		imgObj2.src="picsInHomepage/my_reply.png";
	var imgObj3 = document.getElementById("pic3");
		imgObj3.src="picsInHomepage/my_resource.png";
	document.getElementById('my_question').style.display="block";
	document.getElementById('my_reply').style.display="none";
	document.getElementById('my_resource').style.display="none";
}
function changePic2(){
	var imgObj1 = document.getElementById("pic1");
		imgObj1.src="picsInHomepage/my_question.png";
	var imgObj2 = document.getElementById("pic2");
		imgObj2.src="picsInHomepage/my_reply_on.png";
	var imgObj3 = document.getElementById("pic3");
		imgObj3.src="picsInHomepage/my_resource.png";
	document.getElementById('my_question').style.display="none";
	document.getElementById('my_reply').style.display="block";
	document.getElementById('my_resource').style.display="none";
}
function changePic3(){
	var imgObj1 = document.getElementById("pic1");
		imgObj1.src="picsInHomepage/my_question.png";
	var imgObj2 = document.getElementById("pic2");
		imgObj2.src="picsInHomepage/my_reply.png";
	var imgObj3 = document.getElementById("pic3");
		imgObj3.src="picsInHomepage/my_resource_on.png";
	document.getElementById('my_question').style.display="none";
	document.getElementById('my_reply').style.display="none";
	document.getElementById('my_resource').style.display="block";
}

// function getName() {
//     var arr1=strCookie.split(/[;=]/);
//     //var arr1=arr0.split("=");
//     for(var i=0; i<arr1.length; i+=2){
//         //alert(arr1[i]);
//         if(arr1[i]==" name"){
//             document.getElementById('getName').innerHTML=arr1[i+1];
//         }
//     }
// }
function setThisCookie(column) {
    //alert(quesArr[column.parentNode.rowIndex-1]);
    $.cookie('question_title',column.innerHTML);
    $.cookie('question_id',quesArr[column.parentNode.rowIndex-1]);
}
function setThisCookie1(column) {
    //alert(quesArr[column.parentNode.rowIndex-1]);
    $.cookie('question_title',column.innerHTML);
    $.cookie('question_id',replyArr[column.parentNode.rowIndex-1]);
}
function setThisCookie2(column) {
    //alert(quesArr[column.parentNode.rowIndex-1]);
    $.cookie('resource_title',column.innerHTML);
    $.cookie('resource_id',resArr[column.parentNode.rowIndex-1]);
}
function setWidth() {
    document.getElementById('my_question').style.width=($(window).width()-370)+'px';
    document.getElementById('my_question').style.height=($(window).height()-150)+'px';
    document.getElementById('my_reply').style.width=($(window).width()-370)+'px';
    document.getElementById('my_reply').style.height=($(window).height()-150)+'px';
    document.getElementById('my_resource').style.width=($(window).width()-370)+'px';
    document.getElementById('my_resource').style.height=($(window).height()-150)+'px';
    //document.getElementById('personalInfo').style.height=($(window).height()-85)+'px';
}