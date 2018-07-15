package com.qasite.dao;

import com.qasite.bean.Answer;
import com.qasite.bean.AnswerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/*
* 改动
* 添加selectByQuestionId方法
* */
public interface AnswerMapper {
    long countByExample(AnswerExample example);

    int deleteByExample(AnswerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Answer record);

    int insertSelective(Answer record);

    List<Answer> selectByExample(AnswerExample example);

    Answer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Answer record, @Param("example") AnswerExample example);

    int updateByExample(@Param("record") Answer record, @Param("example") AnswerExample example);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);

    //传入问题的id，返回隶属此问题的所有回复的列表
    List<Answer> selectByQuestionId(@Param("questionId") int questionId);
}