package com.is.see.protocol;

import com.is.see.entity.SearchShopsData;

/**
 * Created by George on 2016/6/14.
 */
public class SearchShopsResponse {


    private int errno;
    private String msg;

    private SearchShopsData data;

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

    public SearchShopsData getData() {
        return data;
    }

    public void setData(SearchShopsData data) {
        this.data = data;
    }


}
