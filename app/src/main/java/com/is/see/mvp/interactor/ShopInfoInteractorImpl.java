package com.is.see.mvp.interactor;

import android.content.Context;

import com.is.see.base.Retrofit2See;
import com.is.see.mvp.listeners.BaseSingleLoadedListener;
import com.is.see.mvp.listeners.CommonSingleInteractor;
import com.is.see.protocol.ShopInfoResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by George on 2016/5/21.
 */
public class ShopInfoInteractorImpl extends Retrofit2See implements CommonSingleInteractor {

    private BaseSingleLoadedListener<ShopInfoResponse> loadedListener;

    public ShopInfoInteractorImpl(Context context, BaseSingleLoadedListener<ShopInfoResponse> loadedListener) {
        super(context);
        this.loadedListener = loadedListener;
    }

    @Override
    public void getCommonSingleData(JSONObject json) {

        Call<ShopInfoResponse> call = seeApi.shopinfo(json.optString("shop_id"));
        call.enqueue(new Callback<ShopInfoResponse>() {
            @Override
            public void onResponse(Call<ShopInfoResponse> call, Response<ShopInfoResponse> response) {
                loadedListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ShopInfoResponse> call, Throwable t) {

            }
        });
    }

}
