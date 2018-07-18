package com.qasite.service;

import com.qasite.bean.Resource;
import com.qasite.bean.ResourceExample;
import com.qasite.dao.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void uploadResource(Resource resource){
        if (resource != null)
            resourceMapper.insert(resource);
    }

    /**
     ***获取该用户的资源列表
     **/
    public List<Resource> myResource(int Id){
        ResourceExample example = new ResourceExample();
        example.createCriteria().andIdEqualTo(Id);
        return resourceMapper.selectByExample(example);
    }
    /***
     /***删除相应的资源
     ***/
    public void deleteResource(int resource_id) {
        resourceMapper.deleteByPrimaryKey(resource_id);
        ResourceExample example=new ResourceExample();
        example.createCriteria().andIdEqualTo(resource_id);
        resourceMapper.deleteByExample(example);
    }
}
