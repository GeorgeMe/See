package com.is.see.mvp.view;

import com.is.see.protocol.ShopInfoResponse;

/**
 * Created by George on 2016/6/15.
 */
public interface ShopInfoView extends BaseView{
    void getShopInfo(ShopInfoResponse response);
}
