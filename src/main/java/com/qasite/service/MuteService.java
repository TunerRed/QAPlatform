package com.qasite.service;

import com.qasite.bean.User;
import com.qasite.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.Date;

@Service
public class MuteService {
    @Autowired
    private UserMapper userMapper;
    public boolean isexist(Integer Id){
        User a = userMapper.selectByPrimaryKey(Id);
        if (a==null)
            return false;
        else
            return true;
    }
    public void mute(Integer Id,Integer punish_time){
        Calendar now =Calendar.getInstance();
        now.setTime(new Date());
        User user = userMapper.selectByPrimaryKey(Id);
        now.set(Calendar.DATE,now.get(Calendar.DATE)+punish_time);
        user.setStates(now.getTime());
        userMapper.updateByPrimaryKey(user);
    }

    public void minusPoint(Integer Id,Integer punish_point){
        User user = userMapper.selectByPrimaryKey(Id);
        if (user.getCredit() == null || user.getCredit() < punish_point)
            user.setCredit(0);
        else
            user.setCredit(user.getCredit() - punish_point);
        userMapper.updateByPrimaryKey(user);
    }
}
