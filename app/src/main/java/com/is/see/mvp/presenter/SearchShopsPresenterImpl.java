package com.is.see.mvp.presenter;

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

    private SearchShopsInteractorImpl searchShopsInteractor;
    private SearchShopsView searchShopsView;
    public SearchShopsPresenterImpl(SearchShopsView searchShopsView) {
        this.searchShopsView=searchShopsView;
        searchShopsInteractor=new SearchShopsInteractorImpl(this);

    }
    public void onSignIn(String shop_id,String password){
        searchShopsView.showLoading(null);
        try {
            JSONObject json=new JSONObject();
            json.put("shop_id","1745896");
            searchShopsInteractor.getCommonListData(0,json);
        }catch (JSONException j){
            searchShopsView.hideLoading();
        }
    }
    @Override
    public void onSuccess(int event_tag,SearchShopsResponse data) {
        searchShopsView.hideLoading();
    }

    @Override
    public void onFailure(String msg) {
        searchShopsView.hideLoading();
    }
}