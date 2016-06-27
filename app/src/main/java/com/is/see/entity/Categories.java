package com.is.see.entity;

import java.util.List;

/**
 * Created by George on 2016/6/14.
 */
public class Categories {

    private int cat_id;
    private String cat_name;

    private List<Subcategories> subcategories;

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public List<Subcategories> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategories> subcategories) {
        this.subcategories = subcategories;
    }

}
