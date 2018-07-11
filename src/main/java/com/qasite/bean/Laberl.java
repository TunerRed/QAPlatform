package com.qasite.bean;

public class Laberl {
    private Integer id;

    private String name;

    private String faLabel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFaLabel() {
        return faLabel;
    }

    public void setFaLabel(String faLabel) {
        this.faLabel = faLabel == null ? null : faLabel.trim();
    }
}