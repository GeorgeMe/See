package com.is.see.mvp.view;

import com.is.see.entity.SearchDealsData;

/**
 * Created by George on 2016/6/15.
 */
public interface SearchDealsView extends BaseView{

    void refreshListData(SearchDealsData data);

    void addMoreListData(SearchDealsData data);
}
