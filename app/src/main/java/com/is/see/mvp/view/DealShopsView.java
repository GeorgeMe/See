package com.is.see.mvp.view;

import com.is.see.entity.DealShops;

import java.util.List;

/**
 * Created by George on 2016/6/15.
 */
public interface DealShopsView extends BaseView{
    void getDealShops(List<DealShops> shops);
}
