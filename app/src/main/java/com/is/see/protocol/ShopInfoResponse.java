package com.is.see.protocol;

import com.is.see.entity.ShopInfo;

/**
 * Created by George on 2016/6/14.
 */
public class ShopInfoResponse {

    private int errno;
    private String msg;
    private ShopInfo shop;

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

    public ShopInfo getShop() {
        return shop;
    }

    public void setShop(ShopInfo shop) {
        this.shop = shop;
    }

}
