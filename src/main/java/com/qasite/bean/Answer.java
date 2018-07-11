package com.qasite.bean;

public class Answer {

    public Answer(){}
    public Answer(String content,Integer replierId,Integer questionId,Integer state){
        this.content = content;
        this.replierId = replierId;
        this.questionId = questionId;
        this.state = state;
    }

    private Integer id;

    private String content;

    private Integer replierId;

    private Integer questionId;

    private Integer state;

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
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}