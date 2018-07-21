targetURL='http://localhost:8080/webapp'
message=new Array();

function search() {
    //更换问题资源选择
    $("#type").click(function () {
        if($("#type").attr("src")==="picsInHomepage/r_s1.png"){
            $("#type").attr("src","picsInHomepage/r_s2.png");
            tempType='resource';
        }else{
            $("#type").attr("src","picsInHomepage/r_s1.png");
            tempType='question';
        }
    })
//显示搜索内容
    $("#question").click(function () {
        $("#list").empty();
        questionName=$("#search").val();
        appendQuestionText();
        if($("#type").attr("src")==="picsInHomepage/r_s1.png"){
            $.cookie('resOrQues',"question");
        }else{
            $.cookie('resOrQues',"resource");
        }
    })

}


//追加文本
function appendQuestionText()
{
    $.ajax({
        type:"POST",
        url:targetURL+"/common/search",
        contentType:"application/json",
        data:JSON.stringify({
            type:tempType,
            description:questionName,
            index:1,    //查询第几条数据
            length:30   //查询多少条数据，即查询数据库中第index~index+length条数据
        }),
        success:function(result) {
             //alert(result.data.length);
             if(result.data==null){
                 var txt1=$("<a id=i style='text-decoration: none; cursor: default'></a>").text("未搜索到相关信息");
             }
            $("#list").append("<div>",txt1,"</div>");
            for(var i=0;i<result.data.length;i++){

                message[i]=new Array(i);

                var title=result.data[i].title;
                var description=result.data[i].description;
                var time=result.data[i].time;

                message[i][0]=title;
                message[i][1]=description;
                message[i][2]=result.data[i].id;

                var txt1=$("<a id='temp' onclick='toDetail(this)'></a>").text(title);
                var txt2=$("<p></p>").text(description);  // 使用 jQuery 创建文本
                var txt3=$("<span></span>").text(time);
                $("#list").append("<div>",txt1,txt2,txt3,"</div>");
                $("#temp").attr("id",i);
            }
        },
        // error: function(XMLHttpRequest) {
        //     var txt1=$("<a id=i></a>").text("未搜索到相关信息");
        //
        //     $("#list").append("<div>",txt1,"</div>");
        // },
    });
}

function preSet() {
    if($.cookie('resOrQues')=='question'){
        tempType='question';
        questionName=$.cookie('question');
        $("#search").val(questionName);
    }else {
        if( $.cookie('resOrQues')=='resource'){
            tempType='resource';
            $("#type").attr("src","picsInHomepage/r_s2.png");
            questionName=$.cookie('resource');
            $("#search").val(questionName);
        }
    }
    //isLogin();
    //var isogin=true;
    if(isLogin()==true){
        // $("#bt1").hidden;
        // $("#bt2").hidden;
        // $("#user").show;
        document.getElementById('bt1').style.display="none";
        document.getElementById('bt2').style.display="none";
        document.getElementById('user').style.display="block";
        document.getElementById('quit').style.display="block";
        $("#userName").text($.cookie('name'));
    }else{
        document.getElementById('bt1').style.display="block";
        document.getElementById('bt2').style.display="block";
        document.getElementById('user').style.display="none";
        document.getElementById('quit').style.display="none";
    }
}

function isLogin() {
    if($.cookie('stateVal')==undefined||$.cookie('stateVal').length==0||$.cookie('stateVal')==2){
        return false;
    }else{
        return true;
    }
}

function toDetail(node) {
       var num=node.id;
        //alert(num)
        if(isLogin=false){
            $.cookie('user_id',0);
        }
    //alert(message.length);
    // alert($.cookie('resOrQues'));
        if(message.length>0){
            $.cookie('question_title',message[num][0]);
            $.cookie('description',message[num][1]);
            $.cookie('resource_title',message[num][0]);
            if($.cookie('resOrQues')=='question'){
                $.cookie('question_id',message[num][2]);
            }else {
              if( $.cookie('resOrQues')=='resource'){
                    $.cookie('resource',message[num][2]);
                  $.cookie('resource_id',message[num][2]);
                }
            }
        }
    // alert($.cookie('resOrQues'));
    // if($("#type").attr("src","picsInHomepage/r_s2.png")){
    if($.cookie('resOrQues')=='resource'){
        window.location.href="detailsf.html";
        }else{
            window.location.href="details.html"
        }
}
function quitFunc() {
    $.cookie('stateVal',2);
    preSet();
}