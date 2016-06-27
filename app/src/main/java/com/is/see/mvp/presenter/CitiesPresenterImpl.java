package com.is.see.mvp.presenter;

import com.is.see.mvp.interactor.CitiesInteractorImpl;
import com.is.see.mvp.listeners.BaseSingleLoadedListener;
import com.is.see.mvp.view.CitiesView;
import com.is.see.protocol.CitiesResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by George on 2016/5/21.
 */
public class CitiesPresenterImpl implements BaseSingleLoadedListener<CitiesResponse> {

    private CitiesInteractorImpl citiesInteractor;
    private CitiesView citiesView;
    public CitiesPresenterImpl(CitiesView citiesView) {
        this.citiesView=citiesView;
        citiesInteractor=new CitiesInteractorImpl(this);

    }
    public void getCities(){
        citiesView.showLoading(null);
        try {
            JSONObject json=new JSONObject();
            json.put("shop_id","1745896");
            citiesInteractor.getCommonSingleData(json);
        }catch (JSONException j){
            citiesView.hideLoading();
        }
    }
    @Override
    public void onSuccess(CitiesResponse data) {
        citiesView.hideLoading();
        citiesView.getCities(data);
    }

    @Override
    public void onFailure(String msg) {
        citiesView.hideLoading();
    }
}