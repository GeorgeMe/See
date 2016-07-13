package com.is.see.mvp.interactor;

import android.content.Context;

import com.is.see.base.Retrofit2See;
import com.is.see.mvp.listeners.BaseSingleLoadedListener;
import com.is.see.mvp.listeners.CommonSingleInteractor;
import com.is.see.protocol.CategoriesResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by George on 2016/5/21.
 */
public class CategoriesInteractorImpl extends Retrofit2See implements CommonSingleInteractor {

    private BaseSingleLoadedListener<CategoriesResponse> loadedListener;

    public CategoriesInteractorImpl(Context context, BaseSingleLoadedListener<CategoriesResponse> loadedListener) {
        super(context);
        this.loadedListener = loadedListener;
    }

    @Override
    public void getCommonSingleData(JSONObject json) {

        Call<CategoriesResponse> call = seeApi.categories();
        call.enqueue(new Callback<CategoriesResponse>() {
            @Override
            public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {
                loadedListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<CategoriesResponse> call, Throwable t) {

            }
        });
    }

}
