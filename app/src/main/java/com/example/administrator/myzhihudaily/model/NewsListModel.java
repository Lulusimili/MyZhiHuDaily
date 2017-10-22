package com.example.administrator.myzhihudaily.model;
import android.support.v7.widget.RecyclerView;
import android.util.Log;;
import com.example.administrator.myzhihudaily.bean.NewsBean;
import com.example.administrator.myzhihudaily.bean.RootNews;
import com.example.administrator.myzhihudaily.util.IGetRequest;
import com.example.administrator.myzhihudaily.util.NetworkRequestUtil;
import java.util.ArrayList;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Created by Administrator on 2017/10/21 0021.
 *
 */

public class NewsListModel implements INewsListmodel {

    private String baseUrl;
    private ArrayList<NewsBean> mNewsBeanList=new ArrayList<>();
    private rx.Observable<RootNews> rootNewsObservable;
    public NewsListModel(String baseUrl){
        this.baseUrl=baseUrl;
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
    public void LoadNewsList() {
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
                        mNewsBeanList=newsBeenList;
                        for (NewsBean newsBean:newsBeenList){
                            Log.d("8888888",newsBean.getTitle());
                        }
//                      recyclerView.setAdapter(new NewsAdapter(newsBeenList, getContext()));
                    }

                });

    }
}
