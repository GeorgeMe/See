package com.is.see.ui.filter.main;

/**
 * Created by Administrator on 2016/7/14.
 */
public class MainFilter {

    private volatile static MainFilter filter;

    public int position;
    public String positionTitle;

    public int cat_id;
    public int subcat_id;
    public int district_id;
    public int biz_area_id;
    public int radius;
    public int sort;


    public MainFilter() {
    }

    public static MainFilter instance() {
        if (filter == null) {
            synchronized (MainFilter.class) {
                if (filter == null) {
                    filter = new MainFilter();
                }
            }
        }
        return filter;
    }

    public void clear() {
        filter = null;
    }

    @Override
    public String toString() {
        return "MainFilter{" +
                "position=" + position +
                ", positionTitle='" + positionTitle + '\'' +
                ", cat_id=" + cat_id +
                ", subcat_id=" + subcat_id +
                ", district_id=" + district_id +
                ", biz_area_id=" + biz_area_id +
                ", radius=" + radius +
                ", sort=" + sort +
                '}';
    }
}
