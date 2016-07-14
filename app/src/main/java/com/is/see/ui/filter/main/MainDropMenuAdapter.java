package com.is.see.ui.filter.main;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import com.is.see.R;
import com.is.see.entity.BizAreas;
import com.is.see.entity.Categories;
import com.is.see.entity.Districts;
import com.is.see.entity.Subcategories;
import com.is.see.ui.filter.main.MainFilter;
import com.is.see.ui.filter.main.Radius;
import com.is.see.ui.filter.main.Sort;
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
                view=createSortListView();
                break;
            case 3:
                view=createRadiusListView();
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
                            MainFilter.instance().cat_id = categories.getCat_id();
                            MainFilter.instance().subcat_id = 0;

                            MainFilter.instance().position = 0;
                            MainFilter.instance().positionTitle = categories.getCat_name();

                            onFilterDone();
                        }
                        return child;
                    }
                }).onRightItemClickListener(new DoubleListView.OnRightItemClickListener<Categories, Subcategories>() {
                    @Override
                    public void onRightItemClick(Categories categories, Subcategories subcategories) {
                        MainFilter.instance().cat_id = categories.getCat_id();
                        MainFilter.instance().subcat_id = subcategories.getSubcat_id();

                        MainFilter.instance().position = 0;
                        MainFilter.instance().positionTitle = subcategories.getSubcat_name();

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
                            MainFilter.instance().district_id = districts.getDistrict_id();
                            MainFilter.instance().biz_area_id = 0;

                            MainFilter.instance().position = 1;
                            MainFilter.instance().positionTitle = districts.getDistrict_name();

                            onFilterDone();
                        }
                        return child;
                    }
                }).onRightItemClickListener(new DoubleListView.OnRightItemClickListener<Districts, BizAreas>() {
                    @Override
                    public void onRightItemClick(Districts districts, BizAreas bizAreas) {
                        MainFilter.instance().district_id = districts.getDistrict_id();
                        MainFilter.instance().biz_area_id = bizAreas.getBiz_area_id();

                        MainFilter.instance().position = 1;
                        MainFilter.instance().positionTitle = bizAreas.getBiz_area_name();

                        onFilterDone();
                    }
                });
        districtsDropMenu.setLeftList(list, 1);
        districtsDropMenu.setRightList(list.get(1).getBiz_areas(), -1);
        districtsDropMenu.getLeftListView().setBackgroundColor(mContext.getResources().getColor(R.color.b_c_fafafa));

        return districtsDropMenu;
    }

    private View createSortListView() {
        SingleListView<Sort> singleListView = new SingleListView<Sort>(mContext)
                .adapter(new SimpleTextAdapter<Sort>(null, mContext) {
                    @Override
                    public String provideText(Sort sort) {
                        return sort.getName();
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                        int dp = UIUtil.dp(mContext, 15);
                        checkedTextView.setPadding(dp, dp, 0, dp);
                    }
                })
                .onItemClick(new OnFilterItemClickListener<Sort>() {
                    @Override
                    public void onItemClick(Sort item) {
                        MainFilter.instance().sort = item.getSort();

                        MainFilter.instance().position = 2;
                        MainFilter.instance().positionTitle = item.getName();

                        onFilterDone();
                    }
                });

        List<Sort> list = new ArrayList<>();
        String[] strings=new String[]{"综合排序","价格低优先","价格高优先","折扣高优先","销量高优先","用户坐标距离近优先","最新发布优先","用户评分高优先"};
        for (int i = 0; i < 8; ++i) {
            Sort sort=new Sort();
            sort.setSort(i);
            sort.setName(strings[i]);
            list.add(sort);
        }
        singleListView.setList(list, -1);

        return singleListView;
    }

    private View createRadiusListView() {
        SingleListView<Radius> singleListView = new SingleListView<Radius>(mContext)
                .adapter(new SimpleTextAdapter<Radius>(null, mContext) {
                    @Override
                    public String provideText(Radius radius) {
                        return radius.getName();
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                        int dp = UIUtil.dp(mContext, 15);
                        checkedTextView.setPadding(dp, dp, 0, dp);
                    }
                })
                .onItemClick(new OnFilterItemClickListener<Radius>() {
                    @Override
                    public void onItemClick(Radius item) {
                        MainFilter.instance().radius = item.getRadius();

                        MainFilter.instance().position = 3;
                        MainFilter.instance().positionTitle = item.getName();

                        onFilterDone();
                    }
                });

        List<Radius> list = new ArrayList<>();
        int[] radius=new int[]{500,1000,3000,5000,10000};
        String[] names=new String[]{"500米","1000米","3000米","5000米","10000米"};
        for (int i = 0; i < 5; ++i) {
            Radius radius1=new Radius();
            radius1.setRadius(radius[i]);
            radius1.setName(names[i]);
            list.add(radius1);
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
