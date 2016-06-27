package com.is.see.entity;

import java.util.List;

/**
 * Created by George on 2016/6/15.
 */
public class DealDetail {

    private int deal_id;
    private String title;
    private String min_title;
    private String description;
    private String long_title;
    private int publish_time;
    private int purchase_deadline;
    private int coupon_start_time;
    private int coupon_end_time;
    private int cat_id;
    private int market_price;
    private int current_price;
    private Object promotion_price;
    private int sale_num;
    private boolean is_reservation_required;
    private int person_upper;
    private int person_lower;
    private String image;
    private String mid_image;
    private String tiny_image;
    private String deal_url;
    private String deal_murl;
    private String buy_contents;
    private String buy_contents_json;
    private String consumer_tips;
    private String consumer_tips_json;
    private String buy_details;
    private String shop_description;
    private int update_time;
    private List<Integer> city_ids;
    private List<Integer> subcat_ids;
    private List<List<String>> consumer_tips_constructed;
    private List<Integer> shop_ids;

    public int getDeal_id() {
        return deal_id;
    }

    public void setDeal_id(int deal_id) {
        this.deal_id = deal_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMin_title() {
        return min_title;
    }

    public void setMin_title(String min_title) {
        this.min_title = min_title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLong_title() {
        return long_title;
    }

    public void setLong_title(String long_title) {
        this.long_title = long_title;
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

    public int getCoupon_start_time() {
        return coupon_start_time;
    }

    public void setCoupon_start_time(int coupon_start_time) {
        this.coupon_start_time = coupon_start_time;
    }

    public int getCoupon_end_time() {
        return coupon_end_time;
    }

    public void setCoupon_end_time(int coupon_end_time) {
        this.coupon_end_time = coupon_end_time;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
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

    public Object getPromotion_price() {
        return promotion_price;
    }

    public void setPromotion_price(Object promotion_price) {
        this.promotion_price = promotion_price;
    }

    public int getSale_num() {
        return sale_num;
    }

    public void setSale_num(int sale_num) {
        this.sale_num = sale_num;
    }

    public boolean isIs_reservation_required() {
        return is_reservation_required;
    }

    public void setIs_reservation_required(boolean is_reservation_required) {
        this.is_reservation_required = is_reservation_required;
    }

    public int getPerson_upper() {
        return person_upper;
    }

    public void setPerson_upper(int person_upper) {
        this.person_upper = person_upper;
    }

    public int getPerson_lower() {
        return person_lower;
    }

    public void setPerson_lower(int person_lower) {
        this.person_lower = person_lower;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMid_image() {
        return mid_image;
    }

    public void setMid_image(String mid_image) {
        this.mid_image = mid_image;
    }

    public String getTiny_image() {
        return tiny_image;
    }

    public void setTiny_image(String tiny_image) {
        this.tiny_image = tiny_image;
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

    public String getBuy_contents() {
        return buy_contents;
    }

    public void setBuy_contents(String buy_contents) {
        this.buy_contents = buy_contents;
    }

    public String getBuy_contents_json() {
        return buy_contents_json;
    }

    public void setBuy_contents_json(String buy_contents_json) {
        this.buy_contents_json = buy_contents_json;
    }

    public String getConsumer_tips() {
        return consumer_tips;
    }

    public void setConsumer_tips(String consumer_tips) {
        this.consumer_tips = consumer_tips;
    }

    public String getConsumer_tips_json() {
        return consumer_tips_json;
    }

    public void setConsumer_tips_json(String consumer_tips_json) {
        this.consumer_tips_json = consumer_tips_json;
    }

    public String getBuy_details() {
        return buy_details;
    }

    public void setBuy_details(String buy_details) {
        this.buy_details = buy_details;
    }

    public String getShop_description() {
        return shop_description;
    }

    public void setShop_description(String shop_description) {
        this.shop_description = shop_description;
    }

    public int getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(int update_time) {
        this.update_time = update_time;
    }

    public List<Integer> getCity_ids() {
        return city_ids;
    }

    public void setCity_ids(List<Integer> city_ids) {
        this.city_ids = city_ids;
    }

    public List<Integer> getSubcat_ids() {
        return subcat_ids;
    }

    public void setSubcat_ids(List<Integer> subcat_ids) {
        this.subcat_ids = subcat_ids;
    }

    public List<List<String>> getConsumer_tips_constructed() {
        return consumer_tips_constructed;
    }

    public void setConsumer_tips_constructed(List<List<String>> consumer_tips_constructed) {
        this.consumer_tips_constructed = consumer_tips_constructed;
    }

    public List<Integer> getShop_ids() {
        return shop_ids;
    }

    public void setShop_ids(List<Integer> shop_ids) {
        this.shop_ids = shop_ids;
    }
}
