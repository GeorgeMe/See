package com.is.see.mvp.view;

import com.is.see.protocol.DealShopsResponse;

/**
 * Created by George on 2016/6/15.
 */
public interface DealShopsView extends BaseView{
    void getDealShops(DealShopsResponse response);
}
