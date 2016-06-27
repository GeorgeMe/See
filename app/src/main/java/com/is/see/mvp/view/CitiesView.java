package com.is.see.mvp.view;

import com.is.see.protocol.CitiesResponse;

/**
 * Created by George on 2016/6/15.
 */
public interface CitiesView extends BaseView{
    void getCities(CitiesResponse response);
}
