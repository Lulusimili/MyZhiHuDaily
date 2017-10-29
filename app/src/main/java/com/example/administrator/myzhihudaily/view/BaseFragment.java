package com.example.administrator.myzhihudaily.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myzhihudaily.R;
import com.example.administrator.myzhihudaily.bean.NewsBean;
import com.example.administrator.myzhihudaily.presenter.NewsListPresenter;
import com.example.administrator.myzhihudaily.util.IGetRequest;
import com.example.administrator.myzhihudaily.util.NetworkRequestUtil;

import java.util.List;


public class BaseFragment extends Fragment implements INewsList {
    public RecyclerView recyclerView;
    public IGetRequest observer;
    private String baseUrl="http://news-at.zhihu.com/";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
//        recyclerView=container.findViewById(R.id.recycler_view);
//        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(layoutManager);
        observer= NetworkRequestUtil.getRequest(baseUrl);
        return inflater.inflate(R.layout.base_page,container,false);
    }

    @Override
    public IGetRequest getObserver() {
        return observer;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
