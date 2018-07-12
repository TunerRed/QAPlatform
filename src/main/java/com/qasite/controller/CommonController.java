package com.qasite.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.qasite.bean.Question;
import com.qasite.bean.Resource;
import com.qasite.bean.SearchResult;
import com.qasite.bean.User;
import com.qasite.result.Result;
import com.qasite.result.ResultCache;
import com.qasite.service.MyquestionService;
import com.qasite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

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

    /*
    *
    * */
    @Autowired
    MyquestionService questionService;
    @RequestMapping(value = "/common/search",method =RequestMethod.POST)
    @ResponseBody
    public Result search(@RequestBody Map<String,String> map){
        //System.out.println("search : "+map.get("description"));
        String[] keys = questionService.splitQuestion(map.get("description"));
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
        /*
        if (datas == null)
            System.out.println("datas null");
        else
            System.out.println("datas : "+datas.length);
            */
        String s_index = map.get("index"),s_length=map.get("length");
        if (s_index == null || s_index.length() == 0)
            s_index = "1";
        if (s_length == null || s_length.length() == 0)
            s_length = "3";
        int index = Integer.parseInt(s_index);
        int length = Integer.parseInt(s_length);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.createArrayNode();

        for (int i = index-1; i < datas.size() && i < index*length; i++){
            //System.out.print("data "+i+" : "+datas[i].getTitle());
            JsonNode data = mapper.createObjectNode();
            ((ObjectNode) data).put("title",datas.get(i).getTitle());
            ((ObjectNode) data).put("description",datas.get(i).getDescription());
            ((ObjectNode) data).put("id",datas.get(i).getId());
            ((ArrayNode) root).add(data);
        }

        return ResultCache.getDataOk(root);
    }
}
