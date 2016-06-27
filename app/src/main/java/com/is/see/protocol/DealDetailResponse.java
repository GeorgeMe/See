package com.is.see.protocol;

import com.is.see.entity.DealDetail;

import java.util.List;

/**
 * Created by George on 2016/6/14.
 */
public class DealDetailResponse {

    private int errno;
    private String msg;

    private DealDetail deal;

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

    public DealDetail getDeal() {
        return deal;
    }

    public void setDeal(DealDetail deal) {
        this.deal = deal;
    }


}
