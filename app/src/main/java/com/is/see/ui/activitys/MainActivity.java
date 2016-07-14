package com.is.see.ui.activitys;

import android.os.Bundle;
import android.widget.TextView;

import com.is.see.R;
import com.is.see.base.BaseActivity;
import com.is.see.entity.Categories;
import com.is.see.entity.Districts;
import com.is.see.mvp.presenter.CategoriesPresenterImpl;
import com.is.see.mvp.presenter.DistrictsPresenterImpl;
import com.is.see.mvp.view.CategoriesView;
import com.is.see.mvp.view.DistrictsView;
import com.is.see.ui.filter.main.MainDropMenuAdapter;
import com.is.see.ui.filter.main.MainFilter;
import com.is.ui.filter.DropDownMenu;
import com.is.ui.filter.interfaces.OnFilterDoneListener;

import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements OnFilterDoneListener,CategoriesView,DistrictsView {

    @Bind(R.id.dropDownMenu)
    DropDownMenu dropDownMenu;

    @Bind(R.id.mFilterContentView)
    TextView mFilterContentView;
    private CategoriesPresenterImpl categoriesPresenter;
    private DistrictsPresenterImpl districtsPresenter;
    private List<Categories> categories;
    private List<Districts> districts;
    private MainDropMenuAdapter mainDropMenuAdapter;
    int you;

    private String location;
    private String keyword;
    private int page=1;
    private int page_size=1;
    private int is_reservation_required=1;

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewsAndEvents() {
        categoriesPresenter=new CategoriesPresenterImpl(mContext,this);
        districtsPresenter=new DistrictsPresenterImpl(mContext,this);
        categoriesPresenter.getCategories();
        districtsPresenter.getDistricts(100010000);
        you=0;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return TransitionMode.RIGHT;
    }

    private void initFilterDropDownView() {
        String[] titleList = new String[]{"分类", "商圈", "排序", "距离"};
        mainDropMenuAdapter=new MainDropMenuAdapter(mContext,this,titleList);
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

        mFilterContentView.setText(MainFilter.instance().toString());
    }

    @Override
    public void getCategories(List<Categories> categories) {
        this.categories=categories;
        if (you==0){
            you=you+1;
        }else if (you==1){
            initFilterDropDownView();
        }
    }

    @Override
    public void getDistricts(List<Districts> districts) {
        this.districts=districts;
        if (you==0){
            you=you+1;
        }else if (you==1){
            initFilterDropDownView();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        you=0;
        MainFilter.instance().clear();
    }
}
