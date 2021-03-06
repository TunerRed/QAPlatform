package com.qasite.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class Question implements SearchResult{

    @JsonIgnore
    public static Integer STATUS_VALUE_OPEN = 1;
    @JsonIgnore
    public static Integer STATUS_VALUE_CLOSED = 0;
    @JsonIgnore
    public static String STATUS_MESSAGE_OPEN = "open";
    @JsonIgnore
    public static String STATUS_MESSAGE_CLOSED = "closed";

    public Question(){}
    public Question(Date arise_time,String title,String description,Integer ariserId,Integer points,Integer states,Integer answers){
        this.title = title;
        this.description = description;
        this.points = points;
        this.states = states;
        this.ariserId = ariserId;
        this.answers = answers;
        this.time1 = arise_time;
    }

    private Integer id;

    private Date time1;

    private String description;

    private String title;

    private Integer ariserId;

    private Integer points;

    private Integer answers;

    private Integer states;

    private String label1;

    private String label2;

    private String label3;


    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return this.getTime1();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime1() {
        return time1;
    }

    public void setTime1(Date time1) {
        this.time1 = time1;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getAriserId() {
        return ariserId;
    }

    public void setAriserId(Integer ariserId) {
        this.ariserId = ariserId;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getAnswers() {
        return answers;
    }

    public void setAnswers(Integer answers) {
        this.answers = answers;
    }

    public Integer getStates() {
        if (states == null || states == STATUS_VALUE_CLOSED)
            return STATUS_VALUE_CLOSED;
        return STATUS_VALUE_OPEN;
    }

    public void setStates(Integer states) {
        this.states = states;
    }

    public String getLabel1() {
        return label1;
    }

    public void setLabel1(String label1) {
        this.label1 = label1 == null ? null : label1.trim();
    }

    public String getLabel2() {
        return label2;
    }

    public void setLabel2(String label2) {
        this.label2 = label2 == null ? null : label2.trim();
    }

    public String getLabel3() {
        return label3;
    }

    public void setLabel3(String label3) {
        this.label3 = label3 == null ? null : label3.trim();
    }

}