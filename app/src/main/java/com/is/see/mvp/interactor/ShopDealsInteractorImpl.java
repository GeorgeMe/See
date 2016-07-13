package com.is.see.mvp.interactor;

import android.content.Context;

import com.is.see.base.Retrofit2See;
import com.is.see.mvp.listeners.BaseSingleLoadedListener;
import com.is.see.mvp.listeners.CommonSingleInteractor;
import com.is.see.protocol.ShopDealsResponse;

import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by George on 2016/5/21.
 */
public class ShopDealsInteractorImpl extends Retrofit2See implements CommonSingleInteractor {

    private BaseSingleLoadedListener<ShopDealsResponse> loadedListener;

    public ShopDealsInteractorImpl(Context context, BaseSingleLoadedListener<ShopDealsResponse> loadedListener) {
        super(context);
        this.loadedListener = loadedListener;
    }

    @Override
    public void getCommonSingleData(JSONObject json) {

        Call<ShopDealsResponse> call = seeApi.shopdeals(json.optString("shop_id"));
        call.enqueue(new Callback<ShopDealsResponse>() {
            @Override
            public void onResponse(Call<ShopDealsResponse> call, Response<ShopDealsResponse> response) {
                loadedListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ShopDealsResponse> call, Throwable t) {

            }
        });
    }

}
