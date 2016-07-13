package com.is.see.mvp.interactor;

import android.content.Context;
import android.util.Log;

import com.is.see.base.Retrofit2See;
import com.is.see.mvp.listeners.BaseSingleLoadedListener;
import com.is.see.mvp.listeners.CommonSingleInteractor;
import com.is.see.protocol.CitiesResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by George on 2016/5/21.
 */
public class CitiesInteractorImpl extends Retrofit2See implements CommonSingleInteractor {

    private BaseSingleLoadedListener<CitiesResponse> loadedListener;

    public CitiesInteractorImpl(Context context, BaseSingleLoadedListener<CitiesResponse> loadedListener) {
        super(context);
        this.loadedListener = loadedListener;
    }

    @Override
    public void getCommonSingleData(JSONObject json) {

        Call<CitiesResponse> call = seeApi.cities();
        call.enqueue(new Callback<CitiesResponse>() {
            @Override
            public void onResponse(Call<CitiesResponse> call, Response<CitiesResponse> response) {
                loadedListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<CitiesResponse> call, Throwable t) {
                Log.e("PickCityActivity","onFailure "+t.getMessage());
            }
        });
    }

}
