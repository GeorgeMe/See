package com.is.see.mvp.view;

import com.is.see.entity.Districts;

import java.util.List;

/**
 * Created by George on 2016/6/15.
 */
public interface DistrictsView extends BaseView{
    void getDistricts(List<Districts> districts);
}
