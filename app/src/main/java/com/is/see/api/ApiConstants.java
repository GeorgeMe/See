package com.is.see.api;

import com.is.see.protocol.CategoriesResponse;
import com.is.see.protocol.CitiesResponse;
import com.is.see.protocol.DealDetailResponse;
import com.is.see.protocol.DealShopsResponse;
import com.is.see.protocol.DistrictsResponse;
import com.is.see.protocol.SearchDealsResponse;
import com.is.see.protocol.SearchShopsResponse;
import com.is.see.protocol.ShopDealsResponse;
import com.is.see.protocol.ShopInfoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by George on 2016/5/22.
 */
public interface ApiConstants {
    //1、糯米商户下团单列表
    @Headers({"Content-Type: application/json","apikey:afd4c07e56a3f661aac83c1dc8e0fe7f"})
    @GET("shopdeals")
    Call<ShopDealsResponse> shopdeals(@Query("shop_id") String shop_id);

    //2、糯米商户详情接口
    @Headers({"Content-Type: application/json","apikey:afd4c07e56a3f661aac83c1dc8e0fe7f"})
    @GET("shopinfo")
    Call<ShopInfoResponse> shopinfo(@Query("shop_id") String shop_id);

    //3、糯米团单详情接口
    @Headers({"Content-Type: application/json","apikey:afd4c07e56a3f661aac83c1dc8e0fe7f"})
    @GET("dealdetail")
    Call<DealDetailResponse> dealdetail(@Query("deal_id") Number deal_id);

    //4、糯米团单城市接口
    @Headers({"Content-Type: application/json","apikey:afd4c07e56a3f661aac83c1dc8e0fe7f"})
    @GET("cities")
    Call<CitiesResponse> cities();

    //5、糯米团单行政区接口
    @Headers({"Content-Type: application/json","apikey:afd4c07e56a3f661aac83c1dc8e0fe7f"})
    @GET("districts")
    Call<DistrictsResponse> districts(@Query("city_id") Number city_id);

    //6、糯米团单分类信息
    @Headers({"Content-Type: application/json","apikey:afd4c07e56a3f661aac83c1dc8e0fe7f"})
    @GET("categories")
    Call<CategoriesResponse> categories();

    //7、根据团单id查询相应
    @Headers({"Content-Type: application/json","apikey:afd4c07e56a3f661aac83c1dc8e0fe7f"})
    @GET("dealshops")
    Call<DealShopsResponse> dealshops(@Query("city_id") Number city_id , @Query("deal_id") Number deal_id);

    //8、根据查询条件获取相应团单
    @Headers({"Content-Type: application/json","apikey:afd4c07e56a3f661aac83c1dc8e0fe7f"})
    @GET("searchdeals")
    Call<SearchDealsResponse> searchdeals(@Query("city_id") Number city_id ,
                                          @Query("cat_ids") String cat_ids ,
                                          @Query("subcat_ids") String subcat_ids ,
                                          @Query("district_ids") String district_ids ,
                                          @Query("bizarea_ids") String bizarea_ids ,
                                          @Query("location") String location ,
                                          @Query("keyword") String keyword ,
                                          @Query("radius") Number radius ,
                                          @Query("sort") Number sort ,
                                          @Query("page") Number page ,
                                          @Query("page_size") Number page_size ,
                                          @Query("is_reservation_required") Number is_reservation_required);

    //9、根据查询条件获取查商铺
    @Headers({"Content-Type: application/json","apikey:afd4c07e56a3f661aac83c1dc8e0fe7f"})
    @GET("searchshops")
    Call<SearchShopsResponse> searchshops(@Query("city_id") Number city_id ,
                                          @Query("cat_ids") String cat_ids ,
                                          @Query("subcat_ids") String subcat_ids ,
                                          @Query("district_ids") String district_ids ,
                                          @Query("bizarea_ids") String bizarea_ids ,
                                          @Query("location") String location ,
                                          @Query("keyword") String keyword ,
                                          @Query("radius") Number radius ,
                                          @Query("sort") Number sort ,
                                          @Query("page") Number page ,
                                          @Query("page_size") Number page_size ,
                                          @Query("is_reservation_required") Number is_reservation_required);

}
