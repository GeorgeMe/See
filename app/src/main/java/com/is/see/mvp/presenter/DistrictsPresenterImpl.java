package com.is.see.mvp.presenter;

import android.content.Context;

import com.is.see.mvp.interactor.DistrictsInteractorImpl;
import com.is.see.mvp.listeners.BaseSingleLoadedListener;
import com.is.see.mvp.view.DistrictsView;
import com.is.see.protocol.DistrictsResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by George on 2016/5/21.
 */
public class DistrictsPresenterImpl implements BaseSingleLoadedListener<DistrictsResponse> {
    private Context mContext = null;
    private DistrictsInteractorImpl districtsInteractor;
    private DistrictsView districtsView;

    public DistrictsPresenterImpl(Context mContext, DistrictsView districtsView) {
        this.mContext = mContext;
        this.districtsView = districtsView;
        districtsInteractor=new DistrictsInteractorImpl(mContext,this);
    }

    public void getDistricts(Number city_id){
        districtsView.showLoading(null);
        try {
            JSONObject json=new JSONObject();
            json.put("city_id",city_id);
            districtsInteractor.getCommonSingleData(json);
        }catch (JSONException j){
            districtsView.hideLoading();
        }
    }
    @Override
    public void onSuccess(DistrictsResponse data) {
        districtsView.hideLoading();
        if (data.getErrno()!=0){
            districtsView.showError(data.getMsg());
        }else {
            districtsView.getDistricts(data.getDistricts());
        }

    }

    @Override
    public void onFailure(String msg) {
        districtsView.hideLoading();
    }
}