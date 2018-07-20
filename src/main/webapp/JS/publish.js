//获取资源还是问题
function change() {
    $("#questionImg").click(function () {
        if($("#questionImg").attr("src")==="picsInHomepage/question.png"){
            $("#questionImg").attr("src","picsInHomepage/resource.png");
            $("#uploaddiv").show();
        }else{
            $("#questionImg").attr("src","picsInHomepage/question.png");
            $("#uploaddiv").hide();
        }
    })
}

function isChooseFile() {
    $("#inputfile").mouseleave(function () {
        if($("#inputfile").val()!=""){
            $("#resourse_isclick").attr("src","picsInHomepage/resource_clicked.png");
        }else{
            $("#resourse_isclick").attr("src","picsInHomepage/resource_unclicked.png");
        }
    });
}