package com.is.see.protocol;

import com.is.see.entity.ShopDeals;

import java.util.List;

/**
 * Created by George on 2016/6/14.
 */
public class ShopDealsResponse {

    private int errno;
    private String msg;

    private List<ShopDeals> deals;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ShopDeals> getDeals() {
        return deals;
    }

    public void setDeals(List<ShopDeals> deals) {
        this.deals = deals;
    }

}
