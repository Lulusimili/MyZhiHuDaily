package com.example.administrator.myzhihudaily.util;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkRequestUtil {

    public static IGetRequest getRequest(String baseUrl) {
        //创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        // 创建 网络请求接口 的实例
       IGetRequest request = retrofit.create(IGetRequest.class);
        return request;
    }

}