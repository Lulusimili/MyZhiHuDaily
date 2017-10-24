package com.example.administrator.myzhihudaily.presenter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.administrator.myzhihudaily.MyApplication;
import com.example.administrator.myzhihudaily.adapter.NewsAdapter;
import com.example.administrator.myzhihudaily.bean.NewsBean;
import com.example.administrator.myzhihudaily.model.INewsListmodel;
import com.example.administrator.myzhihudaily.model.NewsListModel;
import com.example.administrator.myzhihudaily.util.IGetRequest;
import com.example.administrator.myzhihudaily.view.INewsList;
import com.example.administrator.myzhihudaily.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/21 0021.
 *
 */

public class NewsListPresenter implements INewsListPresenter {
    private INewsList mINewsList;
    private INewsListmodel mINewsListmodel;
    private NewsListPresenter newsListPresenter;
    public NewsListPresenter(INewsList view){
        mINewsList=view;
        mINewsListmodel=new NewsListModel(mINewsList.getBaseUrl());
    }
    public NewsListPresenter(){

    }
    @Override
    public void disPlay() {
        mINewsListmodel.loadNewsList(mINewsList.getRecyclerView());
    }

    @Override
    public NewsListPresenter getNesPresenter() {
        return mINewsList.getMPresenter();
    }

}
