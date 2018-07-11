package com.qasite.service;

import com.qasite.bean.User;
import com.qasite.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User login(String email, String password) {
        User user = userMapper.selectByEmail(email);
        if (user == null)
            return null;
        if (user.getPassword() == null || !password.equals(user.getPassword()))
            return null;
        return user;
    }

    public User getUserInfo(Integer id){
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
