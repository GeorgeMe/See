package com.is.see.protocol;

import com.is.see.entity.DealShops;

import java.util.List;

/**
 * Created by George on 2016/6/14.
 */
public class DealShopsResponse {

    private int errno;
    private String msg;

    private List<DealShops> shops;

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

    public List<DealShops> getShops() {
        return shops;
    }

    public void setShops(List<DealShops> shops) {
        this.shops = shops;
    }


}
