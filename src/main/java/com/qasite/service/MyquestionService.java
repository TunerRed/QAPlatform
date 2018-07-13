package com.qasite.service;

import com.qasite.bean.Question;
import com.qasite.bean.Resource;
import com.qasite.bean.SearchResult;
import com.qasite.dao.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyquestionService {
    @Autowired
    private QuestionMapper questionMapper;
    public List<Question> myquestion(int user_id) {
        return questionMapper.selectAriserid(user_id);
    }

    public String[] splitQuestion(String description) {
        String[] result = new String[2];
        result[0] = "为什么";
        result[1] = "为什么";
        return result;
    }

    /*
    * 输入关键词，返回搜索到的相关问题列表
    * */
    public ArrayList<SearchResult> questionSearchResults(String[] keys) {

        ArrayList<SearchResult> questions = null;
        /*for (int i = 0; i < keys.length; i++)
            System.out.println(keys[i]);*/
        questions = (ArrayList<SearchResult>) questionMapper.selectByKeywords(keys);

        /*questions = new ArrayList<SearchResult>();
        for (int i = 0; questions.size() < 5; i++){
            Question question = questionMapper.selectByPrimaryKey(21+i);
            if (question != null)
                questions.add(question);
        }*/
        return questions;
    }

    /*
     * 输入关键词，返回搜索到的相关资源列表
     * */
    public ArrayList<SearchResult> resourceSearchResults(String[] keys) {
        return null;
    }
}
