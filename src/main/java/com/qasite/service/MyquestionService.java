package com.qasite.service;

import com.qasite.bean.Question;
import com.qasite.dao.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyquestionService {
    @Autowired
    private QuestionMapper QuestionMapper;
    public List<Question> myquestion(int user_id) {
        return QuestionMapper.selectAriserid(user_id);
    }

}
