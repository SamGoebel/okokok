package com.example.sqtest.models;

public class CategoryModel {
    private String categoryId;
    private String categoryName;



    // constructors

    public CategoryModel(String id, String name) {
        this.categoryId = id;
        this.categoryName = name;
    }

    public CategoryModel(String name)
    {
        this.categoryName = name;
    }

    // getters and setters
    public String getId() {
        return categoryId;
    }

    public void setId(String id) {
        this.categoryId = id;
    }

    public String getName() {
        return categoryName;
    }

    public void setName(String name) {
        this.categoryName = name;
    }


}
