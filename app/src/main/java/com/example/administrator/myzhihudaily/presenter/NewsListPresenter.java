package com.example.administrator.myzhihudaily.presenter;

import android.view.View;

import com.example.administrator.myzhihudaily.MyApplication;
import com.example.administrator.myzhihudaily.adapter.NewsAdapter;
import com.example.administrator.myzhihudaily.model.INewsListmodel;
import com.example.administrator.myzhihudaily.model.NewsListModel;
import com.example.administrator.myzhihudaily.util.IGetRequest;
import com.example.administrator.myzhihudaily.view.INewsList;
import com.example.administrator.myzhihudaily.view.MainActivity;

import static com.example.administrator.myzhihudaily.MyApplication.getContext;

/**
 * Created by Administrator on 2017/10/21 0021.
 *
 */

public class NewsListPresenter {
    private INewsList mINewsList;
    private INewsListmodel mINewsListmodel;
    public NewsListPresenter(INewsList view){
        mINewsList=view;
        mINewsListmodel=new NewsListModel();
    }
    public void displayNews(){
        mINewsListmodel.LoadNewsList(mINewsList.getObserver().getLatestNews(),
                mINewsList.getRecyclerView());
        mINewsList.getRecyclerView().setAdapter(new NewsAdapter(mINewsListmodel.getNewsList(), getContext()));
    }
    public IGetRequest setObserver(){
        return mINewsListmodel.getRequest(mINewsList.getBaseUrl());
    }
}
