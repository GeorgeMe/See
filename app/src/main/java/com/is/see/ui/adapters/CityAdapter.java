package com.is.see.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.yokeyword.indexablelistview.IndexableAdapter;

import com.is.see.R;
import com.is.see.entity.Cities;

/**
 * Created by YoKeyword on 16/3/20.
 */
public class CityAdapter extends IndexableAdapter<Cities> {
    private Context mContext;

    public CityAdapter(Context context) {
        mContext = context;
    }

    @Override
    protected TextView onCreateTitleViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_tv_title_city, parent, false);
        return (TextView) view.findViewById(R.id.tv_title);
    }

    @Override
    protected ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_city, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(ViewHolder holder, Cities cityEntity) {
        CityViewHolder cityViewHolder = (CityViewHolder) holder;
        cityViewHolder.tvCity.setText(cityEntity.getName());
    }


    class CityViewHolder extends ViewHolder {
        TextView tvCity;

        public CityViewHolder(View view) {
            super(view);
            tvCity = (TextView) view.findViewById(R.id.tv_name);
        }
    }
}