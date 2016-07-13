package com.is.see.mvp.presenter;

import android.content.Context;

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
    private Context mContext = null;
    private ShopInfoInteractorImpl shopInfoInteractor;
    private ShopInfoView shopInfoView;

    public ShopInfoPresenterImpl(Context mContext, ShopInfoView shopInfoView) {
        this.mContext = mContext;
        this.shopInfoView = shopInfoView;
        shopInfoInteractor=new ShopInfoInteractorImpl(mContext,this);
    }

    public ShopInfoPresenterImpl(ShopInfoView shopInfoView) {
        this.shopInfoView=shopInfoView;

    }
    public void getShopInfo(String shop_id){
        shopInfoView.showLoading(null);
        try {
            JSONObject json=new JSONObject();
            json.put("shop_id",shop_id);
            shopInfoInteractor.getCommonSingleData(json);
        }catch (JSONException j){
            shopInfoView.hideLoading();
        }
    }
    @Override
    public void onSuccess(ShopInfoResponse data) {
        shopInfoView.hideLoading();
        if (data.getErrno()!=0){
            shopInfoView.showError(data.getMsg());
        }else {
            shopInfoView.getShopInfo(data.getShop());
        }
    }

    @Override
    public void onFailure(String msg) {
        shopInfoView.hideLoading();
    }
}