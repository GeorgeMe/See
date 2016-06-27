package com.is.see.mvp.presenter;

import com.is.see.mvp.interactor.DealShopsInteractorImpl;
import com.is.see.mvp.listeners.BaseSingleLoadedListener;
import com.is.see.mvp.view.DealShopsView;
import com.is.see.protocol.DealShopsResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by George on 2016/5/21.
 */
public class DealShopsPresenterImpl implements BaseSingleLoadedListener<DealShopsResponse> {

    private DealShopsInteractorImpl dealShopsInteractor;
    private DealShopsView dealShopsView;
    public DealShopsPresenterImpl(DealShopsView dealShopsView) {
        this.dealShopsView=dealShopsView;
        dealShopsInteractor=new DealShopsInteractorImpl(this);

    }
    public void onSignIn(String shop_id,String password){
        dealShopsView.showLoading(null);
        try {
            JSONObject json=new JSONObject();
            json.put("shop_id","1745896");
            dealShopsInteractor.getCommonSingleData(json);
        }catch (JSONException j){
            dealShopsView.hideLoading();
        }
    }
    @Override
    public void onSuccess(DealShopsResponse data) {
        dealShopsView.hideLoading();
        dealShopsView.getDealShops(data);
    }

    @Override
    public void onFailure(String msg) {
        dealShopsView.hideLoading();
    }
}