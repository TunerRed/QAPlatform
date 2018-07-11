package com.qasite.controller;

import com.qasite.bean.User;
import com.qasite.result.Result;
import com.qasite.result.ResultCache;
import com.qasite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/info",method =RequestMethod.POST)
    @ResponseBody
    public Result userInfo(@RequestBody Map<String,String> map){
        Integer id = Integer.parseInt(map.get("Id"));
        User user = userService.getUserInfo(id);
        if (user==null)
            return  ResultCache.getFailureDetail("错误的ID，找不到该用户！");
        return ResultCache.getDataOk(user);
    }
}
