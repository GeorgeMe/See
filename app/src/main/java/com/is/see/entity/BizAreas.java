package com.is.see.entity;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by George on 2016/6/15.
 */
public class BizAreas extends SugarRecord implements Serializable {

    private String biz_area_name;
    private int biz_area_id;

    public BizAreas(String biz_area_name, int biz_area_id) {
        this.biz_area_name = biz_area_name;
        this.biz_area_id = biz_area_id;
    }

    public String getBiz_area_name() {
        return biz_area_name;
    }

    public void setBiz_area_name(String biz_area_name) {
        this.biz_area_name = biz_area_name;
    }

    public int getBiz_area_id() {
        return biz_area_id;
    }

    public void setBiz_area_id(int biz_area_id) {
        this.biz_area_id = biz_area_id;
    }

}
