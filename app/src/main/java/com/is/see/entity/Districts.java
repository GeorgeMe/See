package com.is.see.entity;

import java.util.List;

/**
 * Created by George on 2016/6/15.
 */
public class Districts {

    private String district_name;
    private int district_id;
    private List<BizAreas> biz_areas;

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public int getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    public List<BizAreas> getBiz_areas() {
        return biz_areas;
    }

    public void setBiz_areas(List<BizAreas> biz_areas) {
        this.biz_areas = biz_areas;
    }
}
