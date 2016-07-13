package com.is.see.entity;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by George on 2016/6/15.
 */
public class ShopsInSearchDeals extends SugarRecord implements Serializable {

        private int shop_id;
        private double longitude;
        private double latitude;
        private int distance;
        private String shop_url;
        private String shop_murl;

    public ShopsInSearchDeals(int shop_id, double longitude, double latitude, int distance, String shop_url, String shop_murl) {
        this.shop_id = shop_id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.distance = distance;
        this.shop_url = shop_url;
        this.shop_murl = shop_murl;
    }

    public int getShop_id() {
            return shop_id;
        }

        public void setShop_id(int shop_id) {
            this.shop_id = shop_id;
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

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
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
    }

