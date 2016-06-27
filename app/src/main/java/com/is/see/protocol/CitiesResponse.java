package com.is.see.protocol;

import com.is.see.entity.Cities;

import java.util.List;

/**
 * Created by George on 2016/6/14.
 */
public class CitiesResponse {

    private int errno;
    private String msg;
    private List<Cities> cities;

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

    public List<Cities> getCities() {
        return cities;
    }

    public void setCities(List<Cities> cities) {
        this.cities = cities;
    }

}
