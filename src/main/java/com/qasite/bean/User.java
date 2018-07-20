package com.qasite.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class User {

    //默认的积分，提交回复后增加少量积分
    public static Integer DEFAULT_CREDIT_POINT = 2;
    //用户的权限，管理员或普通用户
    public static Integer PERMISSION_VALUE_ADMIN = 1;
    public static Integer PERMISSION_VALUE_NO_ADMIN = 0;
    public static String ROLE_ADMIN = "admin";
    public static String ROLE_USER= "user";
    public static String ROLE_NULL= "visitor";
    //老师或学生的身份
    public static String ROLE_STUDENT = "student";
    public static String ROLE_TEACHER = "teacher";
    //用户性别
    public static String GENDER_MALE = "MALE";
    public static String GENDER_FEMALE = "FEMALE";
    //用户是否被禁言
    public static String SHUT_UP_MESSAGE_TRUE = "TRUE";
    public static String SHUT_UP_MESSAGE_FALSE = "FALSE";

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    //df.format(Math.random()*3<2?new Date():new Date());

    public User(){};
    public User(String userName,String password,String email,Date reg_date,Date status){
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.gender = Math.random()*1.0<0.5?GENDER_MALE:GENDER_FEMALE;
        this.type = Math.random()*2.0<1.5?ROLE_STUDENT:ROLE_TEACHER;
        this.credit = 20;
        this.states = status;
        this.regTime = reg_date;
        this.rank = PERMISSION_VALUE_NO_ADMIN;
    }

    private Integer id;

    private String userName;

    private String password;

    private String gender;

    private String email;

    private String type;

    private Date regTime;
    private String reg_time;

    private Integer credit;

    private Date states;

    private Integer rank;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getGender() {
        return gender.toUpperCase();
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim().toUpperCase();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getType() {
        return type.toUpperCase();
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim().toUpperCase();
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Date getStates() {
        //若禁言时间为空，则设置为注册时间
        if (states == null){
            setStates(getRegTime());
        }
        return states;
    }

    public void setStates(Date states) {
        this.states = states;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getReg_time() {
        reg_time = df.format(regTime);
        return reg_time;
    }

    public void setReg_time(String reg_time) {
        this.reg_time = reg_time;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }
}