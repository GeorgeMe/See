package com.is.see.mvp.presenter;

import com.is.see.mvp.interactor.ShopDealsInteractorImpl;
import com.is.see.mvp.listeners.BaseSingleLoadedListener;
import com.is.see.mvp.view.ShopDealsView;
import com.is.see.protocol.ShopDealsResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by George on 2016/5/21.
 */
public class ShopDealsPresenterImpl implements BaseSingleLoadedListener<ShopDealsResponse> {

    private ShopDealsInteractorImpl signInInteractor;
    private ShopDealsView shopDealsView;
    public ShopDealsPresenterImpl(ShopDealsView shopDealsView) {
        this.shopDealsView=shopDealsView;
        signInInteractor=new ShopDealsInteractorImpl(this);

    }
    public void onSignIn(String shop_id,String password){
        shopDealsView.showLoading(null);
        try {
            JSONObject json=new JSONObject();
            json.put("shop_id","1745896");
            signInInteractor.getCommonSingleData(json);
        }catch (JSONException j){
            shopDealsView.hideLoading();
        }
    }
    @Override
    public void onSuccess(ShopDealsResponse data) {
        shopDealsView.hideLoading();
    }

    @Override
    public void onFailure(String msg) {
        shopDealsView.hideLoading();
    }
}