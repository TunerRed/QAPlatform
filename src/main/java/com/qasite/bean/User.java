package com.qasite.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    //df.format(Math.random()*3<2?new Date():new Date());

    public User(){};
    public User(String userName,String password,String email,Date reg_date,Date status){
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.gender = Math.random()*1.0<0.5?"MALE":"FEMALE";
        this.type = Math.random()*2.0<1.5?"STUDENT":"TEACHER";
        this.credit = 20;
        this.states = status;
        this.regTime = reg_date;
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
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Date getStates() {
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