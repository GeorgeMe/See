package com.is.see.mvp.view;

import com.is.see.protocol.CategoriesResponse;

/**
 * Created by George on 2016/6/15.
 */
public interface CategoriesView extends BaseView{
    void getCategories(CategoriesResponse response);
}
