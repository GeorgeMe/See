package com.is.see.ui.activitys;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.is.see.R;
import com.is.see.base.BaseActivity;
import com.is.see.entity.Categories;
import com.is.see.entity.Districts;
import com.is.see.entity.SearchDeals;
import com.is.see.entity.SearchDealsData;
import com.is.see.mvp.presenter.CategoriesPresenterImpl;
import com.is.see.mvp.presenter.DistrictsPresenterImpl;
import com.is.see.mvp.presenter.SearchDealsPresenterImpl;
import com.is.see.mvp.view.CategoriesView;
import com.is.see.mvp.view.DistrictsView;
import com.is.see.mvp.view.SearchDealsView;
import com.is.see.ui.adapters.MainAdapter;
import com.is.see.ui.filter.main.MainDropMenuAdapter;
import com.is.see.ui.filter.main.MainFilter;
import com.is.ui.adapter.BaseQuickAdapter;
import com.is.ui.filter.DropDownMenu;
import com.is.ui.filter.interfaces.OnFilterDoneListener;

import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements OnFilterDoneListener, CategoriesView, DistrictsView,SearchDealsView, BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.dropDownMenu)
    DropDownMenu dropDownMenu;

    @Bind(R.id.mFilterContentView)
    RecyclerView mFilterContentView;
    @Bind(R.id.swipeLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private CategoriesPresenterImpl categoriesPresenter;
    private DistrictsPresenterImpl districtsPresenter;
    private SearchDealsPresenterImpl searchDealsPresenter;
    private List<Categories> categories;
    private List<Districts> districts;
    private List<SearchDeals> searchDeals;
    private MainDropMenuAdapter mainDropMenuAdapter;
    MainAdapter mainAdapter;
    int you;

    private String location;
    private String keyword;
    private int page = 1;
    private int PAGE_SIZE = 1;
    private int is_reservation_required = 1;

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewsAndEvents() {

        mSwipeRefreshLayout.setOnRefreshListener(this);
        mFilterContentView.setLayoutManager(new LinearLayoutManager(this));

        categoriesPresenter = new CategoriesPresenterImpl(mContext, this);
        districtsPresenter = new DistrictsPresenterImpl(mContext, this);
        searchDealsPresenter=new SearchDealsPresenterImpl(mContext,this);

        categoriesPresenter.getCategories();
        districtsPresenter.getDistricts(100010000);
        searchDealsPresenter.onSearchDeals(0,
                100100,
                "cat_ids",
                "subcat_ids",
                "district_ids",
                "bizarea_ids",
                location,
                keyword,
                MainFilter.instance().radius,
                MainFilter.instance().sort,
                page,
                PAGE_SIZE,
                is_reservation_required);
        you = 0;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return TransitionMode.RIGHT;
    }

    private void initFilterDropDownView() {
        String[] titleList = new String[]{"分类", "商圈", "排序", "距离"};
        mainDropMenuAdapter = new MainDropMenuAdapter(mContext, this, titleList);
        mainDropMenuAdapter.setDistrictsList(districts);
        mainDropMenuAdapter.setCategoriesList(categories);
        dropDownMenu.setMenuAdapter(mainDropMenuAdapter);
    }

    @Override
    public void onFilterDone(int position, String positionTitle, String urlValue) {
        if (position != 3) {
            dropDownMenu.setPositionIndicatorText(MainFilter.instance().position, MainFilter.instance().positionTitle);
        }
        dropDownMenu.close();


        initAdapter(searchDeals);

    }

    private void initAdapter(List<SearchDeals> searchDeals) {
        mainAdapter = new MainAdapter(searchDeals);
        mainAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        mainAdapter.setOnRecyclerViewItemChildClickListener(new BaseQuickAdapter.OnRecyclerViewItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                SearchDeals deals = (SearchDeals) adapter.getItem(position);
                switch (view.getId()) {
                    case R.id.deal_url:
                        Toast.makeText(MainActivity.this, deals.getDeal_url(), Toast.LENGTH_LONG).show();
                        break;
                    case R.id.shop_deals_title:
                        Toast.makeText(MainActivity.this, deals.getDeal_url(), Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
        mFilterContentView.setAdapter(mainAdapter);
    }


    @Override
    public void getCategories(List<Categories> categories) {
        this.categories = categories;
        if (you == 0) {
            you = you + 1;
        } else if (you == 1) {
            initFilterDropDownView();
        }
    }

    @Override
    public void getDistricts(List<Districts> districts) {
        this.districts = districts;
        if (you == 0) {
            you = you + 1;
        } else if (you == 1) {
            initFilterDropDownView();
        }
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMoreRequested() {

    }

    @Override
    public void refreshListData(SearchDealsData data) {
        mainAdapter.setNewData(data.getDeals());
        mainAdapter.openLoadMore(PAGE_SIZE, true);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void addMoreListData(SearchDealsData data) {
        if (page >= calculateTotalPages(data.getTotal())) {
            mainAdapter.notifyDataChangedAfterLoadMore(false);
            View view = getLayoutInflater().inflate(R.layout.not_loading, (ViewGroup) mFilterContentView.getParent(), false);
            mainAdapter.addFooterView(view);
        } else {
            mainAdapter.notifyDataChangedAfterLoadMore(data.getDeals(), true);
            //page= mainAdapter.getPageSize();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        you = 0;
        MainFilter.instance().clear();
    }
    //页码处理
    public int calculateTotalPages(int totalNumber) {
        if (totalNumber > 0) {
            return totalNumber % PAGE_SIZE != 0 ? (totalNumber / PAGE_SIZE + 1) : totalNumber / PAGE_SIZE;
        } else {
            return 0;
        }
    }

}
