package com.is.see.mvp.view;

import com.is.see.protocol.SearchDealsResponse;

/**
 * Created by George on 2016/6/15.
 */
public interface SearchDealsView extends BaseView{
    void onSearchDeals(SearchDealsResponse response);
}
