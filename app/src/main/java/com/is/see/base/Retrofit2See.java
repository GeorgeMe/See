package com.is.see.base;

import com.is.see.api.SeeApi;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by George on 2016/6/15.
 */
public class Retrofit2See {

    protected String baseUrl="http://apis.baidu.com/baidunuomi/openapi/";
    protected Retrofit retrofit;
    protected SeeApi seeApi;

    public Retrofit2See() {
        if (retrofit==null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            /**
             * 设置公共参数
             */
            builder.addInterceptor(addQueryParameterInterceptor());
            /**
             * 设置头
             */
            builder.addInterceptor(addHeaderInterceptor());

            OkHttpClient client = builder.build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        seeApi = retrofit.create(SeeApi.class);
    }

   /* public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }*/

    /**
     * 设置公共参数
     */
    private static Interceptor addQueryParameterInterceptor() {
        Interceptor addQueryParameterInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request request;
                HttpUrl modifiedUrl = originalRequest.url().newBuilder()
                        // Provide your custom parameter here
                        .addQueryParameter("platform", "android")
                        .addQueryParameter("version", "1.0.0")
                        .build();
                request = originalRequest.newBuilder().url(modifiedUrl).build();
                return chain.proceed(request);
            }
        };
        return addQueryParameterInterceptor;
    }

    /**
     * 设置头
     */
    private static Interceptor addHeaderInterceptor() {
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder requestBuilder = originalRequest.newBuilder()
                        // Provide your custom header here
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .header("apikey", "afd4c07e56a3f661aac83c1dc8e0fe7f")
                        .method(originalRequest.method(), originalRequest.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
        return headerInterceptor;
    }


}
