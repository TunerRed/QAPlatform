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

    public void updateUserInfo(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    public boolean checkUserInfo(User user) {
        User emailUser = userMapper.selectByEmail(user.getEmail());
        if (emailUser == null)
            return true;
        if (emailUser.getId()==user.getId())
            return true;
        return false;
    }

    @Autowired
    private UserMapper UserMapper;
    public boolean register(User user) {
        User user1=UserMapper.selectByEmail(user.getEmail());
        //User user2=UserMapper.selectByUsername(user.getUserName());
        if(user1==null/*&&user2==null*/) {
            UserMapper.insert(user);
            return true;
        }
        return false;
    }
}
