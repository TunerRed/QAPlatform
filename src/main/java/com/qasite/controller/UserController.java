package com.qasite.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.qasite.bean.*;
import com.qasite.dao.QuestionMapper;
import com.qasite.result.Result;
import com.qasite.result.ResultCache;
import com.qasite.service.CommonService;
import com.qasite.service.ResourceService;
import com.qasite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CommonService commonService;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/user/info",method =RequestMethod.POST)
    @ResponseBody
    public Result userInfo(@RequestBody Map<String,String> map){
        Integer id = Integer.parseInt(map.get("id"));
        User user = userService.getUserInfo(id);
        if (user==null)
            return  ResultCache.getFailureDetail("错误的ID，找不到该用户！");
        return ResultCache.getDataOk(user);
    }

    @RequestMapping(value = "/user/change",method =RequestMethod.POST)
    @ResponseBody
    public Result changeInfo(@RequestBody User user){
        User targetUser = userService.getUserInfo(user.getId());
        if (targetUser==null)
            return  ResultCache.getFailureDetail("错误的ID，找不到该用户！");//除非修改cookie否则基本不会出现的错误
        if (userService.checkUserInfo(user)){
            userService.updateUserInfo(user);
            return ResultCache.getDataOk(null);
        }
        return ResultCache.getFailureDetail("该邮箱已被注册");
    }

    /*
    * 返回用户提出的问题
    * */
    @RequestMapping(value = "user/questions",method =RequestMethod.POST)
    @ResponseBody
    public Result showQuestions(@RequestBody Map<String,Integer> map){
        List<Question> questions=commonService.myQuestion(map.get("Id"));
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.createArrayNode();
        for(int i=0;i<questions.size();i++) {
            JsonNode data = mapper.createObjectNode();
            ((ObjectNode) data).put("question_id", questions.get(i).getId());
            ((ObjectNode) data).put("title", questions.get(i).getTitle());
            SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd");
            String date = dd.format(questions.get(i).getTime1());
            ((ObjectNode) data).put("date",date);
            String status="open";
            if(questions.get(i).getStates()==1)
                status="closed";
            ((ObjectNode) data).put("status",status);
            ((ObjectNode) data).put("reply_count",questions.get(i).getAnswers());
            ((ArrayNode) root).add(data);
        }
        return ResultCache.getDataOk(root);
    }

    /*
     * 返回用户的回复
     * */
    @RequestMapping(value = "user/answers",method =RequestMethod.POST)
    @ResponseBody
    public Result showAnswers(@RequestBody Map<String,Integer> map){
        List<Answer> answerList = commonService.myAnswers(map.get("user_id"));
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.createArrayNode();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < answerList.size(); i++){
            Answer answer = answerList.get(i);
            Question question = questionMapper.selectByPrimaryKey(answer.getQuestionId());
            if (question == null)
                return ResultCache.getFailureDetail("找不到回复对应的问题！");
            //System.out.print("data "+i+" : "+searchResult.getTitle());
            JsonNode data = mapper.createObjectNode();
            ((ObjectNode) data).put("question_id",question.getId());
            ((ObjectNode) data).put("title",question.getTitle());
            ((ObjectNode) data).put("status",
                    question.getStates()==Question.STATUS_VALUE_OPEN?Question.STATUS_MESSAGE_OPEN:Question.STATUS_MESSAGE_CLOSED);
            ((ObjectNode) data).put("mybest",
                    answer.getState()==Answer.BEST_VALUE_TRUE?Answer.BEST_MESSAGE_TRUE:Answer.BEST_MESSAGE_FALSE);
            ((ObjectNode) data).put("time",df.format(answer.getTime1()));
            ((ArrayNode) root).add(data);
        }
        return ResultCache.getDataOk(root);
    }

    @ResponseBody
    @RequestMapping(value = "user/reply",method =RequestMethod.POST)
    public Result submitReply(@RequestBody Map<String,String> map){
        //拿到请求的id值
        int questionId = 0,replierId = 0;
        String replyContent = map.get("reply");
        try {
            questionId = Integer.parseInt(map.get("question_id"));
            replierId = Integer.parseInt(map.get("replier_id"));
            if (replyContent == null || replyContent.trim().length()==0){
                return ResultCache.getFailureDetail("回复内容为空！");
            }
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
            return ResultCache.getFailureDetail("错误的id格式！");
        }
        //根据请求构造Answer
        Answer answer = new Answer(replyContent,replierId,questionId,Answer.BEST_VALUE_FALSE,new Date());
        Integer reply_id = userService.updateUserReply(questionId, replierId, answer);
        if (reply_id == -1)
            return ResultCache.getFailureDetail("找不到相关实体，后台操作中止！");
        JsonNode jsonNode = new ObjectMapper().createObjectNode();
        ((ObjectNode) jsonNode).put("reply_id",reply_id);
        return ResultCache.getDataOk(jsonNode);
    }

    @ResponseBody
    @RequestMapping(value = "user/best",method =RequestMethod.POST)
    public Result setBestAnswer(@RequestBody Map<String,String> map){
        //拿到请求的id值
        int replyId = 0;
        try {
            replyId = Integer.parseInt(map.get("reply_id"));
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
            return ResultCache.getFailureDetail("错误的id格式！");
        }
        //设置目标回复为最佳答案
        if (!userService.setBest(replyId))
            return ResultCache.getFailureDetail("找不到相关实体，操作中止！");
        return ResultCache.getDataOk(null);
    }

    @RequestMapping(value = "/user/download",method =RequestMethod.POST)
    @ResponseBody
    public Result download(@RequestBody Map<String,String> map){
        Integer id = Integer.parseInt(map.get("Id"));
        Integer resource_id = Integer.parseInt(map.get("resource_id"));
        //下载者的id
        User user = userService.getUserInfo(id);
        //待下载的资源
        Resource res = resourceService.resource(resource_id);

        if(res==null)
            return  ResultCache.getFailureDetail("错误的ID，找不到该资源！");
        if (user == null)
            return ResultCache.getFailureDetail("找不到下载者的id，数据库异常！");

        if(user.getCredit()<res.getPoint()){
            return ResultCache.getPermissionDeniedDetail("积分不足");
        }
        //增加上传者的积分，扣除下载者的积分
        userService.update_credit(user.getId(),-1*res.getPoint());
        userService.update_credit(res.getProviderId(),res.getPoint());
        //增加资源的下载次数
        resourceService.add_downloattimes(resource_id);
        JsonNode jsonNode = new ObjectMapper().createObjectNode();
        ((ObjectNode) jsonNode).put("address",res.getAddress());
        return ResultCache.getDataOk(jsonNode);
    }
}
