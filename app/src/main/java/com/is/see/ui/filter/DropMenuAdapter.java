package com.is.see.ui.filter;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;

import com.is.see.R;
import com.is.see.entity.Categories;
import com.is.see.entity.Subcategories;
import com.is.see.ui.filter.betterDoubleGrid.BetterDoubleGridView;
import com.is.see.ui.filter.doubleGrid.DoubleGridView;
import com.is.see.ui.filter.entity.FilterUrl;
import com.is.ui.filter.adapter.MenuAdapter;
import com.is.ui.filter.adapter.SimpleTextAdapter;
import com.is.ui.filter.interfaces.OnFilterDoneListener;
import com.is.ui.filter.interfaces.OnFilterItemClickListener;
import com.is.ui.filter.typeview.DoubleListView;
import com.is.ui.filter.typeview.SingleGridView;
import com.is.ui.filter.typeview.SingleListView;
import com.is.ui.filter.util.CommonUtil;
import com.is.ui.filter.util.UIUtil;
import com.is.ui.filter.view.FilterCheckedTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * author: baiiu
 * date: on 16/1/17 21:14
 * description:
 */
public class DropMenuAdapter implements MenuAdapter {
    private final Context mContext;
    private OnFilterDoneListener onFilterDoneListener;
    private String[] titles;

    public DropMenuAdapter(Context context, String[] titles, OnFilterDoneListener onFilterDoneListener) {
        this.mContext = context;
        this.titles = titles;
        this.onFilterDoneListener = onFilterDoneListener;
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
                view = createSingleListView();
                break;
            case 1:
                view = createDoubleListView();
                break;
            case 2:
                view = createSingleGridView();
                break;
            case 3:
                // view = createDoubleGrid();
                view = createBetterDoubleGrid();
                break;
        }

        return view;
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


    private View createDoubleListView() {
        DoubleListView<Categories, Subcategories> comTypeDoubleListView = new DoubleListView<Categories, Subcategories>(mContext)
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

                            FilterUrl.instance().position = 1;
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

                        FilterUrl.instance().position = 1;
                        FilterUrl.instance().positionTitle = subcategories.getSubcat_name();

                        onFilterDone();
                    }
                });


        List<Categories> list = new ArrayList<>();

        //第一项
        Categories filterType = new Categories();
        filterType.setCat_id(0);
        list.add(filterType);

        //第二项
        filterType = new Categories();
        filterType.setCat_id(1);
        List<Subcategories> childList = new ArrayList<>();
        for (int i = 0; i < 13; ++i) {
            Subcategories subcategories=new Subcategories();
            childList.add(subcategories);
        }
        filterType.setSubcategories(childList);
        list.add(filterType);

        //第三项
        filterType = new Categories();
        filterType.setCat_id(1);
        childList = new ArrayList<>();
        for (int i = 0; i < 13; ++i) {
            Subcategories subcategories=new Subcategories();
            childList.add(subcategories);
        }
        filterType.setSubcategories(childList);
        list.add(filterType);

        //初始化选中.
        comTypeDoubleListView.setLeftList(list, 1);
        comTypeDoubleListView.setRightList(list.get(1).getSubcategories(), -1);
        comTypeDoubleListView.getLeftListView().setBackgroundColor(mContext.getResources().getColor(R.color.b_c_fafafa));

        return comTypeDoubleListView;
    }


    private View createSingleGridView() {
        SingleGridView<String> singleGridView = new SingleGridView<String>(mContext)
                .adapter(new SimpleTextAdapter<String>(null, mContext) {
                    @Override
                    public String provideText(String s) {
                        return s;
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                        checkedTextView.setPadding(0, UIUtil.dp(context, 3), 0, UIUtil.dp(context, 3));
                        checkedTextView.setGravity(Gravity.CENTER);
                        checkedTextView.setBackgroundResource(R.drawable.selector_filter_grid);
                    }
                })
                .onItemClick(new OnFilterItemClickListener<String>() {
                    @Override
                    public void onItemClick(String item) {
                        FilterUrl.instance().singleGridPosition = item;

                        FilterUrl.instance().position = 2;
                        FilterUrl.instance().positionTitle = item;

                        onFilterDone();

                    }
                });

        List<String> list = new ArrayList<>();
        for (int i = 20; i < 39; ++i) {
            list.add(String.valueOf(i));
        }
        singleGridView.setList(list, -1);


        return singleGridView;
    }


    private View createBetterDoubleGrid() {

        List<String> phases = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            phases.add("3top" + i);
        }
        List<String> areas = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            areas.add("3bottom" + i);
        }


        return new BetterDoubleGridView(mContext)
                .setmTopGridData(phases)
                .setmBottomGridList(areas)
                .setOnFilterDoneListener(onFilterDoneListener)
                .build();
    }


    private View createDoubleGrid() {
        DoubleGridView doubleGridView = new DoubleGridView(mContext);
        doubleGridView.setOnFilterDoneListener(onFilterDoneListener);


        List<String> phases = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            phases.add("3top" + i);
        }
        doubleGridView.setTopGridData(phases);

        List<String> areas = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            areas.add("3bottom" + i);
        }
        doubleGridView.setBottomGridList(areas);

        return doubleGridView;
    }


    private void onFilterDone() {
        if (onFilterDoneListener != null) {
            onFilterDoneListener.onFilterDone(0, "", "");
        }
    }

}
