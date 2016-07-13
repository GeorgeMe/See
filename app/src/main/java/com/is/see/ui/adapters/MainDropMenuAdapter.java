package com.is.see.ui.adapters;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import com.is.see.R;
import com.is.see.entity.BizAreas;
import com.is.see.entity.Categories;
import com.is.see.entity.Districts;
import com.is.see.entity.Subcategories;
import com.is.see.ui.filter.entity.FilterUrl;
import com.is.ui.filter.adapter.MenuAdapter;
import com.is.ui.filter.adapter.SimpleTextAdapter;
import com.is.ui.filter.interfaces.OnFilterDoneListener;
import com.is.ui.filter.interfaces.OnFilterItemClickListener;
import com.is.ui.filter.typeview.DoubleListView;
import com.is.ui.filter.typeview.SingleListView;
import com.is.ui.filter.util.CommonUtil;
import com.is.ui.filter.util.UIUtil;
import com.is.ui.filter.view.FilterCheckedTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 */
public class MainDropMenuAdapter implements MenuAdapter{
    private final Context mContext;
    private OnFilterDoneListener onFilterDoneListener;
    private String[] titles;
    private List<Categories> categoriesList;
    private List<Districts> districtsList;
    public MainDropMenuAdapter(Context mContext, OnFilterDoneListener onFilterDoneListener, String[] titles) {
        this.mContext = mContext;
        this.onFilterDoneListener = onFilterDoneListener;
        this.titles = titles;
    }

    public void setDistrictsList(List<Districts> districtsList) {
        this.districtsList = districtsList;
    }

    public void setCategoriesList(List<Categories> categoriesList) {
        this.categoriesList = categoriesList;
    }

    @Override
    public int getMenuCount() {
        return titles.length;
    }

    @Override
    public String getMenuTitle(int position) {
        return titles[position];
    }

    @Override
    public int getBottomMargin(int position) {
        if (position == 3) {
            return 0;
        }

        return UIUtil.dp(mContext, 140);
    }

    @Override
    public View getView(int position, FrameLayout parentContainer) {
        View view = parentContainer.getChildAt(position);
        switch (position) {
            case 0:
                if (categoriesList!=null&&categoriesList.size()>0){
                    view = createCategoriesDropMenu(categoriesList);
                }
                break;
            case 1:
                if (districtsList!=null&&districtsList.size()>0){
                    view = createDistrictsDropMenu(districtsList);
                }
                break;
            case 2:
                view=createSingleListView();
                break;
            case 3:
                view=createSingleListView();
                break;
        }
        return view;
    }

    private View createCategoriesDropMenu(List<Categories> list){
        DoubleListView<Categories, Subcategories> categoriesDropMenu = new DoubleListView<Categories, Subcategories>(mContext)
                .leftAdapter(new SimpleTextAdapter<Categories>(null,mContext) {
                    @Override
                    public String provideText(Categories categories) {
                        return categories.getCat_name();
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                        checkedTextView.setPadding(UIUtil.dp(mContext, 44), UIUtil.dp(mContext, 15), 0, UIUtil.dp(mContext, 15));
                    }
                }).rightAdapter(new SimpleTextAdapter<Subcategories>(null,mContext) {
                    @Override
                    public String provideText(Subcategories subcategories) {
                        return subcategories.getSubcat_name();
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                        checkedTextView.setPadding(UIUtil.dp(mContext, 30), UIUtil.dp(mContext, 15), 0, UIUtil.dp(mContext, 15));
                        checkedTextView.setBackgroundResource(android.R.color.white);
                    }
                }).onLeftItemClickListener(new DoubleListView.OnLeftItemClickListener<Categories, Subcategories>() {
                    @Override
                    public List<Subcategories> provideRightList(Categories categories, int position) {
                        List<Subcategories> child=categories.getSubcategories();
                        if (CommonUtil.isEmpty(child)) {
                            FilterUrl.instance().doubleListLeft = categories.getCat_name();
                            FilterUrl.instance().doubleListRight = "";

                            FilterUrl.instance().position = 0;
                            FilterUrl.instance().positionTitle = categories.getCat_name();

                            onFilterDone();
                        }
                        return child;
                    }
                }).onRightItemClickListener(new DoubleListView.OnRightItemClickListener<Categories, Subcategories>() {
                    @Override
                    public void onRightItemClick(Categories categories, Subcategories subcategories) {
                        FilterUrl.instance().doubleListLeft = categories.getCat_name();
                        FilterUrl.instance().doubleListRight = subcategories.getSubcat_name();

                        FilterUrl.instance().position = 0;
                        FilterUrl.instance().positionTitle = subcategories.getSubcat_name();

                        onFilterDone();
                    }
                });
        categoriesDropMenu.setLeftList(list, 1);
        categoriesDropMenu.setRightList(list.get(1).getSubcategories(), -1);
        categoriesDropMenu.getLeftListView().setBackgroundColor(mContext.getResources().getColor(R.color.b_c_fafafa));

        return categoriesDropMenu;
    }
    private View createDistrictsDropMenu(List<Districts> list){
        DoubleListView<Districts, BizAreas> districtsDropMenu = new DoubleListView<Districts, BizAreas>(mContext)
                .leftAdapter(new SimpleTextAdapter<Districts>(null,mContext) {
                    @Override
                    public String provideText(Districts districts) {
                        return districts.getDistrict_name();
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                        checkedTextView.setPadding(UIUtil.dp(mContext, 44), UIUtil.dp(mContext, 15), 0, UIUtil.dp(mContext, 15));
                    }
                }).rightAdapter(new SimpleTextAdapter<BizAreas>(null,mContext) {
                    @Override
                    public String provideText(BizAreas bizAreas) {
                        return bizAreas.getBiz_area_name();
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                        checkedTextView.setPadding(UIUtil.dp(mContext, 30), UIUtil.dp(mContext, 15), 0, UIUtil.dp(mContext, 15));
                        checkedTextView.setBackgroundResource(android.R.color.white);
                    }
                }).onLeftItemClickListener(new DoubleListView.OnLeftItemClickListener<Districts, BizAreas>() {
                    @Override
                    public List<BizAreas> provideRightList(Districts districts, int position) {
                        List<BizAreas> child=districts.getBiz_areas();
                        if (CommonUtil.isEmpty(child)) {
                            FilterUrl.instance().doubleListLeft = districts.getDistrict_name();
                            FilterUrl.instance().doubleListRight = "";

                            FilterUrl.instance().position = 1;
                            FilterUrl.instance().positionTitle = districts.getDistrict_name();

                            onFilterDone();
                        }
                        return child;
                    }
                }).onRightItemClickListener(new DoubleListView.OnRightItemClickListener<Districts, BizAreas>() {
                    @Override
                    public void onRightItemClick(Districts districts, BizAreas bizAreas) {
                        FilterUrl.instance().doubleListLeft = districts.getDistrict_name();
                        FilterUrl.instance().doubleListRight = bizAreas.getBiz_area_name();

                        FilterUrl.instance().position = 1;
                        FilterUrl.instance().positionTitle = bizAreas.getBiz_area_name();

                        onFilterDone();
                    }
                });
        districtsDropMenu.setLeftList(list, 1);
        districtsDropMenu.setRightList(list.get(1).getBiz_areas(), -1);
        districtsDropMenu.getLeftListView().setBackgroundColor(mContext.getResources().getColor(R.color.b_c_fafafa));

        return districtsDropMenu;
    }

    private View createSingleListView() {
        SingleListView<String> singleListView = new SingleListView<String>(mContext)
                .adapter(new SimpleTextAdapter<String>(null, mContext) {
                    @Override
                    public String provideText(String string) {
                        return string;
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                        int dp = UIUtil.dp(mContext, 15);
                        checkedTextView.setPadding(dp, dp, 0, dp);
                    }
                })
                .onItemClick(new OnFilterItemClickListener<String>() {
                    @Override
                    public void onItemClick(String item) {
                        FilterUrl.instance().singleListPosition = item;

                        FilterUrl.instance().position = 0;
                        FilterUrl.instance().positionTitle = item;

                        onFilterDone();
                    }
                });

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            list.add("" + i);
        }
        singleListView.setList(list, -1);

        return singleListView;
    }


    private void onFilterDone() {
        if (onFilterDoneListener != null) {
            onFilterDoneListener.onFilterDone(0, "", "");
        }
    }

}
