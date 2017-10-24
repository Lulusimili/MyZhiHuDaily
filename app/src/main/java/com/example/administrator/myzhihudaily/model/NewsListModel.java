package com.example.administrator.myzhihudaily.model;
import android.support.v7.widget.RecyclerView;
import android.util.Log;;
import com.example.administrator.myzhihudaily.adapter.NewsAdapter;
import com.example.administrator.myzhihudaily.bean.NewsBean;
import com.example.administrator.myzhihudaily.bean.RootNews;
import com.example.administrator.myzhihudaily.presenter.INewsListPresenter;
import com.example.administrator.myzhihudaily.presenter.NewsListPresenter;
import com.example.administrator.myzhihudaily.util.IGetRequest;
import com.example.administrator.myzhihudaily.util.NetworkRequestUtil;
import com.example.administrator.myzhihudaily.view.INewsList;

import java.util.ArrayList;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.example.administrator.myzhihudaily.MyApplication.getContext;


/**
 * Created by Administrator on 2017/10/21 0021.
 *
 */

public class NewsListModel implements INewsListmodel {

    private String baseUrl;
    private ArrayList<NewsBean> mNewsBeanList=new ArrayList<>();
    public rx.Observable<RootNews> rootNewsObservable;
    private INewsListPresenter mPresenter=new NewsListPresenter();
    public NewsListModel(String baseUrl){
        this.baseUrl=baseUrl;
        rootNewsObservable=NetworkRequestUtil.getRequest(baseUrl).getLatestNews();
    }
    @Override
    public IGetRequest getRequest() {
        return NetworkRequestUtil.getRequest(baseUrl);
    }

    @Override
    public ArrayList<NewsBean> getNewsList() {
        return mNewsBeanList;
    }

    @Override
    public void loadNewsList(final RecyclerView recyclerView) {
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
                        Log.d("TAG","onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TAG","onError");
                    }

                    @Override
                    public void onNext(ArrayList<NewsBean> newsBeenList) {
                        recyclerView.setAdapter(new NewsAdapter(newsBeenList,getContext()));
                        Log.d("hhhhhhh",newsBeenList.toString());
                    }

                });

    }
}
