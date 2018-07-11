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

    @RequestMapping(value = "/common/search",method =RequestMethod.POST)
    @ResponseBody
    public Result search(@RequestBody Map<String,String> map){
        return ResultCache.getDataOk(null);
    }


}
