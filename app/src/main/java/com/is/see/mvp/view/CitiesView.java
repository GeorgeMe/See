package com.is.see.mvp.view;

import com.is.see.entity.Cities;

import java.util.List;

/**
 * Created by George on 2016/6/15.
 */
public interface CitiesView extends BaseView{
    void getCities(List<Cities> cities);
}
