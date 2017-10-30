package com.cj.pojo;

public class Contacts {
    private Integer id;

    private Integer userId;

    private Integer categorysId;

    private String contactName;

    private String contactSex;

    private String contactPhone;

    private String contactEmail;

    private String contactDesc;

    public Contacts(Integer id, Integer userId, Integer categorysId, String contactName, String contactSex, String contactPhone, String contactEmail, String contactDesc) {
        this.id = id;
        this.userId = userId;
        this.categorysId = categorysId;
        this.contactName = contactName;
        this.contactSex = contactSex;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.contactDesc = contactDesc;
    }

    public Contacts() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategorysId() {
        return categorysId;
    }

    public void setCategorysId(Integer categorysId) {
        this.categorysId = categorysId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactSex() {
        return contactSex;
    }

    public void setContactSex(String contactSex) {
        this.contactSex = contactSex == null ? null : contactSex.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    public String getContactDesc() {
        return contactDesc;
    }

    public void setContactDesc(String contactDesc) {
        this.contactDesc = contactDesc == null ? null : contactDesc.trim();
    }
}