package com.is.see.entity;

import java.util.List;

/**
 * Created by George on 2016/6/15.
 */
public class SearchShopsData {

        private int total;
        private List<SearchShops> shops;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<SearchShops> getShops() {
            return shops;
        }

        public void setShops(List<SearchShops> shops) {
            this.shops = shops;
        }

    }
