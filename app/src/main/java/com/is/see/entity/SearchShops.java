package com.is.see.entity;

import java.util.List;

/**
 * Created by George on 2016/6/15.
 */
public class SearchShops {

        private int shop_id;
        private String shop_name;
        private double longitude;
        private double latitude;
        private int distance;
        private int deal_num;
        private String shop_url;
        private String shop_murl;
        private List<DealsInSearchShops> deals;

        public int getShop_id() {
            return shop_id;
        }

        public void setShop_id(int shop_id) {
            this.shop_id = shop_id;
        }

        public String getShop_name() {
            return shop_name;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
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

        public int getDeal_num() {
            return deal_num;
        }

        public void setDeal_num(int deal_num) {
            this.deal_num = deal_num;
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

        public List<DealsInSearchShops> getDeals() {
            return deals;
        }

        public void setDeals(List<DealsInSearchShops> deals) {
            this.deals = deals;
        }

    }

