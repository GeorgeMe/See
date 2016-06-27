package com.is.see.mvp.view;

import com.is.see.protocol.DistrictsResponse;

/**
 * Created by George on 2016/6/15.
 */
public interface DistrictsView extends BaseView{
    void getDistricts(DistrictsResponse response);
}
