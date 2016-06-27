package com.is.see.mvp.presenter;

import com.is.see.mvp.interactor.ShopInfoInteractorImpl;
import com.is.see.mvp.listeners.BaseSingleLoadedListener;
import com.is.see.mvp.view.ShopInfoView;
import com.is.see.protocol.ShopInfoResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by George on 2016/5/21.
 */
public class ShopInfoPresenterImpl implements BaseSingleLoadedListener<ShopInfoResponse> {

    private ShopInfoInteractorImpl shopInfoInteractor;
    private ShopInfoView shopInfoView;
    public ShopInfoPresenterImpl(ShopInfoView shopInfoView) {
        this.shopInfoView=shopInfoView;
        shopInfoInteractor=new ShopInfoInteractorImpl(this);

    }
    public void onSignIn(String shop_id,String password){
        shopInfoView.showLoading(null);
        try {
            JSONObject json=new JSONObject();
            json.put("shop_id","1745896");
            shopInfoInteractor.getCommonSingleData(json);
        }catch (JSONException j){
            shopInfoView.hideLoading();
        }
    }
    @Override
    public void onSuccess(ShopInfoResponse data) {
        shopInfoView.hideLoading();
        shopInfoView.getShopInfo(data);
    }

    @Override
    public void onFailure(String msg) {
        shopInfoView.hideLoading();
    }
}