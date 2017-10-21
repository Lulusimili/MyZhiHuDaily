package com.example.administrator.myzhihudaily.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.administrator.myzhihudaily.MyApplication;
import com.example.administrator.myzhihudaily.R;
import com.example.administrator.myzhihudaily.bean.NewsBean;
import com.example.administrator.myzhihudaily.adapter.NewsAdapter;
import com.example.administrator.myzhihudaily.bean.RootNews;
import com.example.administrator.myzhihudaily.presenter.NewsListPresenter;
import com.example.administrator.myzhihudaily.util.IGetRequest;

import java.util.ArrayList;
import java.util.List;

import static com.example.administrator.myzhihudaily.MyApplication.getContext;

public class MainActivity extends AppCompatActivity implements INewsList {
    private Toolbar toolbar;
   // public List<NewsBean> newsBeanList=new ArrayList<>();
    private NewsListPresenter mPresenter;
    private RecyclerView recyclerView;
    private String baseUrl="http://news-at.zhihu.com/";
    private IGetRequest mObservable;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setSupportActionBar(toolbar);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        mPresenter.displayNews();
    }

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public IGetRequest getObserver() {
        return mObservable=mPresenter.setObserver();
    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    private void init(){
        toolbar=(Toolbar)findViewById(R.id.tollbar);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        mPresenter=new NewsListPresenter(this);
    }
}

