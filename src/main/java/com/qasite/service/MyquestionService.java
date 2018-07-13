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

    public List<String> splitQuestion(String description) {
        List<String> result = sentencedivService.divide(description);
        /*
        System.out.println("splitQuestion :");
        for (int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
        System.out.println("---------------");*/
        return result;
    }

    /*
    * 输入关键词，返回搜索到的相关问题列表
    * */
    public ArrayList<SearchResult> questionSearchResults(List<String> keys) {

        ArrayList<SearchResult> questions = null;
        System.out.println("search result");
        List<SearchResult> selectResult = questionMapper.selectByKeywords(keys);
        System.out.println("get select result");
        if (selectResult != null)
            questions = (ArrayList<SearchResult>) selectResult;

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
    public ArrayList<SearchResult> resourceSearchResults(List<String> keys) {
        return null;
    }
}
