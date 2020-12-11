package com.umeng.mylianxi.api;

import com.umeng.mylianxi.bean.ExBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface Service {
    String url="http://yun918.cn/";

    @GET("ks/jiekou1.json")
    Flowable<ExBean> getEx();
}
