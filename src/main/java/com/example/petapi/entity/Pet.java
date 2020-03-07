package com.example.petapi.entity;

import java.util.Date;

public class Pet {
    private String id;

    private Integer age;

    private Integer nickname;

    private Integer remark;

    private Integer coverUrl;

    private Integer categoryName;

    private Date createdTime;

    private Date updatedTime;

    private Boolean isDeleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNickname() {
        return nickname;
    }

    public void setNickname(Integer nickname) {
        this.nickname = nickname;
    }

    public Integer getRemark() {
        return remark;
    }

    public void setRemark(Integer remark) {
        this.remark = remark;
    }

    public Integer getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(Integer coverUrl) {
        this.coverUrl = coverUrl;
    }

    public Integer getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(Integer categoryName) {
        this.categoryName = categoryName;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}