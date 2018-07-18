package com.qasite.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.qasite.bean.*;
import com.qasite.result.Result;
import com.qasite.result.ResultCache;
import com.qasite.service.CommonService;
import com.qasite.service.DetailService;
import com.qasite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class CommonController {

    @Autowired
    private UserService userService;
    @Autowired
    private CommonService commonService;
    @Autowired
    private DetailService detilService;

    @RequestMapping(value = "/common/login",method =RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody Map<String,String> map){
        if (!(map.containsKey("email")&&map.containsKey("password")))
            return ResultCache.getFailureDetail("错误的信息格式");
        User user = userService.login(map.get("email"),map.get("password"));
        if(user != null){
            return ResultCache.getDataOk(user);
        }
        return ResultCache.getFailureDetail("用户名或密码错误");
    }

    //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
    //df.format(Math.random()*3<2?new Date():new Date());

    @RequestMapping(value = "/common/register",method =RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestBody User user){
        if (user == null)
            return ResultCache.getFailureDetail("错误的信息格式");
        user.setRegTime(new Date());
        user.setCredit(20);
        if(userService.register(user)){
            return ResultCache.getDataOk(null);
        }
        return ResultCache.getFailureDetail("邮箱或用户名重复");

    }

    /*
    * 在Controller中@Value则可以获取resource下的property文件中的内容
    * 需要再Spring配置文件中添加property-placeholder约束
    * */
    @Value("${searchStardard}")
    String searchStardard;
    @RequestMapping(value = "/common/search",method =RequestMethod.POST)
    @ResponseBody
    public Result search(@RequestBody Map<String,String> map){
        //System.out.println("search : "+map.get("description"));
        List<String> keys = commonService.splitSentence(map.get("description"),searchStardard);
        String s_index = map.get("index"),s_length=map.get("length");
        if (s_index == null || s_index.length() == 0)
            s_index = "1";
        if (s_length == null || s_length.length() == 0)
            s_length = "3";
        int index = 1,length = 3;
        try{
            index = Integer.parseInt(s_index);
            length = Integer.parseInt(s_length);
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
            return ResultCache.getFailureDetail("错误的页码格式");
        }
        ArrayList<SearchResult> datas = null;
        Integer searchType = -1;
        if (map.get("type").equalsIgnoreCase("question")){
            searchType = CommonService.SEARCH_TYPE_QUESTION;
        }else if (map.get("type").equalsIgnoreCase("resource")){
            searchType = CommonService.SEARCH_TYPE_RESOURCE;
        }else {
            return ResultCache.getFailureDetail("错误的请求类型！");
        }
        datas = commonService.getSearchResults(keys,searchType);
        if (datas == null || datas.size() == 0)
            return ResultCache.getFailureDetail("找不到相关问题或资源！");


        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.createArrayNode();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = index-1; i < datas.size() && i < index*length; i++){
            SearchResult searchResult = datas.get(i);
            //System.out.print("data "+i+" : "+searchResult.getTitle());
            JsonNode data = mapper.createObjectNode();
            ((ObjectNode) data).put("title",searchResult.getTitle());
            ((ObjectNode) data).put("description",searchResult.getDescription());
            ((ObjectNode) data).put("id",searchResult.getId());
            ((ObjectNode) data).put("time",df.format(searchResult.getDate()));
            ((ArrayNode) root).add(data);
        }
        return ResultCache.getDataOk(root);
    }


    @RequestMapping(value = "common/search/res",method =RequestMethod.POST)
    @ResponseBody
    public Result resourceDetail(@RequestBody Map<String,Integer> map){
        Resource resource = detilService.resourceDetail(map.get("resource_id"));
        if (resource == null)
            return ResultCache.getFailureDetail("找不到ID对应的资源！");
        //这里要找的是资源上传者的ID而不是资源的ID，不应使用getID()方法
        User uploader = userService.getUserInfo(resource.getProviderId());
        if (uploader == null)
            return ResultCache.getFailureDetail("找不到资源的上传者！");
        /*
        * viewer返回英文信息，避免编码方式带来的异常
        * 经过后台协商，0代表普通登录用户，1代表管理员身份
        * 经过与前台的协商，当访问者为游客时，发送数字0（由于数据库设置的自动增长机制，ID值至少为1，因此不存在重复）
        * */
        String viewer=getUserRank(map.get("user_id"));
        ObjectMapper mapper = new ObjectMapper();
        JsonNode data = mapper.createObjectNode();
        ((ObjectNode) data).put("resource",resource.getTitle());
        ((ObjectNode) data).put("description",resource.getDescription());
        ((ObjectNode) data).put("format",resource.getFormat());
        //资源上传者的name而不是查看该网页用户的userName
        ((ObjectNode) data).put("uploader",uploader.getUserName());
        ((ObjectNode) data).put("uploader_id",uploader.getId());
        ((ObjectNode) data).put("shutup",
                uploader.getStates().compareTo(new Date())>0?User.SHUT_UP_MESSAGE_TRUE:User.SHUT_UP_MESSAGE_FALSE);
        ((ObjectNode) data).put("point",resource.getPoint());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        ((ObjectNode) data).put("address",resource.getAddress());
        ((ObjectNode) data).put("time",df.format(resource.getDate()));
        ((ObjectNode) data).put("download_times",resource.getDownloadTimes());
        ((ObjectNode) data).put("viewer",viewer);
        return ResultCache.getDataOk(data);
    }


    @RequestMapping(value = "common/search/que",method =RequestMethod.POST)
    @ResponseBody
    public Result questionDetil(@RequestBody Map<String,Integer> map){
        Question question = detilService.questionDetail(map.get("question_id"));
        if (question == null)
            return ResultCache.getFailureDetail("找不到ID对应的问题！");
        //这里要找的是资源上传者的ID而不是资源的ID，不应使用getID()方法
        User uploader = userService.getUserInfo(question.getAriserId());
        if (uploader == null)
            return ResultCache.getFailureDetail("找不到问题的发布者！");
        /*
         * viewer返回英文信息，避免编码方式带来的异常
         * 经过后台协商，0代表普通登录用户，1代表管理员身份
         * 经过与前台的协商，当访问者为游客时，发送数字0（由于数据库设置的自动增长机制，ID值至少为1，因此不存在重复）
         * */
        String viewer=getUserRank(map.get("user_id"));
        if (viewer == null)
            return ResultCache.getFailureDetail("后台程序处理不当,获取用户身份失败");
        //开始构建data
        ObjectMapper mapper = new ObjectMapper();
        JsonNode data = mapper.createObjectNode();
        JsonNode replies = mapper.createArrayNode();
        ((ObjectNode) data).put("question",question.getTitle());
        ((ObjectNode) data).put("description",question.getDescription());
        //问题发布者的name而不是查看该网页用户的userName
        ((ObjectNode) data).put("ariser",uploader.getUserName());
        ((ObjectNode) data).put("ariser_id",uploader.getId());
        ((ObjectNode) data).put("credit",question.getPoints());
        //是否在禁言状态
        ((ObjectNode) data).put("shutup",
                (uploader.getStates().compareTo(new Date())>0)?User.SHUT_UP_MESSAGE_TRUE:User.SHUT_UP_MESSAGE_FALSE);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        ((ObjectNode) data).put("time",df.format(question.getDate()));
        String status = Question.STATUS_MESSAGE_CLOSED;
        if (question.getStates() == Question.STATUS_VALUE_OPEN)
            status = Question.STATUS_MESSAGE_OPEN;
        ((ObjectNode) data).put("status",status);
        ((ObjectNode) data).put("viewer",viewer);
        /*
        * 构建replies数组
        * */
        List<Answer> replyList = commonService.getAnswersByQuestionId(question.getId());
        for (int i = 0; i < replyList.size(); i++){
            Answer searchAnswer = replyList.get(i);
            User replier = userService.getUserInfo(searchAnswer.getReplierId());
            if (replier == null)
                ResultCache.getFailureDetail("null replier for an anwser!check your database");
            //System.out.print("answer "+i+" : "+searchAnswer.getTitle());
            JsonNode replyData = mapper.createObjectNode();
            ((ObjectNode) replyData).put("reply_id",searchAnswer.getId());
            ((ObjectNode) replyData).put("replier_id",searchAnswer.getReplierId());
            ((ObjectNode) replyData).put("replier",userService.getUserInfo(searchAnswer.getReplierId()).getUserName());
            ((ObjectNode) replyData).put("content",searchAnswer.getContent());
            //若是最佳回复，则返回BEST_MESSAGE_TRUE，当前版本返回“YES”，否则返回“NO”
            ((ObjectNode) replyData).put("best",
                    searchAnswer.getState()==Answer.BEST_VALUE_TRUE?Answer.BEST_MESSAGE_TRUE:Answer.BEST_MESSAGE_FALSE);
            ((ObjectNode) replyData).put("time",df.format(searchAnswer.getTime1()));
            ((ObjectNode) data).put("shutup",
                    (replier.getStates().compareTo(new Date())>0)?User.SHUT_UP_MESSAGE_TRUE:User.SHUT_UP_MESSAGE_FALSE);
            ((ArrayNode) replies).add(replyData);
        }
        ((ObjectNode) data).put("replies",replies);
        return ResultCache.getDataOk(data);
    }

    private String getUserRank(int  userid){
        if (userid > 0){
            int  useridentify = detilService.userIdentify(userid);
            if (useridentify==User.PERMISSION_VALUE_NO_ADMIN)
                return User.ROLE_USER;
            else if (useridentify==User.PERMISSION_VALUE_ADMIN)
                return User.ROLE_ADMIN;
            else
                return null;
        }else
            return User.ROLE_NULL;
    }

}
