package com.is.see.mvp.presenter;

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

    private DistrictsInteractorImpl districtsInteractor;
    private DistrictsView districtsView;
    public DistrictsPresenterImpl(DistrictsView districtsView) {
        this.districtsView=districtsView;
        districtsInteractor=new DistrictsInteractorImpl(this);

    }
    public void onSignIn(String shop_id,String password){
        districtsView.showLoading(null);
        try {
            JSONObject json=new JSONObject();
            json.put("shop_id","1745896");
            districtsInteractor.getCommonSingleData(json);
        }catch (JSONException j){
            districtsView.hideLoading();
        }
    }
    @Override
    public void onSuccess(DistrictsResponse data) {
        districtsView.hideLoading();
        districtsView.getDistricts(data);
    }

    @Override
    public void onFailure(String msg) {
        districtsView.hideLoading();
    }
}