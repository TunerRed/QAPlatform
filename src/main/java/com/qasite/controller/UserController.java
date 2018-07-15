package com.qasite.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.qasite.bean.Answer;
import com.qasite.bean.Question;
import com.qasite.bean.SearchResult;
import com.qasite.bean.User;
import com.qasite.dao.QuestionMapper;
import com.qasite.result.Result;
import com.qasite.result.ResultCache;
import com.qasite.service.CommonService;
import com.qasite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
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
        return ResultCache.getDataOk(questions);
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
}
