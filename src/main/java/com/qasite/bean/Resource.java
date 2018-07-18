package com.qasite.bean;

import java.util.Date;

public class Resource implements SearchResult{

    public static Integer RESOURCE_TYPE_VALUE_VIDEO = 0;
    public static Integer RESOURCE_TYPE_VALUE_DOCUMENT = 1;
    public static Integer RESOURCE_TYPE_VALUE_OTHER = 2;
    public static String RESOURCE_TYPE_VIDEO = "video";
    public static String RESOURCE_TYPE_DOCUMENT = "document";
    public static String RESOURCE_TYPE_OTHER = "other";

    private Integer id;

    private String title;

    private String description;

    private String format;

    private String address;

    private Integer providerId;

    private String type;

    private Integer point;

    private Date date;

    private Integer downloadTimes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format == null ? null : format.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public String getType() {
        if (type == null)
            return checkType(getFormat());
        return type;
    }

    public String checkType(String format){

        return null;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDownloadTimes() {
        return downloadTimes;
    }

    public void setDownloadTimes(Integer downloadTimes) {
        this.downloadTimes = downloadTimes;
    }
}