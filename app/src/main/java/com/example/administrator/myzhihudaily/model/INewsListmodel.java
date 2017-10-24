package com.example.administrator.myzhihudaily.model;

import android.support.v7.widget.RecyclerView;

import com.example.administrator.myzhihudaily.bean.NewsBean;
import com.example.administrator.myzhihudaily.bean.RootNews;
import com.example.administrator.myzhihudaily.util.IGetRequest;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/20 0020.
 *
 */

public interface INewsListmodel {
     void loadNewsList(RecyclerView recyclerView);
     IGetRequest getRequest();
     ArrayList<NewsBean> getNewsList();
}
