package com.qasite.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

public class Resource implements SearchResult{

    @JsonIgnore
    public static String DEFAULT_PATH = null;
    @JsonIgnore
    public static Integer RESOURCE_TYPE_VALUE_VIDEO = 0;
    @JsonIgnore
    public static Integer RESOURCE_TYPE_VALUE_DOCUMENT = 1;
    @JsonIgnore
    public static Integer RESOURCE_TYPE_VALUE_OTHER = 2;
    @JsonIgnore
    public static String RESOURCE_TYPE_VIDEO = "video";
    @JsonIgnore
    public static String RESOURCE_TYPE_DOCUMENT = "document";
    @JsonIgnore
    public static String RESOURCE_TYPE_OTHER = "other";

    public Resource(){}
    public Resource(String title,String description,String format,String address,Integer providerId,
                    String type,Integer point,Date date,Integer downloadTimes){

        this.title = title;
        this.description = description;
        this.format = format;
        this.address = address;
        this.providerId = providerId;
        this.type = type;
        this.point = point;
        this.date = date;
        this.downloadTimes = downloadTimes;
    }

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
            return RESOURCE_TYPE_OTHER;
        return type;
    }

    public Integer checkType(String format, List<String> formats){
        for (int i = 0; i < formats.size(); i++){
            if (formats.get(i).trim().toUpperCase().contains(format.trim().toUpperCase()))
                return i;
        }
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