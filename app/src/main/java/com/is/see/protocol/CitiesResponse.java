package com.is.see.protocol;

import com.is.see.entity.Cities;

import java.util.ArrayList;
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
        List<Cities> temp=new ArrayList<>();
        if (cities!=null&&cities.size()>0){
            for (int i=0;i<cities.size();i++){
                Cities city=new Cities(cities.get(i).getCity_name(),cities.get(i).getCity_id(),cities.get(i).getCity_name(),cities.get(i).getShort_name(),cities.get(i).getCity_pinyin(),cities.get(i).getCity_pinyin());
                temp.add(city);
            }
        }
        return temp;
    }

    public void setCities(List<Cities> cities) {
        this.cities = cities;
    }

}
