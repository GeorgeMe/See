package com.is.see.mvp.interactor;

import com.is.see.base.Retrofit2See;
import com.is.see.mvp.listeners.BaseSingleLoadedListener;
import com.is.see.mvp.listeners.CommonSingleInteractor;
import com.is.see.protocol.DistrictsResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by George on 2016/5/21.
 */
public class DistrictsInteractorImpl extends Retrofit2See implements CommonSingleInteractor {

    private BaseSingleLoadedListener<DistrictsResponse> loadedListener;

    public DistrictsInteractorImpl(BaseSingleLoadedListener<DistrictsResponse> loadedListener) {
        this.loadedListener = loadedListener;
    }

    @Override
    public void getCommonSingleData(JSONObject json) {

        Call<DistrictsResponse> call = seeApi.districts((Number) json.opt("city_id"));
        call.enqueue(new Callback<DistrictsResponse>() {
            @Override
            public void onResponse(Call<DistrictsResponse> call, Response<DistrictsResponse> response) {
                loadedListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<DistrictsResponse> call, Throwable t) {

            }
        });
    }

}
