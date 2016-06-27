package com.is.see.base;

import com.is.see.mvp.view.BaseView;
import com.is.ui.base.BaseLazyFragment;

/**
 *
 */
public abstract class BaseFragment extends BaseLazyFragment implements BaseView {

    @Override
    public void showError(String msg) {
    }

    @Override
    public void showException(String msg) {
    }


    @Override
    public void showLoading(String msg) {
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void showToast(String msg) {

    }
}
