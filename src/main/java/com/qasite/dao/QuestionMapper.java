package com.qasite.dao;

import com.qasite.bean.Question;
import com.qasite.bean.QuestionExample;
import java.util.List;

import com.qasite.bean.SearchResult;
import org.apache.ibatis.annotations.Param;

public interface QuestionMapper {
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