package com.is.see.mvp.presenter;

import android.content.Context;

import com.is.see.mvp.interactor.SearchShopsInteractorImpl;
import com.is.see.mvp.listeners.BaseMultiLoadedListener;
import com.is.see.mvp.view.SearchShopsView;
import com.is.see.protocol.SearchShopsResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by George on 2016/5/21.
 */
public class SearchShopsPresenterImpl implements BaseMultiLoadedListener<SearchShopsResponse> {

    private Context mContext = null;
    private SearchShopsInteractorImpl searchShopsInteractor;
    private SearchShopsView searchShopsView;

    public SearchShopsPresenterImpl(Context mContext, SearchShopsView searchShopsView) {
        this.mContext = mContext;
        this.searchShopsView = searchShopsView;
        searchShopsInteractor=new SearchShopsInteractorImpl(mContext,this);
    }

    /**
     *
     * @param event
     * @param city_id
     * @param cat_ids
     * @param subcat_ids
     * @param district_ids
     * @param bizarea_ids
     * @param location
     * @param keyword
     * @param radius
     * @param sort
     * @param page
     * @param page_size
     * @param is_reservation_required
     */
    public void onSearchShops(int event,Number city_id,
                              String cat_ids,
                              String subcat_ids,
                              String district_ids,
                              String bizarea_ids,
                              String location,
                              String keyword,
                              Number radius,
                              Number sort,
                              Number page,
                              Number page_size,
                              Number is_reservation_required){
        searchShopsView.showLoading(null);
        try {
            JSONObject json=new JSONObject();
            json.put("city_id",city_id);
            json.put("cat_ids",cat_ids);
            json.put("subcat_ids",subcat_ids);
            json.put("district_ids",district_ids);
            json.put("bizarea_ids",bizarea_ids);
            json.put("location",location);
            json.put("keyword",keyword);
            json.put("radius",radius);
            json.put("sort",sort);
            json.put("page",page);
            json.put("page_size",page_size);
            json.put("is_reservation_required",is_reservation_required);
            searchShopsInteractor.getCommonListData(event,json);
        }catch (JSONException j){
            searchShopsView.hideLoading();
        }
    }
    @Override
    public void onSuccess(int event_tag,SearchShopsResponse data) {
        searchShopsView.hideLoading();
        if (data.getErrno()!=0){
            searchShopsView.showError(data.getMsg());
        }else {
            searchShopsView.onSearchShops(data.getData());
        }
    }

    @Override
    public void onFailure(String msg) {
        searchShopsView.hideLoading();
    }
}