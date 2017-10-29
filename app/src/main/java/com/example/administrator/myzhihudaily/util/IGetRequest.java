package com.example.administrator.myzhihudaily.util;

import android.database.Observable;

import com.example.administrator.myzhihudaily.bean.RootNews;

import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/10/21 0021.
 *网络请求接口
 */

public interface IGetRequest {
    @GET("/api/4/news/latest")
    rx.Observable<RootNews> getLatestNews();

    @GET("/api/4/theme/10")
    rx.Observable<RootNews> getInternet();

    @GET("/api/4/theme/11")
    rx.Observable<RootNews> getInterest();

    @GET("/api/4/theme/8")
    rx.Observable<RootNews> getSport();
}
