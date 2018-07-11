package com.qasite.controller;

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
public class CommonController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/common/login",method =RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody Map<String,String> map){
        System.out.println(map.get("email")+"\t"+map.get("password"));
        if(userService.login(map.get("email"),map.get("password"))){
            return ResultCache.getDataOk(null);
        }
        return ResultCache.getFailureDetail("用户名或密码错误");
    }
}
