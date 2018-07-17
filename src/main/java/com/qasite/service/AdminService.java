package com.qasite.service;

import com.qasite.bean.Answer;
import com.qasite.bean.AnswerExample;
import com.qasite.bean.Question;
import com.qasite.dao.AnswerMapper;
import com.qasite.dao.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private AnswerMapper answerMapper;

    public Integer closeQuestion(Integer questionId) {
        //找到问题实体
        Question question = questionMapper.selectByPrimaryKey(questionId);
        if (question == null || question.getStates()==Question.STATUS_VALUE_CLOSED)
            return -1;
        //关闭问题
        question.setStates(Question.STATUS_VALUE_CLOSED);
        questionMapper.updateByPrimaryKeySelective(question);
        //找到问题的最早回复
        AnswerExample answerExample = new AnswerExample();
        answerExample.createCriteria().andQuestionIdEqualTo(questionId);
        answerExample.setOrderByClause("id asc");
        List<Answer> answers = answerMapper.selectByExample(answerExample);
        if (answers == null || answers.size() == 0)
            return 0;
        //返回最早回复的id准备将其设为最佳回复
        return answers.get(0).getId();
    }

    //管理员删除问题
    public void deleteQuestion(int question_id) {
        //删除问题本身
        questionMapper.deleteByPrimaryKey(question_id);
        //删除问题的回复
        AnswerExample example=new AnswerExample();
        example.createCriteria().andQuestionIdEqualTo(question_id);
        answerMapper.deleteByExample(example);
    }
}
