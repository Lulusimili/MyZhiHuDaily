package com.example.administrator.myzhihudaily.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.myzhihudaily.bean.RootNews;
import com.example.administrator.myzhihudaily.presenter.INewsListPresenter;
import com.example.administrator.myzhihudaily.presenter.NewsListPresenter;
import com.example.administrator.myzhihudaily.util.IGetRequest;

/**
 * Created by Administrator on 2017/10/21 0021.
 *
 */

public interface INewsList {
         IGetRequest getObserver();
         RecyclerView getRecyclerView();

}
