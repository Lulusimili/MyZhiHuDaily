package com.example.administrator.myzhihudaily.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.administrator.myzhihudaily.R;
import com.example.administrator.myzhihudaily.adapter.NewsAdapter;
import com.example.administrator.myzhihudaily.presenter.NewsListPresenter;

public class MainActivity extends AppCompatActivity implements INewsList {
    private Toolbar toolbar;
    private NewsListPresenter mPresenter;
    private RecyclerView recyclerView;
    private String baseUrl="http://news-at.zhihu.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("开始init","jjjjjj");
        init();
        //添加下面的两句会卡住没有任何反应
//        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
        setSupportActionBar(toolbar);
        recyclerView.setAdapter(new NewsAdapter(mPresenter.getNewsBeanList(),this));
        Log.d("结束","hhhhhh");
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
    private void init(){
        toolbar=(Toolbar)findViewById(R.id.tollbar);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        mPresenter=new NewsListPresenter(this);
    }
}

