package com.qasite.service;
import com.qasite.bean.User;
import com.qasite.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class registerService {

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
