package com.qasite.dao;

import com.qasite.bean.Question;
import com.qasite.bean.QuestionExample;
import java.util.List;

import com.qasite.bean.SearchResult;
import org.apache.ibatis.annotations.Param;

/*
 * 改动
 * 继承了SearchMapper接口及其方法：selectByKeywords、selectByKeywordsAndOlds
 * 添加了selectAriserid方法
 * */
public interface QuestionMapper extends SearchMapper{
    long countByExample(QuestionExample example);

    int deleteByExample(QuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    List<Question> selectByExample(QuestionExample example);

    Question selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    List<Question> selectAriserid(Integer user_id);

    List<SearchResult> selectByKeywords(List<String> keys);

    List<SearchResult> selectByKeywordsAndOlds(@Param("keys") List<String> keys, @Param("oldResult") List<SearchResult> oldResult);
}