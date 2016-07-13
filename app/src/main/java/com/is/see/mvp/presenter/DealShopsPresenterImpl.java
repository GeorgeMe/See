package com.is.see.mvp.presenter;

import android.content.Context;

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
    private Context mContext = null;
    private DealShopsInteractorImpl dealShopsInteractor;
    private DealShopsView dealShopsView;

    public DealShopsPresenterImpl(Context mContext, DealShopsView dealShopsView) {
        this.mContext = mContext;
        this.dealShopsView = dealShopsView;
        dealShopsInteractor=new DealShopsInteractorImpl(mContext,this);
    }

    public void getDealShops(Number city_id, Number deal_id){
        dealShopsView.showLoading(null);
        try {
            JSONObject json=new JSONObject();
            json.put("city_id",city_id);
            json.put("deal_id",deal_id);
            dealShopsInteractor.getCommonSingleData(json);
        }catch (JSONException j){
            dealShopsView.hideLoading();
        }
    }
    @Override
    public void onSuccess(DealShopsResponse data) {
        dealShopsView.hideLoading();
        if (data.getErrno()!=0){
            dealShopsView.showError(data.getMsg());
        }else {
            dealShopsView.getDealShops(data.getShops());
        }

    }

    @Override
    public void onFailure(String msg) {
        dealShopsView.hideLoading();
    }
}