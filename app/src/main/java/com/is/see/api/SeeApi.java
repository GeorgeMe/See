package com.is.see.api;

import com.is.see.protocol.BaseResponse;
import com.is.see.protocol.CategoriesResponse;
import com.is.see.protocol.CitiesResponse;
import com.is.see.protocol.DealDetailResponse;
import com.is.see.protocol.DealShopsResponse;
import com.is.see.protocol.DistrictsResponse;
import com.is.see.protocol.SearchDealsResponse;
import com.is.see.protocol.SearchShopsResponse;
import com.is.see.protocol.ShopDealsResponse;
import com.is.see.protocol.ShopInfoResponse;

import java.io.File;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by George on 2016/5/22.
 */
public interface SeeApi {
    //1、糯米商户下团单列表
    @GET("shopdeals")
    Call<ShopDealsResponse> shopdeals(@Query("shop_id") String shop_id);

    //2、糯米商户详情接口
    @GET("shopinfo")
    Call<ShopInfoResponse> shopinfo(@Query("shop_id") String shop_id);

    //3、糯米团单详情接口
    @GET("dealdetail")
    Call<DealDetailResponse> dealdetail(@Query("deal_id") Number deal_id);

    //4、糯米团单城市接口
    @GET("cities")
    Call<CitiesResponse> cities();

    //5、糯米团单行政区接口
    @GET("districts")
    Call<DistrictsResponse> districts(@Query("city_id") Number city_id);

    //6、糯米团单分类信息
    @GET("categories")
    Call<CategoriesResponse> categories();

    //7、根据团单id查询相应
    @GET("dealshops")
    Call<DealShopsResponse> dealshops(@Query("city_id") Number city_id , @Query("deal_id") Number deal_id);

    //8、根据查询条件获取相应团单
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


    //http://api.map.baidu.com/geodata/v3/geotable/create  //POST请求
    @POST("v3/geotable/create")
    Call<BaseResponse> geoTableCreate(@Query("name") String name,@Query("geotype") Number geotype,@Query("is_published") Number is_published,@Query("ak") String ak,@Query("sn") String sn,@Query("timestamp") Number timestamp);

    //http://api.map.baidu.com/geodata/v3/geotable/list // GET请求
    @GET("v3/geotable/list")
    Call<BaseResponse> geoTableList(@Query("name") String name,@Query("ak") String ak,@Query("sn") String sn);

    //http://api.map.baidu.com/geodata/v3/geotable/detail // GET请求
    @GET("v3/geotable/detail")
    Call<BaseResponse> geoTableDetail(@Query("id") Number id,@Query("ak") String ak,@Query("sn") String sn);

    //http://api.map.baidu.com/geodata/v3/geotable/update // POST请求
    @POST("v3/geotable/update")
    Call<BaseResponse> geoTableUpdate(@Query("id") Number id,@Query("is_published") Number is_published,@Query("name") String name,@Query("ak") String ak,@Query("sn") String sn);

    //http://api.map.baidu.com/geodata/v3/geotable/delete // POST请求  注：当geotable里面没有有效数据时，才能删除geotable
    @POST("v3/geotable/delete")
    Call<BaseResponse> geoTableDelete(@Query("id") Number id,@Query("ak") String ak,@Query("sn") String sn);

    //http://api.map.baidu.com/geodata/v3/column/create // POST请求
    @POST("v3/column/create")
    Call<BaseResponse> columnCreate(@Query("name") String name,
                                    @Query("key") String key,
                                    @Query("type") String type,
                                    @Query("max_length") Number max_length,
                                    @Query("default_value") String default_value,
                                    @Query("is_sortfilter_field") Number is_sortfilter_field,
                                    @Query("is_search_field") Number is_search_field,
                                    @Query("is_index_field") Number is_index_field,
                                    @Query("is_unique_field") Number is_unique_field,
                                    @Query("geotable_id") String geotable_id,
                                    @Query("ak") String ak,
                                    @Query("sn") String sn);

    //http://api.map.baidu.com/geodata/v3/column/list // GET请求
    @GET("v3/column/list")
    Call<CategoriesResponse> columnList(@Query("name") String name,@Query("key") String key,@Query("geotable_id") String geotable_id,@Query("ak") String ak,@Query("sn") String sn);

    //http://api.map.baidu.com/geodata/v3/column/detail // GET请求
    @GET("v3/column/detail")
    Call<BaseResponse> columnDetail(@Query("id") Number id,@Query("geotable_id") String geotable_id,@Query("ak") String ak,@Query("sn") String sn);

    //http://api.map.baidu.com/geodata/v3/column/update // POST请求
    @POST("v3/column/update")
    Call<BaseResponse> columnUpdate(@Query("id") Number id,
                                    @Query("geotable_id") String geotable_id,
                                    @Query("name") String name,
                                    @Query("default_value") String default_value,
                                    @Query("max_length") Number max_length,
                                    @Query("is_sortfilter_field") Number is_sortfilter_field,
                                    @Query("is_search_field") Number is_search_field,
                                    @Query("is_index_field") Number is_index_field,
                                    @Query("is_unique_field") Number is_unique_field,
                                    @Query("ak") String ak,
                                    @Query("sn") String sn);

    //http://api.map.baidu.com/geodata/v3/column/delete // POST请求
    @POST("v3/column/delete")
    Call<BaseResponse> columnDelete(@Query("id") Number id,@Query("geotable_id") String geotable_id,@Query("ak") String ak,@Query("sn") String sn);

    //http://api.map.baidu.com/geodata/v3/poi/create // POST请求
    @POST("v3/poi/create")
    Call<CategoriesResponse> poiCreate(@Query("title") String title,
                                       @Query("address") String address,
                                       @Query("tags") String tags,
                                       @Query("latitude") Double latitude,
                                       @Query("longitude") Double longitude,
                                       @Query("coord_type") Number coord_type,
                                       @Query("geotable_id") String geotable_id,
                                       @Query("ak") String ak,
                                       @Query("sn") String sn,
                                       @Query("column key") String column_key);

    //http://api.map.baidu.com/geodata/v3/poi/list // GET请求
    @GET("v3/poi/list")
    Call<BaseResponse> poiList(@Query("index key") String index_key,
                               @Query("title") String title,
                               @Query("tags") String tags,
                               @Query("bounds") String bounds,
                               @Query("geotable_id") String geotable_id,
                               @Query("page_index") Number page_index,
                               @Query("page_size") Number page_size,
                               @Query("ak") String ak,
                               @Query("sn") String sn);

    //http://api.map.baidu.com/geodata/v3/poi/detail // GET请求
    @GET("v3/poi/detail")
    Call<BaseResponse> poiDetail(@Query("id") Number id,@Query("geotable_id") String geotable_id,@Query("ak") String ak,@Query("sn") String sn);

    //http://api.map.baidu.com/geodata/v3/poi/update // POST请求
    @POST("v3/poi/update")
    Call<CategoriesResponse> poiUpdate(@Query("id") Number id,
                                       @Query("key") String key,
                                       @Query("title") String title,
                                       @Query("address") String address,
                                       @Query("tags") String tags,
                                       @Query("latitude") Double latitude,
                                       @Query("longitude") Double longitude,
                                       @Query("coord_type") Number coord_type,
                                       @Query("geotable_id") String geotable_id,
                                       @Query("ak") String ak,
                                       @Query("sn") String sn,
                                       @Query("column key") String column_key);

    //http://api.map.baidu.com/geodata/v3/poi/delete // POST请求
    @POST("v3/poi/delete")
    Call<BaseResponse> poiDelete(@Query("id") Number id,
                                 @Query("key") String key,
                                 @Query("ids") String ids,
                                 @Query("index key") String index_key,
                                 @Query("title") String title,
                                 @Query("tags") String tags,
                                 @Query("bounds") String bounds,
                                 @Query("geotable_id") String geotable_id,
                                 @Query("ak") String ak,
                                 @Query("sn") String sn,
                                 @Query("column key") String column_key,
                                 @Query("is_total_del") Number is_total_del);

    //http://api.map.baidu.com/geodata/v3/poi/upload // POST请求  注：poi_list 为实体对象
    @POST("v3/poi/upload")
    Call<CategoriesResponse> poiUpload(@Query("geotable_id") Number geotable_id,
                                       @Query("poi_list") File poi_list,
                                       @Query("ak") String ak,
                                       @Query("sn") String sn,
                                       @Query("timestamp") Number timestamp);

    //http://api.map.baidu.com/geodata/v3/job/listimportdata // GET请求
    @GET("v3/job/listimportdata")
    Call<BaseResponse> jobListImportData(@Query("geotable_id") Number geotable_id,
                                         @Query("job_id") String job_id,
                                         @Query("status") Number status,
                                         @Query("page_index") Number page_index,
                                         @Query("page_size") Number page_size,
                                         @Query("ak") String ak,
                                         @Query("sn") String sn,
                                         @Query("timestamp") Number timestamp);

    //http://api.map.baidu.com/geodata/v3/job/list // GET请求
    @GET("v3/job/list")
    Call<BaseResponse> jobList(@Query("type") Number type,@Query("status") Number status,@Query("ak") String ak,@Query("sn") String sn);

    //http://api.map.baidu.com/geodata/v3/job/detail // GET请求
    @GET("v3/job/detail")
    Call<BaseResponse> jobDetail(@Query("id") Number id,@Query("ak") String ak,@Query("sn") String sn);


}
