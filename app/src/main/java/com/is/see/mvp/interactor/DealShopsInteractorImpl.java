package com.is.see.mvp.interactor;

import com.is.see.base.Retrofit2See;
import com.is.see.mvp.listeners.BaseSingleLoadedListener;
import com.is.see.mvp.listeners.CommonSingleInteractor;
import com.is.see.protocol.DealShopsResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by George on 2016/5/21.
 */
public class DealShopsInteractorImpl extends Retrofit2See implements CommonSingleInteractor {

    private BaseSingleLoadedListener<DealShopsResponse> loadedListener;

    public DealShopsInteractorImpl(BaseSingleLoadedListener<DealShopsResponse> loadedListener) {
        this.loadedListener = loadedListener;
    }

    @Override
    public void getCommonSingleData(JSONObject json) {

        Call<DealShopsResponse> call = seeApi.dealshops((Number) json.opt("city_id"),(Number) json.opt("deal_id"));
        call.enqueue(new Callback<DealShopsResponse>() {
            @Override
            public void onResponse(Call<DealShopsResponse> call, Response<DealShopsResponse> response) {
                loadedListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<DealShopsResponse> call, Throwable t) {

            }
        });
    }

}
