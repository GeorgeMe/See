package com.is.see.entity;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by George on 2016/6/15.
 */
public class ShopInfo extends SugarRecord implements Serializable {
    private int shop_id;
    private int city_id;
    private String shop_name;
    private String shop_url;
    private String shop_murl;
    private String address;
    private int district_id;
    private int bizarea_id;
    private String phone;
    private String open_time;
    private double longitude;
    private double latitude;
    private double baidu_longitude;
    private double baidu_latitude;
    private String traffic_info;
    private int update_time;

    public ShopInfo(int shop_id, int city_id, String shop_name, String shop_url, String shop_murl, String address, int district_id, int bizarea_id, String phone, String open_time, double longitude, double latitude, double baidu_longitude, double baidu_latitude, String traffic_info, int update_time) {
        this.shop_id = shop_id;
        this.city_id = city_id;
        this.shop_name = shop_name;
        this.shop_url = shop_url;
        this.shop_murl = shop_murl;
        this.address = address;
        this.district_id = district_id;
        this.bizarea_id = bizarea_id;
        this.phone = phone;
        this.open_time = open_time;
        this.longitude = longitude;
        this.latitude = latitude;
        this.baidu_longitude = baidu_longitude;
        this.baidu_latitude = baidu_latitude;
        this.traffic_info = traffic_info;
        this.update_time = update_time;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_url() {
        return shop_url;
    }

    public void setShop_url(String shop_url) {
        this.shop_url = shop_url;
    }

    public String getShop_murl() {
        return shop_murl;
    }

    public void setShop_murl(String shop_murl) {
        this.shop_murl = shop_murl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    public int getBizarea_id() {
        return bizarea_id;
    }

    public void setBizarea_id(int bizarea_id) {
        this.bizarea_id = bizarea_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpen_time() {
        return open_time;
    }

    public void setOpen_time(String open_time) {
        this.open_time = open_time;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getBaidu_longitude() {
        return baidu_longitude;
    }

    public void setBaidu_longitude(double baidu_longitude) {
        this.baidu_longitude = baidu_longitude;
    }

    public double getBaidu_latitude() {
        return baidu_latitude;
    }

    public void setBaidu_latitude(double baidu_latitude) {
        this.baidu_latitude = baidu_latitude;
    }

    public String getTraffic_info() {
        return traffic_info;
    }

    public void setTraffic_info(String traffic_info) {
        this.traffic_info = traffic_info;
    }

    public int getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(int update_time) {
        this.update_time = update_time;
    }
}
