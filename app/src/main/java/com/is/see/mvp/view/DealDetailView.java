package com.is.see.mvp.view;

import com.is.see.protocol.DealDetailResponse;

/**
 * Created by George on 2016/6/15.
 */
public interface DealDetailView extends BaseView{
    void getDealDetail(DealDetailResponse response);
}
