package com.is.see.mvp.presenter;

import android.content.Context;

import com.is.see.mvp.interactor.CitiesInteractorImpl;
import com.is.see.mvp.listeners.BaseSingleLoadedListener;
import com.is.see.mvp.view.CitiesView;
import com.is.see.protocol.CitiesResponse;

/**
 * Created by George on 2016/5/21.
 */
public class CitiesPresenterImpl implements BaseSingleLoadedListener<CitiesResponse> {
    private Context mContext = null;
    private CitiesInteractorImpl citiesInteractor;
    private CitiesView citiesView;

    public CitiesPresenterImpl(Context mContext, CitiesView citiesView) {
        this.mContext = mContext;
        this.citiesView = citiesView;
        citiesInteractor=new CitiesInteractorImpl(mContext,this);
    }

    public void getCities(){
        citiesView.showLoading(null);
        citiesInteractor.getCommonSingleData(null);
    }
    @Override
    public void onSuccess(CitiesResponse data) {
        citiesView.hideLoading();
        if (data.getErrno()!=0){
            citiesView.showError(data.getMsg());
        }else {
            citiesView.getCities(data.getCities());
        }

    }

    @Override
    public void onFailure(String msg) {
        citiesView.hideLoading();
    }
}