package com.cj.vo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by QQ猴王 on 2017/6/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactVo {
    private Integer id;

    private String category;

    private String categoryMark;

    private String contactName;

    private String contactSex;

    private String contactPhone;

    private String contactEmail;

    private String contactDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactSex() {
        return contactSex;
    }

    public void setContactSex(String contactSex) {
        this.contactSex = contactSex;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactDesc() {
        return contactDesc;
    }

    public void setContactDesc(String contactDesc) {
        this.contactDesc = contactDesc;
    }

    public String getCategoryMark() {
        return categoryMark;
    }

    public void setCategoryMark(String categoryMark) {
        this.categoryMark = categoryMark;
    }
}
