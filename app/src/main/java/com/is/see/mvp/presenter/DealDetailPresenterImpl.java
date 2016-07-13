package com.is.see.mvp.presenter;

import android.content.Context;

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
    private Context mContext = null;
    private DealDetailInteractorImpl dealDetailInteractor;
    private DealDetailView dealDetailView;

    public DealDetailPresenterImpl(Context mContext, DealDetailView dealDetailView) {
        this.mContext = mContext;
        this.dealDetailView = dealDetailView;
        dealDetailInteractor=new DealDetailInteractorImpl(mContext,this);
    }

    public void getDealDetail(Number deal_id){
        dealDetailView.showLoading(null);
        try {
            JSONObject json=new JSONObject();
            json.put("deal_id",deal_id);
            dealDetailInteractor.getCommonSingleData(json);
        }catch (JSONException j){
            dealDetailView.hideLoading();
        }
    }
    @Override
    public void onSuccess(DealDetailResponse data) {
        dealDetailView.hideLoading();
        if (data.getErrno()!=0){
            dealDetailView.showError(data.getMsg());
        }else {
            dealDetailView.getDealDetail(data.getDeal());
        }

    }

    @Override
    public void onFailure(String msg) {
        dealDetailView.hideLoading();
    }
}