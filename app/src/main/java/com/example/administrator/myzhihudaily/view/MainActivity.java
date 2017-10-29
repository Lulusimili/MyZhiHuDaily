package com.example.administrator.myzhihudaily.view;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.example.administrator.myzhihudaily.R;
import com.example.administrator.myzhihudaily.adapter.NewsAdapter;
import com.example.administrator.myzhihudaily.adapter.PageAdapter;
import com.example.administrator.myzhihudaily.bean.NewsBean;
import com.example.administrator.myzhihudaily.presenter.INewsListPresenter;
import com.example.administrator.myzhihudaily.presenter.NewsListPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private Toolbar toolbar;
    private List<NewsBean> list;
    private ViewPager viewPager;
    private PagerSlidingTabStrip tab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        init();
//        setSupportActionBar(toolbar);
        init();
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager()));
        tab.setViewPager(viewPager);

    }
    private void init(){
        viewPager=(ViewPager)findViewById(R.id.pager);
        tab=(PagerSlidingTabStrip)findViewById(R.id.tab);
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.tollbar,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.setting:
//                Toast.makeText(this,"You Click Settings!",Toast.LENGTH_SHORT).
//                        show();
//                break;
//            case R.id.search:
//                Toast.makeText(this,"You Click Search",Toast.LENGTH_SHORT).
//                        show();
//                break;
//            default:
//        }
//        return true;
//    }


//    private void init(){
//        toolbar=findViewById(R.id.tollbar);
//    }
}

