package com.qasite.bean;

import java.util.Date;

public class Answer {

    public static Integer BEST_VALUE_TRUE = 1;
    public static Integer BEST_VALUE_FALSE = 0;
    public static String BEST_MESSAGE_TRUE = "YES";
    public static String BEST_MESSAGE_FALSE = "NO";

    public Answer(){}
    public Answer(String content,Integer replierId,Integer questionId,Integer state,Date time1){
        this.content = content;
        this.replierId = replierId;
        this.questionId = questionId;
        this.state = state;
        this.time1 = time1;
    }

    private Integer id;

    private String content;

    private Integer replierId;

    private Integer questionId;

    private Integer state;

    private Date time1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getReplierId() {
        return replierId;
    }

    public void setReplierId(Integer replierId) {
        this.replierId = replierId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getState() {
        if (state == null || state == BEST_VALUE_FALSE)
            return BEST_VALUE_FALSE;
        return BEST_VALUE_TRUE;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getTime1() {
        return time1;
    }

    public void setTime1(Date time1) {
        this.time1 = time1;
    }
}