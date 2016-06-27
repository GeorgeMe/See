package com.is.see.entity;

import java.util.List;

/**
 * Created by George on 2016/6/15.
 */
public class SearchDealsData {

    private int total;
    private List<SearchDeals> deals;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<SearchDeals> getDeals() {
        return deals;
    }

    public void setDeals(List<SearchDeals> deals) {
        this.deals = deals;
    }


}
