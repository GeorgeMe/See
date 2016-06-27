package com.is.see.mvp.presenter;

import com.is.see.mvp.interactor.CategoriesInteractorImpl;
import com.is.see.mvp.listeners.BaseSingleLoadedListener;
import com.is.see.mvp.view.CategoriesView;
import com.is.see.protocol.CategoriesResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by George on 2016/5/21.
 */
public class CategoriesPresenterImpl implements BaseSingleLoadedListener<CategoriesResponse> {

    private CategoriesInteractorImpl categoriesInteractor;
    private CategoriesView categoriesView;
    public CategoriesPresenterImpl(CategoriesView categoriesView) {
        this.categoriesView=categoriesView;
        categoriesInteractor=new CategoriesInteractorImpl(this);

    }
    public void onSignIn(String shop_id,String password){
        categoriesView.showLoading(null);
        try {
            JSONObject json=new JSONObject();
            json.put("shop_id","1745896");
            categoriesInteractor.getCommonSingleData(json);
        }catch (JSONException j){
            categoriesView.hideLoading();
        }
    }
    @Override
    public void onSuccess(CategoriesResponse data) {
        categoriesView.hideLoading();
        categoriesView.getCategories(data);
    }

    @Override
    public void onFailure(String msg) {
        categoriesView.hideLoading();
    }
}