package com.is.see.entity;

import me.yokeyword.indexablelistview.IndexEntity;

/**
 * Created by George on 2016/6/14.
 */
public class Cities extends IndexEntity {

    private Number city_id;
    private String city_name;
    private String short_name;
    private String city_pinyin;
    private String short_pinyin;

    public Cities(String name, Number city_id, String city_name, String short_name, String city_pinyin, String short_pinyin) {
        super(name);
        this.city_id = city_id;
        this.city_name = city_name;
        this.short_name = short_name;
        this.city_pinyin = city_pinyin;
        this.short_pinyin = short_pinyin;
    }

    public Number getCity_id() {
        return city_id;
    }

    public void setCity_id(Number city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getCity_pinyin() {
        return city_pinyin;
    }

    public void setCity_pinyin(String city_pinyin) {
        this.city_pinyin = city_pinyin;
    }

    public String getShort_pinyin() {
        return short_pinyin;
    }

    public void setShort_pinyin(String short_pinyin) {
        this.short_pinyin = short_pinyin;
    }
}
