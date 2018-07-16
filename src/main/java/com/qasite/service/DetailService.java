package com.qasite.service;

import com.qasite.bean.Question;
import com.qasite.bean.Resource;
import com.qasite.bean.User;
import com.qasite.dao.AnswerMapper;
import com.qasite.dao.QuestionMapper;
import com.qasite.dao.ResourceMapper;
import com.qasite.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailService {
    @Autowired
    private ResourceMapper ResourceMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    public Resource resourceDetail(int reid) {
        return ResourceMapper.selectByPrimaryKey(reid);
    }

    public Question questionDetail(int queId){
        return questionMapper.selectByPrimaryKey(queId);
    }

    public int userIdentify(int userid) {
        User user = userMapper.selectByPrimaryKey(userid);
        if (user.getRank() == null)
            return User.PERMISSION_VALUE_NO_ADMIN;
        return user.getRank();
    }
}
