package com.is.see.protocol;

import com.is.see.entity.Categories;

import java.util.List;

/**
 * Created by George on 2016/6/14.
 */
public class CategoriesResponse {

    private int errno;
    private String msg;

    private List<Categories> categories;

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

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }


}
