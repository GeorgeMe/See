package com.is.see.ui.activitys;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.is.see.R;
import com.is.see.base.BaseActivity;
import com.is.see.entity.Cities;
import com.is.see.mvp.presenter.CitiesPresenterImpl;
import com.is.see.mvp.view.CitiesView;
import com.is.see.ui.adapters.CityAdapter;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.indexablelistview.IndexEntity;
import me.yokeyword.indexablelistview.IndexHeaderEntity;
import me.yokeyword.indexablelistview.IndexableStickyListView;


/**
 * 选择城市
 * Created by YoKeyword on 2016/3/20.
 */
public class PickCityActivity extends BaseActivity implements CitiesView {
    private IndexableStickyListView mIndexableStickyListView;
    private SearchView mSearchView;

    private CityAdapter mAdapter;
    private List<Cities> mCities = new ArrayList<>();
    private CitiesPresenterImpl citiesPresenter;
    private String[] mHotCities = new String[]{"杭州市", "北京市", "上海市", "广州市"};

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_pick_city;
    }

    @Override
    protected void initViewsAndEvents() {
        // 初始化数据
        citiesPresenter=new CitiesPresenterImpl(mContext,this);
        citiesPresenter.getCities();
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return TransitionMode.SCALE;
    }

    @Override
    public void getCities(List<Cities> cities) {
        mCities=cities;
        for (Cities cities1:mCities){
            Log.e(TAG_LOG,cities1.getName()+"");
        }

        setTitle("选择城市");
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mIndexableStickyListView = (IndexableStickyListView) findViewById(R.id.indexListView);
        mSearchView = (SearchView) findViewById(R.id.searchview);

        mAdapter = new CityAdapter(this);
        mIndexableStickyListView.setAdapter(mAdapter);



        // 添加定位城市Header
        ArrayList<Cities> gpsIndexEntityList = new ArrayList<>();
        final Cities gpsEntity = new Cities("定位中...",-1,"杭州市","杭州市","pinyin","pinyin");
        gpsIndexEntityList.add(gpsEntity);
        IndexHeaderEntity<Cities> gpsHeader = new IndexHeaderEntity<>("定", "GPS自动定位", gpsIndexEntityList);

        // 添加热门城市Header
        IndexHeaderEntity<Cities> hotHeader = new IndexHeaderEntity<>();
        ArrayList<Cities> hotIndexEntityList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Cities hotEntity = new Cities(mHotCities[i],i,mHotCities[i],mHotCities[i],"pinyin","pinyin");
            hotIndexEntityList.add(hotEntity);
        }

        hotHeader.setHeaderTitle("热门城市");
        hotHeader.setIndex("热");
        hotHeader.setHeaderList(hotIndexEntityList);

        // 绑定数据
        mIndexableStickyListView.bindDatas(mCities, gpsHeader, hotHeader);

        // 搜索
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // 委托处理搜索
                mIndexableStickyListView.searchTextChange(newText);
                return true;
            }
        });
        mIndexableStickyListView.setOnItemContentClickListener(new IndexableStickyListView.OnItemContentClickListener() {
            @Override
            public void onItemClick(View v, IndexEntity indexEntity) {
                Cities cityEntity = (Cities) indexEntity;
                Toast.makeText(PickCityActivity.this, "选择了" + cityEntity.getCity_name(), Toast.LENGTH_SHORT).show();
            }
        });

        mIndexableStickyListView.setOnItemTitleClickListener(new IndexableStickyListView.OnItemTitleClickListener() {
            @Override
            public void onItemClick(View v, String title) {
                Toast.makeText(PickCityActivity.this, "点击了" + title, Toast.LENGTH_SHORT).show();
            }
        });

        // 模拟定位
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                gpsEntity.setName("杭州市");
                mAdapter.notifyDataSetChanged();
            }
        }, 3000);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
