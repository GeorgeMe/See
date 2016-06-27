package com.is.see.protocol;

import com.is.see.entity.SearchShopsData;

import java.util.List;

/**
 * Created by George on 2016/6/14.
 */
public class SearchShopsResponse {

    /**
     * errno : 0
     * msg : success
     * data : {"total":2,"shops":[{"shop_id":114733,"shop_name":"俏江南(东方广场)","longitude":116.418993,"latitude":39.915597,"distance":-1,"deal_num":5,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=c57ffbcff1403c460cb3e29964dcbd69&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F114733","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=c57ffbcff1403c460cb3e29964dcbd69&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F114733","deals":[{"deal_id":3612192,"image":"http://e.hiphotos.baidu.com/bainuo/crop%3D0%2C0%2C720%2C436%3Bw%3D720%3Bq%3D99/sign=e70905358726cffc7d65e5f2843166a0/e1fe9925bc315c6064e4184388b1cb134954772c.jpg","tiny_image":"http://e.hiphotos.baidu.com/bainuo/crop%3D0%2C0%2C720%2C436%3Bw%3D230%3Bq%3D99/sign=13e5c4bacafc1e17e9f0d67177a0da33/e1fe9925bc315c6064e4184388b1cb134954772c.jpg","title":"俏江南","description":"100元代金券！节假日通用！需提前1天预约！可叠加使用！","market_price":10000,"current_price":7500,"promotion_price":7500,"sale_num":13395,"score":4.51,"comment_num":350,"deal_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=c57ffbcff1403c460cb3e29964dcbd69&url=http%3A%2F%2Fbj.nuomi.com%2Fdeal%2Fcz1r1mkc.html","deal_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=c57ffbcff1403c460cb3e29964dcbd69&url=http%3A%2F%2Fm.nuomi.com%2Fbj%2Fdeal%2Fcz1r1mkc"}]}]}
     */

    private int errno;
    private String msg;
    /**
     * total : 2
     * shops : [{"shop_id":114733,"shop_name":"俏江南(东方广场)","longitude":116.418993,"latitude":39.915597,"distance":-1,"deal_num":5,"shop_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=c57ffbcff1403c460cb3e29964dcbd69&url=http%3A%2F%2Fwww.nuomi.com%2Fshop%2F114733","shop_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=c57ffbcff1403c460cb3e29964dcbd69&url=http%3A%2F%2Fm.nuomi.com%2Fmerchant%2F114733","deals":[{"deal_id":3612192,"image":"http://e.hiphotos.baidu.com/bainuo/crop%3D0%2C0%2C720%2C436%3Bw%3D720%3Bq%3D99/sign=e70905358726cffc7d65e5f2843166a0/e1fe9925bc315c6064e4184388b1cb134954772c.jpg","tiny_image":"http://e.hiphotos.baidu.com/bainuo/crop%3D0%2C0%2C720%2C436%3Bw%3D230%3Bq%3D99/sign=13e5c4bacafc1e17e9f0d67177a0da33/e1fe9925bc315c6064e4184388b1cb134954772c.jpg","title":"俏江南","description":"100元代金券！节假日通用！需提前1天预约！可叠加使用！","market_price":10000,"current_price":7500,"promotion_price":7500,"sale_num":13395,"score":4.51,"comment_num":350,"deal_url":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=c57ffbcff1403c460cb3e29964dcbd69&url=http%3A%2F%2Fbj.nuomi.com%2Fdeal%2Fcz1r1mkc.html","deal_murl":"http://www.nuomi.com/cps/redirect?cid=openapi&app_id=c57ffbcff1403c460cb3e29964dcbd69&url=http%3A%2F%2Fm.nuomi.com%2Fbj%2Fdeal%2Fcz1r1mkc"}]}]
     */

    private SearchShopsData data;

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

    public SearchShopsData getData() {
        return data;
    }

    public void setData(SearchShopsData data) {
        this.data = data;
    }


}
