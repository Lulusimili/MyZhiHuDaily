package com.example.administrator.myzhihudaily.presenter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.administrator.myzhihudaily.MyApplication;
import com.example.administrator.myzhihudaily.adapter.NewsAdapter;
import com.example.administrator.myzhihudaily.bean.NewsBean;
import com.example.administrator.myzhihudaily.bean.RootNews;
import com.example.administrator.myzhihudaily.model.INewsListmodel;
import com.example.administrator.myzhihudaily.model.NewsListModel;
import com.example.administrator.myzhihudaily.util.IGetRequest;
import com.example.administrator.myzhihudaily.view.INewsList;
import com.example.administrator.myzhihudaily.view.MainActivity;

import java.util.ArrayList;
import java.util.List;


public class NewsListPresenter implements INewsListPresenter {
    private INewsList mINewsList;
    private INewsListmodel mINewsListmodel;
    public NewsListPresenter(INewsList view, rx.Observable<RootNews> rootNewsObservable){
        mINewsList=view;
        mINewsListmodel=new NewsListModel(rootNewsObservable);
    }

    @Override
    public void disPlay() {
        mINewsListmodel.loadNewsList(mINewsList.getRecyclerView());
    }

}
