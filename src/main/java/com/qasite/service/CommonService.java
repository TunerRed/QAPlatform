package com.qasite.service;

import com.mysql.jdbc.log.StandardLogger;
import com.qasite.bean.Question;
import com.qasite.bean.SearchResult;
import com.qasite.dao.QuestionMapper;
import com.qasite.dao.ResourceMapper;
import com.qasite.dao.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CommonService {
    public static Integer SEARCH_TYPE_QUESTION = 0;
    public static Integer SEARCH_TYPE_RESOURCE = 1;

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private ResourceMapper resourceMapper;
    public List<Question> myquestion(int user_id) {
        return questionMapper.selectAriserid(user_id);
    }

    /*
     * 划分句子为数组
     * Param description 传入的句子描述
     * Param searchStandard 检查分词的词性是否在该句子中，字符串中列出的词性用逗号隔开，只能由Controller获取
     * return result 将字符串中进行分词并返回有意义的词条列表
     * （即可在搜索中起到参照作用的词汇）
     * */
    public List<String> splitSentence(String description,String searchStardard) {
        List<String> divide = SentenceDivService.divide(description);
        List<String> property = SentenceDivService.properties(description);
        List<String> result = new ArrayList<String>();

        //System.out.println("----splitQuestion----");
        for (int i = 0; i < divide.size(); i++){
            //System.out.println("split : "+divide.get(i) +"\t\tproperty : " +property.get(i));
            /*if (property.get(i) == null || property.get(i).trim().length() == 0){
                System.out.println("empty property");
                continue;
            }*/
            if (divide.get(i).trim().equalsIgnoreCase("N") ||
                    (divide.get(i).trim().length()>1 && searchStardard.contains(property.get(i)))){
                result.add(divide.get(i));
            }
        }
        //System.out.println("----------------------");
        return result;
    }

    /*
     * 输入关键词，返回搜索到的相关问题/资源列表
     * */
    public ArrayList<SearchResult> getSearchResults(List<String> keys, Integer searchType) {
        /*
         * 根据传入的searchType判断搜索的类型
         * */
        SearchMapper searchMapper = null;
        if (searchType == SEARCH_TYPE_QUESTION)
            searchMapper = questionMapper;
        else if (searchType == SEARCH_TYPE_RESOURCE)
            searchMapper = resourceMapper;

        int key_count = keys.size();
        if (key_count == 0)
            return null;
        List<SearchResult> selectResult = searchMapper.selectByKeywords(keys);
        /*System.out.print("key_count : "+keys.size()+"; keys : ");
        for (int j = 0; j < keys.size(); j++)
            System.out.print(keys.get(j)+" ");
        //如果selectResult为空的话，运行不会出错
        //但是调试时由于调用了selectResult的方法，可能会返回空指针异常
        /*for (int j = 0; j < selectResult.size(); j++)
            System.out.print(selectResult.get(j).getId()+" ");
        System.out.println();*/
        for (int i = 0; i < key_count-1; i++){
            keys = keys.subList(0,key_count-i-1);
            List<SearchResult> tempResult = searchMapper.selectByKeywordsAndOlds(keys,selectResult);
            selectResult.addAll(tempResult);
        }

        return selectResult == null ? null:(ArrayList<SearchResult>)selectResult;
    }
}
