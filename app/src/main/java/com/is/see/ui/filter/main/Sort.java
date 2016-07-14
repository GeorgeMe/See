package com.is.see.ui.filter.main;

/**
 * Created by Administrator on 2016/7/14.
 */
public class Sort {
    private int sort;
    private String name;

    public Sort() {
    }

    public Sort(int sort, String name) {
        this.sort = sort;
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
