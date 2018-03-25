package com.elife.elife.e_life.adapters;

/**
 * Created by anshad on 25/3/18.
 */

public class DataProvider {

    private String id;
    private String categoryname;

    public DataProvider(String id,String categoryname){
        this.id = id;
        this.categoryname = categoryname;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String weight) {
        this.categoryname = categoryname;
    }

}