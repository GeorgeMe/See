package com.is.see.mvp.presenter;

import android.content.Context;

import com.is.see.mvp.interactor.SearchDealsInteractorImpl;
import com.is.see.mvp.listeners.BaseMultiLoadedListener;
import com.is.see.mvp.view.SearchDealsView;
import com.is.see.protocol.SearchDealsResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by George on 2016/5/21.
 */
public class SearchDealsPresenterImpl implements BaseMultiLoadedListener<SearchDealsResponse> {
    private Context mContext = null;
    private SearchDealsInteractorImpl searchDealsInteractor;
    private SearchDealsView searchDealsView;

    public SearchDealsPresenterImpl(Context mContext, SearchDealsView searchDealsView) {
        this.mContext = mContext;
        this.searchDealsView = searchDealsView;
        searchDealsInteractor=new SearchDealsInteractorImpl(mContext,this);
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
    public void onSearchDeals(int event,Number city_id,
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

        searchDealsView.showLoading(null);
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
            searchDealsInteractor.getCommonListData(event,json);
        }catch (JSONException j){
            searchDealsView.hideLoading();
        }
    }
    @Override
    public void onSuccess(int event_tag,SearchDealsResponse data) {
        searchDealsView.hideLoading();
        if (data.getErrno()!=0){
            searchDealsView.showError(data.getMsg());
        }else {
            searchDealsView.onSearchDeals(data.getData());
        }

    }

    @Override
    public void onFailure(String msg) {
        searchDealsView.hideLoading();
    }
}