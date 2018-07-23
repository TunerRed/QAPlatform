package com.qasite.sort;

import com.qasite.bean.Question;
import com.qasite.bean.SearchResult;

public class SortQuestionByAnwsers implements SortStrategy{
    @Override
    public int compare(SearchResult o1, SearchResult o2) {
        Question q_origin = (Question)o1;
        Question q_other = (Question)o2;
        if (q_origin.getAnswers()>q_other.getAnswers())
            return -1;
        else if (q_origin.getAnswers()<q_other.getAnswers())
            return 1;
        return 0;
    }
}
