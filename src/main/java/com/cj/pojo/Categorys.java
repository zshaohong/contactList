package com.cj.pojo;

public class Categorys {
    private Integer id;

    private Integer userId;

    private String categorysName;

    private String categoryMark;

    public Categorys(Integer id, Integer userId, String categorysName, String categoryMark) {
        this.id = id;
        this.userId = userId;
        this.categorysName = categorysName;
        this.categoryMark = categoryMark;
    }

    public Categorys() {
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

    public String getCategorysName() {
        return categorysName;
    }

    public void setCategorysName(String categorysName) {
        this.categorysName = categorysName == null ? null : categorysName.trim();
    }

    public String getCategoryMark() {
        return categoryMark;
    }

    public void setCategoryMark(String categoryMark) {
        this.categoryMark = categoryMark == null ? null : categoryMark.trim();
    }
}