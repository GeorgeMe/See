package com.is.see.protocol;

import com.is.see.entity.BizAreas;
import com.is.see.entity.Districts;

import java.util.List;

/**
 * Created by George on 2016/6/14.
 */
public class DistrictsResponse {

    private int errno;
    private String msg;

    private List<Districts> districts;

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

    public List<Districts> getDistricts() {
        return districts;
    }

    public void setDistricts(List<Districts> districts) {
        this.districts = districts;
    }

}
