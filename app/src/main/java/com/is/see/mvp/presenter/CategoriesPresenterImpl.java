package com.is.see.mvp.presenter;

import android.content.Context;

import com.is.see.mvp.interactor.CategoriesInteractorImpl;
import com.is.see.mvp.listeners.BaseSingleLoadedListener;
import com.is.see.mvp.view.CategoriesView;
import com.is.see.protocol.CategoriesResponse;

/**
 * Created by George on 2016/5/21.
 */
public class CategoriesPresenterImpl implements BaseSingleLoadedListener<CategoriesResponse> {
    private Context mContext = null;
    private CategoriesInteractorImpl categoriesInteractor;
    private CategoriesView categoriesView;

    public CategoriesPresenterImpl(Context mContext, CategoriesView categoriesView) {
        this.mContext = mContext;
        this.categoriesView = categoriesView;
        categoriesInteractor=new CategoriesInteractorImpl(mContext,this);
    }

    public void getCategories(){
        categoriesView.showLoading(null);
        categoriesInteractor.getCommonSingleData(null);
    }
    @Override
    public void onSuccess(CategoriesResponse data) {
        categoriesView.hideLoading();
        if (data.getErrno()!=0){
            categoriesView.showError(data.getMsg());
        }else {
            categoriesView.getCategories(data.getCategories());
        }
    }

    @Override
    public void onFailure(String msg) {
        categoriesView.hideLoading();
    }
}