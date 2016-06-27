package com.is.see.mvp.view;

import com.is.see.protocol.SearchShopsResponse;

/**
 * Created by George on 2016/6/15.
 */
public interface SearchShopsView extends BaseView{
    void onSearchShops(SearchShopsResponse response);
}
