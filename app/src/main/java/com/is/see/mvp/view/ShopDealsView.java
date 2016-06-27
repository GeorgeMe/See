package com.is.see.mvp.view;

import com.is.see.protocol.ShopDealsResponse;

/**
 * Created by George on 2016/6/15.
 */
public interface ShopDealsView extends BaseView {
    void getShopDeals(ShopDealsResponse response);
}
