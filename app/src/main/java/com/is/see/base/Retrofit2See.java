package com.is.see.base;

import com.is.see.api.ApiConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by George on 2016/6/15.
 */
public class Retrofit2See {

    protected String baseUrl="http://apis.baidu.com/baidunuomi/openapi/";
    protected Retrofit retrofit;
    protected ApiConstants apiConstants;

    public Retrofit2See() {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiConstants = retrofit.create(ApiConstants.class);
    }

   /* public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }*/
}
