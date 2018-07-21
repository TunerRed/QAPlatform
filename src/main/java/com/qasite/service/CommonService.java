package com.qasite.service;

import com.mysql.jdbc.log.StandardLogger;
import com.qasite.bean.Answer;
import com.qasite.bean.Question;
import com.qasite.bean.SearchResult;
import com.qasite.dao.AnswerMapper;
import com.qasite.dao.QuestionMapper;
import com.qasite.dao.ResourceMapper;
import com.qasite.dao.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


@Service
public class CommonService {
    public static Integer SEARCH_TYPE_QUESTION = 0;
    public static Integer SEARCH_TYPE_RESOURCE = 1;

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private ResourceMapper resourceMapper;

    /*
    * 个人页面
    * 我的问题列表
    * */
    public List<Question> myQuestion(int user_id) {
        return questionMapper.selectAriserid(user_id);
    }

    /*
     * 个人页面
     * 我的回复列表
     * */
    public List<Answer> myAnswers(Integer userid) {
        return answerMapper.selectByUserId(userid);
    }

    /*
    * 获取某个问题下的所有回复
    * */
    public List<Answer> getAnswersByQuestionId(int questionId){
        return answerMapper.selectByQuestionId(questionId);
    }

    /*
     * 划分句子为数组
     * Param description 传入的句子描述
     * Param searchStandard 检查分词的词性是否在该句子中，字符串中列出的词性用逗号隔开，只能由Controller获取
     * return result 将字符串中进行分词并返回有意义的词条列表
     * （即可在搜索中起到参照作用的词汇）
     * */
    public List<String> splitSentence(String description,String searchStardard) {
        List<String> divide = SentenceDiv.getInstance().divide(description);
        List<String> property = SentenceDiv.getInstance().properties(description);
        List<String> result = new LinkedList<String>();
        List<Integer> result_property_priority = new LinkedList<Integer>();

        int property_priority = -1;
        //System.out.println("------- split start -------");
        for (int i = 0; i < divide.size(); i++){
            //System.out.println("split result " +i+ " : " +divide.get(i) +"\t\tproperty : " +property.get(i));
            /*
            排序插入，根据searchStandard中设定的优先级
            词性越靠前的词将被放在更前面
            相同词性在句子中越靠后将被放在更前面
            */
            //若是名次，不论长度直接放在开始
            if (property.get(i).trim().equalsIgnoreCase("n")){
                //System.out.println("\nsplitSentence case 1 : n");
                result.add(0,divide.get(i));
                result_property_priority.add(0,0);
            }
            //若长度大于1
            else if (divide.get(i).trim().length()>1 ){
                //若为目标词性，则根据优先级插入结果集中
                if ((property_priority = searchStardard.indexOf(property.get(i))) >= 0){
                    //System.out.println("\nsplitSentence case 2 : length&property");
                    //System.out.println("property_index(must greater than 0) : "+property_priority/2);
                    property_priority /= 2;//排除逗号
                    int cur_index = 0;
                    for(Iterator iter = result_property_priority.iterator(); iter.hasNext();){
                        Integer cur_priority = (Integer) iter.next();
                        if (cur_priority >= property_priority){
                            result.add(cur_index,divide.get(i));
                            result_property_priority.add(cur_index,property_priority);
                            break;
                        }
                        cur_index++;
                    }
                    if (cur_index == result_property_priority.size()){
                        result.add(divide.get(i));
                        result_property_priority.add(property_priority);
                    }
                }
                //对英文单词进行处理
                else if (property.get(i).trim().length() == 0){
                    //System.out.println("\nsplitSentence case 3 : english words");
                    result.add(0,divide.get(i));
                    result_property_priority.add(0,property_priority);
                }
            }

        }
        //System.out.print("\nsplit result :");
        /*for (int i = 0; i < result.size(); i++)
            System.out.print(" "+result.get(i));
        System.out.println("\n\n--------- split end -------------");*/
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
        int default_noun_keys = 2;
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
        List<String> subKeys = keys;
        for (int i = 0; i < key_count-1; i++){
            subKeys = subKeys.subList(0,key_count-i-1);
            List<SearchResult> tempResult = searchMapper.selectByKeywordsAndOlds(subKeys,selectResult);
            selectResult.addAll(tempResult);
        }
        for (int i = 0; i < default_noun_keys && i < key_count; i++){
            subKeys = keys.subList(i,i+1);
            List<SearchResult> tempResult = searchMapper.selectByKeywordsAndOlds(subKeys,selectResult);
            selectResult.addAll(tempResult);
        }
        return selectResult == null ? null:(ArrayList<SearchResult>)selectResult;
    }

}
