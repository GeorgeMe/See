package com.is.see.mvp.presenter;

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

    private SearchDealsInteractorImpl searchDealsInteractor;
    private SearchDealsView searchDealsView;
    public SearchDealsPresenterImpl(SearchDealsView searchDealsView) {
        this.searchDealsView=searchDealsView;
        searchDealsInteractor=new SearchDealsInteractorImpl(this);

    }
    public void onSignIn(String shop_id,String password){
        searchDealsView.showLoading(null);
        try {
            JSONObject json=new JSONObject();
            json.put("shop_id","1745896");
            searchDealsInteractor.getCommonListData(0,json);
        }catch (JSONException j){
            searchDealsView.hideLoading();
        }
    }
    @Override
    public void onSuccess(int event_tag,SearchDealsResponse data) {
        searchDealsView.hideLoading();
        searchDealsView.onSearchDeals(data);
    }

    @Override
    public void onFailure(String msg) {
        searchDealsView.hideLoading();
    }
}