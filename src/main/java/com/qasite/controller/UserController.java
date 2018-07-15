package com.qasite.controller;

import com.qasite.bean.Question;
import com.qasite.bean.User;
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

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CommonService commonService;

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
        List<Question> questions=commonService.myquestion(map.get("Id"));
        return ResultCache.getDataOk(questions);
    }
}
