package com.qasite.service;

import com.qasite.bean.Question;
import com.qasite.bean.SearchResult;
import com.qasite.dao.QuestionMapper;
import com.qasite.dao.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MyquestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private ResourceMapper resourceMapper;
    public List<Question> myquestion(int user_id) {
        return questionMapper.selectAriserid(user_id);
    }

    public List<String> splitQuestion(String description,String searchStardard) {
        List<String> divide = sentencedivService.divide(description);
        List<String> property = sentencedivService.properties(description);
        List<String> result = new ArrayList<String>();
        //System.out.println("----splitQuestion----");
        for (int i = 0; i < divide.size(); i++){
            if (divide.get(i).trim().equalsIgnoreCase("N")){
                result.add(divide.get(i));
            } else if (divide.get(i).trim().length()>1 && searchStardard.contains(property.get(i))){
                //System.out.println("split : "+divide.get(i) +"\t\tproperty : " +property.get(i));
                result.add(divide.get(i));
            }
        }
        //System.out.println("----------------------");
        return result;
    }

    /*
    * 输入关键词，返回搜索到的相关问题列表
    * */
    public ArrayList<SearchResult> questionSearchResults(List<String> keys) {
        ArrayList<SearchResult> questions = null;
        //System.out.println("SQL search start");
        int key_count = keys.size();
        List<SearchResult> selectResult = questionMapper.selectByKeywords(keys);
        /*System.out.print("key_count : "+keys.size()+"; keys : ");
        for (int i = 0; i < keys.size(); i++)
            System.out.print(keys.get(i)+" ");
        for (int j = 0; j < selectResult.size(); j++)
            System.out.print(selectResult.get(j).getId()+" ");
        System.out.println();*/
        for (int i = 0; i < key_count-1; i++){
            keys = keys.subList(0,key_count-i-1);
            List<SearchResult> tempResult = questionMapper.selectByKeywordsAndOlds(keys,selectResult);
            selectResult.addAll(tempResult);
        }
        //System.out.println("SQL search finished");
        if (selectResult != null)
            questions = (ArrayList<SearchResult>) selectResult;
        return questions;
    }

    /*
     * 输入关键词，返回搜索到的相关资源列表
     * */
    public ArrayList<SearchResult> resourceSearchResults(List<String> keys) {
        ArrayList<SearchResult> resource = null;
        //System.out.println("SQL search start");
        int key_count = keys.size();
        List<SearchResult> selectResult = resourceMapper.selectByKeywords(keys);
        for (int i = 0; i < key_count-1; i++){
            keys = keys.subList(0,key_count-i-1);
            List<SearchResult> tempResult = resourceMapper.selectByKeywordsAndOlds(keys,selectResult);
            selectResult.addAll(tempResult);
        }
        //System.out.println("SQL search finished");
        if (selectResult != null)
            resource = (ArrayList<SearchResult>) selectResult;
        return null;
    }
}
