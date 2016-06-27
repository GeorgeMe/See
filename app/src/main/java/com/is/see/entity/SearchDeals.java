package com.is.see.entity;

import java.util.List;

/**
 * Created by George on 2016/6/15.
 */
public class SearchDeals {

        private int deal_id;
        private String image;
        private String tiny_image;
        private String title;
        private String description;
        private int market_price;
        private int current_price;
        private int promotion_price;
        private int sale_num;
        private double score;
        private int comment_num;
        private int publish_time;
        private int purchase_deadline;
        private boolean is_reservation_required;
        private int distance;
        private int shop_num;
        private String deal_url;
        private String deal_murl;
        private List<ShopsInSearchDeals> shops;

        public int getDeal_id() {
            return deal_id;
        }

        public void setDeal_id(int deal_id) {
            this.deal_id = deal_id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTiny_image() {
            return tiny_image;
        }

        public void setTiny_image(String tiny_image) {
            this.tiny_image = tiny_image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getMarket_price() {
            return market_price;
        }

        public void setMarket_price(int market_price) {
            this.market_price = market_price;
        }

        public int getCurrent_price() {
            return current_price;
        }

        public void setCurrent_price(int current_price) {
            this.current_price = current_price;
        }

        public int getPromotion_price() {
            return promotion_price;
        }

        public void setPromotion_price(int promotion_price) {
            this.promotion_price = promotion_price;
        }

        public int getSale_num() {
            return sale_num;
        }

        public void setSale_num(int sale_num) {
            this.sale_num = sale_num;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public int getComment_num() {
            return comment_num;
        }

        public void setComment_num(int comment_num) {
            this.comment_num = comment_num;
        }

        public int getPublish_time() {
            return publish_time;
        }

        public void setPublish_time(int publish_time) {
            this.publish_time = publish_time;
        }

        public int getPurchase_deadline() {
            return purchase_deadline;
        }

        public void setPurchase_deadline(int purchase_deadline) {
            this.purchase_deadline = purchase_deadline;
        }

        public boolean isIs_reservation_required() {
            return is_reservation_required;
        }

        public void setIs_reservation_required(boolean is_reservation_required) {
            this.is_reservation_required = is_reservation_required;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getShop_num() {
            return shop_num;
        }

        public void setShop_num(int shop_num) {
            this.shop_num = shop_num;
        }

        public String getDeal_url() {
            return deal_url;
        }

        public void setDeal_url(String deal_url) {
            this.deal_url = deal_url;
        }

        public String getDeal_murl() {
            return deal_murl;
        }

        public void setDeal_murl(String deal_murl) {
            this.deal_murl = deal_murl;
        }

        public List<ShopsInSearchDeals> getShops() {
            return shops;
        }

        public void setShops(List<ShopsInSearchDeals> shops) {
            this.shops = shops;
        }

    }

