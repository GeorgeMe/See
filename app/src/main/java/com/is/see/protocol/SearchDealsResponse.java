package com.is.see.protocol;

import com.is.see.entity.SearchDealsData;

import java.util.List;

/**
 * Created by George on 2016/6/14.
 */
public class SearchDealsResponse {

    private int errno;
    private String msg;

    private SearchDealsData data;

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

    public SearchDealsData getData() {
        return data;
    }

    public void setData(SearchDealsData data) {
        this.data = data;
    }


}
