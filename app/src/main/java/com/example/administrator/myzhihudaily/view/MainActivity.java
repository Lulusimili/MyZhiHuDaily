package com.example.administrator.myzhihudaily.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.administrator.myzhihudaily.R;
import com.example.administrator.myzhihudaily.adapter.NewsAdapter;
import com.example.administrator.myzhihudaily.bean.NewsBean;
import com.example.administrator.myzhihudaily.presenter.INewsListPresenter;
import com.example.administrator.myzhihudaily.presenter.NewsListPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements INewsList {
    private Toolbar toolbar;
    private NewsListPresenter mPresenter;
    private RecyclerView recyclerView;
    private String baseUrl="http://news-at.zhihu.com/";
    private List<NewsBean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        setSupportActionBar(toolbar);
        mPresenter.disPlay();
        //recyclerView.setAdapter(new NewsAdapter(mPresenter.getNewsBeanList(),this));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tollbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting:
                Toast.makeText(this,"You Click Settings!",Toast.LENGTH_SHORT).
                        show();
                break;
            case R.id.search:
                Toast.makeText(this,"You Click Search",Toast.LENGTH_SHORT).
                        show();
                break;
            default:
        }
        return true;
    }

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    @Override
    public NewsListPresenter getMPresenter() {
        return mPresenter;
    }

    private void init(){
        toolbar=(Toolbar)findViewById(R.id.tollbar);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        mPresenter=new NewsListPresenter(this);
    }
}

