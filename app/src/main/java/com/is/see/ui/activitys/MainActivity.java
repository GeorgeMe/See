package com.is.see.ui.activitys;

import android.os.Bundle;
import android.widget.TextView;

import com.is.see.R;
import com.is.see.base.BaseActivity;
import com.is.see.ui.filter.DropMenuAdapter;
import com.is.see.ui.filter.entity.FilterUrl;
import com.is.ui.filter.DropDownMenu;
import com.is.ui.filter.interfaces.OnFilterDoneListener;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements OnFilterDoneListener {

    @Bind(R.id.dropDownMenu)
    DropDownMenu dropDownMenu;

    @Bind(R.id.mFilterContentView)
    TextView mFilterContentView;

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewsAndEvents() {
        initFilterDropDownView();
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return TransitionMode.RIGHT;
    }

    private void initFilterDropDownView() {
        String[] titleList = new String[]{"第一个", "第二个", "第三个", "第四个"};
        dropDownMenu.setMenuAdapter(new DropMenuAdapter(this, titleList, this));
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
    protected void onDestroy() {
        super.onDestroy();
        FilterUrl.instance().clear();
    }
}
