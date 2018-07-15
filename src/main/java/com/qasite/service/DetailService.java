package com.qasite.service;

import com.qasite.bean.Resource;
import com.qasite.bean.User;
import com.qasite.dao.ResourceMapper;
import com.qasite.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailService {
    @Autowired
    private com.qasite.dao.ResourceMapper ResourceMapper;
    @Autowired
    private com.qasite.dao.UserMapper UserMapper;
    public Resource resourceDetail(int reid) {
        return ResourceMapper.selectByPrimaryKey(reid);
    }
    public int userIdentify(int userid) {
        User user = UserMapper.selectByPrimaryKey(userid);
        if (user.getRank() == null)
            return User.PERMISSION_NO_ADMIN;
        return user.getRank();
    }
}
