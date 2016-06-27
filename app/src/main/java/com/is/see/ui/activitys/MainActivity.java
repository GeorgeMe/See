package com.is.see.ui.activitys;

import android.os.Bundle;
import android.widget.TextView;

import com.is.see.R;
import com.is.see.base.BaseActivity;
import com.is.see.entity.User;

import butterknife.Bind;

public class MainActivity extends BaseActivity {
    @Bind(R.id.tv_show)
    TextView tvShow;

    private String msg;

    @Override
    protected void getBundleExtras(Bundle extras) {
        msg = extras.getString("msg");
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewsAndEvents() {
        if(msg!=null){
            tvShow.setText(msg);
        }
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return TransitionMode.RIGHT;
    }
}
