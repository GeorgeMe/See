package com.is.see.mvp.interactor;

import com.is.see.base.Retrofit2See;
import com.is.see.mvp.listeners.BaseMultiLoadedListener;
import com.is.see.mvp.listeners.CommonListInteractor;
import com.is.see.protocol.SearchShopsResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by George on 2016/5/21.
 */
public class SearchShopsInteractorImpl extends Retrofit2See implements CommonListInteractor {

    private BaseMultiLoadedListener<SearchShopsResponse> loadedListener;

    public SearchShopsInteractorImpl(BaseMultiLoadedListener<SearchShopsResponse> loadedListener) {
        this.loadedListener = loadedListener;
    }

    @Override
    public void getCommonListData(final int event, JSONObject json){

        Call<SearchShopsResponse> call = apiConstants.searchshops(
                (Number) json.opt("city_id"),
                json.optString("cat_ids"),
                json.optString("subcat_ids"),
                json.optString("district_ids"),
                json.optString("bizarea_ids"),
                json.optString("location"),
                json.optString("keyword"),
                (Number) json.opt("radius"),
                (Number) json.opt("sort"),
                (Number) json.opt("page"),
                (Number) json.opt("page_size"),
                (Number) json.opt("is_reservation_required")
        );
        call.enqueue(new Callback<SearchShopsResponse>() {
            @Override
            public void onResponse(Call<SearchShopsResponse> call, Response<SearchShopsResponse> response) {
                loadedListener.onSuccess(event,response.body());
            }

            @Override
            public void onFailure(Call<SearchShopsResponse> call, Throwable t) {

            }
        });
    }

}
