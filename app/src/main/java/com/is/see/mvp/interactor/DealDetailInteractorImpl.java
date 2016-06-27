package com.is.see.mvp.interactor;

import com.is.see.base.Retrofit2See;
import com.is.see.mvp.listeners.BaseSingleLoadedListener;
import com.is.see.mvp.listeners.CommonSingleInteractor;
import com.is.see.protocol.DealDetailResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by George on 2016/5/21.
 */
public class DealDetailInteractorImpl extends Retrofit2See implements CommonSingleInteractor {

    private BaseSingleLoadedListener<DealDetailResponse> loadedListener;

    public DealDetailInteractorImpl(BaseSingleLoadedListener<DealDetailResponse> loadedListener) {
        this.loadedListener = loadedListener;
    }

    @Override
    public void getCommonSingleData(JSONObject json) {

        Call<DealDetailResponse> call = apiConstants.dealdetail((Number) json.opt("deal_id"));
        call.enqueue(new Callback<DealDetailResponse>() {
            @Override
            public void onResponse(Call<DealDetailResponse> call, Response<DealDetailResponse> response) {
                loadedListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<DealDetailResponse> call, Throwable t) {

            }
        });
    }

}
