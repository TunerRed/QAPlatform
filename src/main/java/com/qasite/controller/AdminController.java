package com.qasite.controller;

import com.qasite.result.Result;
import com.qasite.result.ResultCache;
import com.qasite.service.AdminService;
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
}
