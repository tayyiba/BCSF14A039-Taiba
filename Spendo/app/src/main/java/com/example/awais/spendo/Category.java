package com.example.awais.spendo;

/**
 * Created by awais on 7/25/2017.
 */

public class Category {
    private int id;
    private String catName;

    public Category(){}

    public Category(int id, String catName) {
        this.id = id;
        this.catName = catName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
