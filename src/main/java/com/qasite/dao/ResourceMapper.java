package com.qasite.dao;

import com.qasite.bean.Resource;
import com.qasite.bean.ResourceExample;
import java.util.List;

import com.qasite.bean.SearchResult;
import org.apache.ibatis.annotations.Param;

public interface ResourceMapper {
    long countByExample(ResourceExample example);

    int deleteByExample(ResourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Resource record);

    int insertSelective(Resource record);

    List<Resource> selectByExample(ResourceExample example);

    Resource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Resource record, @Param("example") ResourceExample example);

    int updateByExample(@Param("record") Resource record, @Param("example") ResourceExample example);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    List<SearchResult> selectByKeywords(List<String> keys);

    List<SearchResult> selectByKeywordsAndOlds(@Param("keys") List<String> keys, @Param("oldResult") List<SearchResult> oldResult);
}