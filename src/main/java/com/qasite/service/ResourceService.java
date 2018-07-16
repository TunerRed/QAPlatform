package com.qasite.service;

import com.qasite.bean.Resource;
import com.qasite.dao.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {
    @Autowired
    public ResourceMapper resourceMapper;
    public Resource resource(Integer id)
    {
        Resource res = resourceMapper.selectByPrimaryKey(id);
        return res;
    }

    public Resource add_downloattimes(int id)
    {
        Resource res =resourceMapper.selectByPrimaryKey(id);
        res.setDownloadTimes(res.getDownloadTimes()+1);
        resourceMapper.updateByPrimaryKey(res);
        return null;
    }
}
