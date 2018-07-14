package com.qasite.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.qasite.bean.*;
import com.qasite.result.Result;
import com.qasite.result.ResultCache;
import com.qasite.service.MyquestionService;
import com.qasite.service.UserService;
import com.qasite.service.resourcedetilService;
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

    @Autowired
    private com.qasite.service.registerService registerService;

    //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
    //df.format(Math.random()*3<2?new Date():new Date());

    @RequestMapping(value = "/common/register",method =RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestBody User user){
        if (user == null)
            return ResultCache.getFailureDetail("错误的信息格式");
        user.setRegTime(new Date());
        user.setCredit(20);
        if(registerService.register(user)){
            //System.out.println("success");
            return ResultCache.getDataOk(null);
        }
        return ResultCache.getFailureDetail("邮箱或用户名重复");

    }

    @Value("${searchStardard}")
    String searchStardard;
    @Autowired
    MyquestionService questionService;
    @RequestMapping(value = "/common/search",method =RequestMethod.POST)
    @ResponseBody
    public Result search(@RequestBody Map<String,String> map){
        System.out.println("search : "+map.get("description"));
        List<String> keys = questionService.splitQuestion(map.get("description"),searchStardard);
        ArrayList<SearchResult> datas = null;
        if (map.get("type").equalsIgnoreCase("question")){
            datas = questionService.questionSearchResults(keys);
        }else if (map.get("type").equalsIgnoreCase("resource")){
            datas = questionService.resourceSearchResults(keys);
        }else {
            return ResultCache.getFailureDetail("错误的请求类型！");
        }
        if (datas == null || datas.size() == 0)
            return ResultCache.getFailureDetail("找不到相关问题或资源！");

        String s_index = map.get("index"),s_length=map.get("length");
        if (s_index == null || s_index.length() == 0)
            s_index = "1";
        if (s_length == null || s_length.length() == 0)
            s_length = "3";
        int index = Integer.parseInt(s_index);
        int length = Integer.parseInt(s_length);
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

    @Autowired
    private resourcedetilService resourcedetilService;

    @RequestMapping(value = "common/search/res",method =RequestMethod.POST)
    @ResponseBody
    public Result resourcedetil(@RequestBody Map<String,Integer> map){
        Resource resource = resourcedetilService.resourcedetil(map.get("resource_id"));
        if (resource == null)
            return ResultCache.getFailureDetail("找不到ID对应的资源！");
        //这里要找的是资源上传者的ID而不是资源的ID，不应使用getID()方法
        String userNameOfResource=resourcedetilService.userName(resource.getProviderId());
        /*
        * viewer返回英文信息，避免编码方式带来的异常
        * 经过后台协商，0代表普通登录用户，1代表管理员身份
        * 经过与前台的协商，当访问者为游客时，发送数字0（由于数据库设置的自动增长机制，ID值至少为1，因此不存在重复）
        * */
        String viewer="visitor";
        if (map.get("user_id") > 0){
            int  useridentify = resourcedetilService.useridentify(map.get("user_id"));
            if (useridentify==User.PERMISSION_NO_ADMIN)
                viewer="user";
            else if (useridentify==User.PERMISSION_ADMIN)
                viewer="admin";
            else
                return ResultCache.getFailureDetail("后台程序处理不当");
        }
        ObjectMapper mapper = new ObjectMapper();
        JsonNode data = mapper.createObjectNode();
        ((ObjectNode) data).put("resource",resource.getTitle());
        ((ObjectNode) data).put("description",resource.getDescription());
        ((ObjectNode) data).put("format",resource.getFormat());
        //资源上传者的name而不是查看该网页用户的userName
        ((ObjectNode) data).put("uploader",userNameOfResource);
        ((ObjectNode) data).put("type",resource.getType());
        ((ObjectNode) data).put("point",resource.getPoint());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        ((ObjectNode) data).put("time",df.format(resource.getDate()));
        ((ObjectNode) data).put("download_times",resource.getDownloadTimes());
        ((ObjectNode) data).put("viewer",viewer);
        return ResultCache.getDataOk(data);
    }

}
