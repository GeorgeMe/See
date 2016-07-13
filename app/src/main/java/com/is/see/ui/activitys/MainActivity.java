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
import com.is.see.ui.adapters.MainDropMenuAdapter;
import com.is.see.ui.filter.entity.FilterUrl;
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
        String[] titleList = new String[]{"第一个", "第二个", "第三个", "第四个"};
        mainDropMenuAdapter=new MainDropMenuAdapter(mContext,this,titleList);
        mainDropMenuAdapter.setDistrictsList(districts);
        mainDropMenuAdapter.setCategoriesList(categories);
        dropDownMenu.setMenuAdapter(mainDropMenuAdapter);
    }
    @Override
    public void onFilterDone(int position, String positionTitle, String urlValue) {
        if (position != 3) {
            dropDownMenu.setPositionIndicatorText(FilterUrl.instance().position, FilterUrl.instance().positionTitle);
        }
        dropDownMenu.close();
        mFilterContentView.setText(FilterUrl.instance().toString());
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
        FilterUrl.instance().clear();
    }
}
