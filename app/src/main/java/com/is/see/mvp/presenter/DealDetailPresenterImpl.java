package com.is.see.mvp.presenter;

import com.is.see.mvp.interactor.DealDetailInteractorImpl;
import com.is.see.mvp.listeners.BaseSingleLoadedListener;
import com.is.see.mvp.view.DealDetailView;
import com.is.see.protocol.DealDetailResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by George on 2016/5/21.
 */
public class DealDetailPresenterImpl implements BaseSingleLoadedListener<DealDetailResponse> {

    private DealDetailInteractorImpl dealDetailInteractor;
    private DealDetailView dealDetailView;
    public DealDetailPresenterImpl(DealDetailView dealDetailView) {
        this.dealDetailView=dealDetailView;
        dealDetailInteractor=new DealDetailInteractorImpl(this);

    }
    public void onSignIn(String shop_id,String password){
        dealDetailView.showLoading(null);
        try {
            JSONObject json=new JSONObject();
            json.put("shop_id","1745896");
            dealDetailInteractor.getCommonSingleData(json);
        }catch (JSONException j){
            dealDetailView.hideLoading();
        }
    }
    @Override
    public void onSuccess(DealDetailResponse data) {
        dealDetailView.hideLoading();
        dealDetailView.getDealDetail(data);
    }

    @Override
    public void onFailure(String msg) {
        dealDetailView.hideLoading();
    }
}