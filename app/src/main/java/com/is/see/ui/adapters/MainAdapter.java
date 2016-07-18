package com.is.see.ui.adapters;

import android.widget.ImageView;

import com.is.see.R;
import com.is.see.entity.SearchDeals;
import com.is.ui.adapter.BaseQuickAdapter;
import com.is.ui.adapter.BaseViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/7/18.
 */
public class MainAdapter extends BaseQuickAdapter<SearchDeals> {

    public MainAdapter(List<SearchDeals> data) {
        super(R.layout.main_shop_deals_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchDeals item) {
        helper.setText(R.id.shop_deals_title,item.getTitle())
                .setOnClickListener(R.id.shop_deals_title,new OnItemChildClickListener())
                .setOnClickListener(R.id.deal_url,new OnItemChildClickListener());
        Picasso.with(mContext).load(item.getImage()).into((ImageView)helper.getView(R.id.deal_url));
    }
}
