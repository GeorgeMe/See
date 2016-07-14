package com.is.see.protocol;

/**
 * Created by Administrator on 2016/6/27.
 */
public class BaseResponse<T> {
    public int code;
    public String msg;
    public T data;
}
