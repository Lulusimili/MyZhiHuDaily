package com.example.administrator.myzhihudaily.model;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.myzhihudaily.MyApplication;
import com.example.administrator.myzhihudaily.adapter.NewsAdapter;
import com.example.administrator.myzhihudaily.bean.NewsBean;
import com.example.administrator.myzhihudaily.bean.RootNews;
import com.example.administrator.myzhihudaily.util.IGetRequest;
import com.example.administrator.myzhihudaily.util.NetworkRequestUtil;
import com.example.administrator.myzhihudaily.view.MainActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.example.administrator.myzhihudaily.MyApplication.getContext;

/**
 * Created by Administrator on 2017/10/21 0021.
 */

public class NewsListModel implements INewsListmodel {
    private ArrayList<NewsBean> mNewsBeanList=new ArrayList<>();
    @Override
    public IGetRequest getRequest(String baseUrl) {
        return NetworkRequestUtil.getRequest(baseUrl);
    }

    @Override
    public ArrayList<NewsBean> getNewsList() {
        return mNewsBeanList;
    }

    @Override
    public void LoadNewsList(rx.Observable<RootNews> rootNewsObservable,
                             final RecyclerView recyclerView) {
        rootNewsObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Func1<RootNews,ArrayList<NewsBean>>(){
                    @Override
                    public ArrayList<NewsBean> call(RootNews rootNews) {
                        return rootNews.getNewsBeenList();
                    }
                })
                .subscribe(new Subscriber<ArrayList<NewsBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ArrayList<NewsBean> newsBeenList) {
                          mNewsBeanList=newsBeenList;
//
//                      recyclerView.setAdapter(new NewsAdapter(newsBeenList, getContext()));
                    }

                });

    }
}
