tempType='question'
questionName=$.cookie('question')
targetURL='http://47.94.131.133:8080/QASite'

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
        questionName=$("#search").val()
        appendQuestionText()
    })
    // test()
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
            length:1   //查询多少条数据，即查询数据库中第index~index+length条数据
        }),
        success:function(result) {
            alert('success')

            var title=result.data[0].title;
            var description=result.data[0].description;
            var time=result.data[0].time;

            var txt1=$("<a ></a>").text(title);
            var txt2=$("<p></p>").text(description);  // 使用 jQuery 创建文本
            var txt3=$("<span></span>").text(time);
            $("#list").append("<div>",txt1,txt2,txt3,"</div>");
        },
        error: function(XMLHttpRequest) {
            alert('status:'+XMLHttpRequest.status);
             // alert(XMLHttpRequest.readyState);
             // alert(textStatus);
        },
    });
}

function preSet() {
    // $('#userName').text($.cookie('name'))
    if($.cookie('user_id')!='null'&&$.cookie('name')!='null'){
        $("#bt1").hidden
        $("#bt2").hidden
        $("#user").show
        $("#userName").text($.cookie('name'))
    }
}
