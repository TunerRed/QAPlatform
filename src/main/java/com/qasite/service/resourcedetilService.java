package com.qasite.service;

import com.qasite.bean.Resource;
import com.qasite.bean.User;
import com.qasite.dao.ResourceMapper;
import com.qasite.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class resourcedetilService {
 @Autowired
 private ResourceMapper ResourceMapper;
 @Autowired
 private UserMapper UserMapper;
 public Resource resourcedetil(int reid) {
     return ResourceMapper.selectByPrimaryKey(reid);
 }
    public int useridentify(int userid) {
        User now = UserMapper.selectByPrimaryKey(userid);
        if (now.getRank() == null)
            return User.PERMISSION_NO_ADMIN;
        return now.getRank();
    }
    public String userName(int userid) {
        User user = UserMapper.selectByPrimaryKey(userid);
        if (user==null)
            return null;
        return user.getUserName();
    }
}
