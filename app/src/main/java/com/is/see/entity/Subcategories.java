package com.is.see.entity;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by George on 2016/6/14.
 */
public class Subcategories extends SugarRecord implements Serializable {
    private String subcat_name;
    private int subcat_id;

    public Subcategories() {
    }

    public Subcategories(String subcat_name, int subcat_id) {

        this.subcat_name = subcat_name;
        this.subcat_id = subcat_id;
    }

    public String getSubcat_name() {
        return subcat_name;
    }

    public void setSubcat_name(String subcat_name) {
        this.subcat_name = subcat_name;
    }

    public int getSubcat_id() {
        return subcat_id;
    }

    public void setSubcat_id(int subcat_id) {
        this.subcat_id = subcat_id;
    }
}
