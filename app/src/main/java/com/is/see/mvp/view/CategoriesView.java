package com.is.see.mvp.view;

import com.is.see.entity.Categories;

import java.util.List;

/**
 * Created by George on 2016/6/15.
 */
public interface CategoriesView extends BaseView{
    void getCategories(List<Categories> categories);
}
