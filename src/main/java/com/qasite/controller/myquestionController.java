package com.qasite.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qasite.bean.Question;
import com.qasite.result.Result;
import com.qasite.result.ResultCache;
import com.qasite.service.MyquestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Map;

@Controller
public class myquestionController {
    @Autowired
    private MyquestionService myquestionService;

    @RequestMapping(value = "user/questions",method =RequestMethod.POST)
    @ResponseBody
    public Result showanswers(@RequestBody Map<String,Integer> map){
        List<Question> questions=myquestionService.myquestion(map.get("Id"));
        System.out.println("success");
        return ResultCache.getDataOk(questions);
    }
}
