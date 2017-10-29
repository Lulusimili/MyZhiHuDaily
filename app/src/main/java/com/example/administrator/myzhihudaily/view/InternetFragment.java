package com.example.administrator.myzhihudaily.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.administrator.myzhihudaily.R;
import com.example.administrator.myzhihudaily.presenter.INewsListPresenter;
import com.example.administrator.myzhihudaily.presenter.NewsListPresenter;


public class InternetFragment extends BaseFragment {
    private INewsListPresenter mPresenter;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView=view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        mPresenter=new NewsListPresenter(this,  observer.getInternet());
        mPresenter.disPlay();
    }
}
