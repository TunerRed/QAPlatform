package com.qasite.controller;

import com.qasite.result.Result;
import com.qasite.result.ResultCache;
import com.qasite.service.AdminService;
import com.qasite.service.MuteService;
import com.qasite.service.ResourceService;
import com.qasite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private ResourceService resourceService;

    /*
    * 关闭问题
    * */
    @RequestMapping(value = "admin/question/close",method =RequestMethod.POST)
    @ResponseBody
    public Result closeQuestion(@RequestBody Map<String,Integer> map){
        Integer questionId = map.get("question_id");
        if (questionId == null || questionId <= 0)
            return ResultCache.getFailureDetail("错误的请求格式！");
        //关闭问题并获得该问题的某个回复
        /*
        若有回复，则将其设为最佳答案
        否则返回0
        若找不到实体则返回-1，即操作中存在不合理数据
         */
        int reply_id = adminService.closeQuestion(questionId);
        if (reply_id > 0){
            userService.setBest(reply_id);
        }else if (reply_id < 0){
            return ResultCache.getFailureDetail("操作失败，找不到对应的实体！");
        }
        return ResultCache.getDataOk(null);
    }


    @Autowired
    private MuteService amute;
    @RequestMapping(value = "/admin/mute",method =RequestMethod.POST)
    @ResponseBody
    public Result muteSomeone(@RequestBody Map<String,Integer> map){
        if (!(map.containsKey("Id")))
            return ResultCache.getFailureDetail("错误的信息格式");
        boolean is = amute.isexist(map.get("Id"));
        int a = userService.checkRight(map.get("Id"));
        if (is){
            if(a==0){
                amute.mute(map.get("Id"),5);
                amute.minusPoint(map.get("Id"),5);
                return ResultCache.getDataOk(null);
            }
            else
                return ResultCache.getFailureDetail("该用户已被禁言");
        }
        else
            return ResultCache.getFailureDetail("该用户id不存在");
    }

    @RequestMapping(value = "/admin/question/delete",method =RequestMethod.POST)
    @ResponseBody
    public Result deleteQuestion(@RequestBody Map<String,String> map){
        Integer question_id=Integer.parseInt(map.get("question_id"));
        if (question_id==null || question_id <= 0)
            return ResultCache.getFailureDetail("找不到id对应的问题！");
        adminService.deleteQuestion(question_id);
        return ResultCache.getDataOk(null);
    }

    /**
     ***删除我的资源
     **/
    @RequestMapping(value = "/admin/resource",method =RequestMethod.POST)//value?
    @ResponseBody
    public Result deleteResource(@RequestBody Map<String,String> map){
        int resource_id=Integer.parseInt(map.get("resource_id"));
        resourceService.deleteResource(resource_id);
        //System.out.println("删除………………");
        return ResultCache.getDataOk(null);
    }
}
