package com.is.see.mvp.presenter;

import android.content.Context;

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
    private Context mContext = null;
    private ShopDealsInteractorImpl signInInteractor;
    private ShopDealsView shopDealsView;

    public ShopDealsPresenterImpl(Context mContext, ShopDealsView shopDealsView) {
        this.mContext = mContext;
        this.shopDealsView = shopDealsView;
        signInInteractor=new ShopDealsInteractorImpl(mContext,this);
    }

    public void getShopDeals(String shop_id){
        shopDealsView.showLoading(null);
        try {
            JSONObject json=new JSONObject();
            json.put("shop_id",shop_id);
            signInInteractor.getCommonSingleData(json);
        }catch (JSONException j){
            shopDealsView.hideLoading();
        }
    }
    @Override
    public void onSuccess(ShopDealsResponse data) {
        shopDealsView.hideLoading();
        if (data.getErrno()!=0){
            shopDealsView.showError(data.getMsg());
        }else {
            shopDealsView.getShopDeals(data.getDeals());
        }
    }

    @Override
    public void onFailure(String msg) {
        shopDealsView.hideLoading();
    }
}