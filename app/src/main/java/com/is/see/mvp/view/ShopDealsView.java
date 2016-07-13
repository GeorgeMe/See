package com.is.see.mvp.view;

import com.is.see.entity.ShopDeals;

import java.util.List;

/**
 * Created by George on 2016/6/15.
 */
public interface ShopDealsView extends BaseView {
    void getShopDeals(List<ShopDeals> deals);
}
