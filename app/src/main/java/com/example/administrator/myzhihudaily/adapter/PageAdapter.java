package com.example.administrator.myzhihudaily.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import com.example.administrator.myzhihudaily.view.InterestFragment;
import com.example.administrator.myzhihudaily.view.InternetFragment;
import com.example.administrator.myzhihudaily.view.LatestFragment;
import com.example.administrator.myzhihudaily.view.SportFragment;

import java.util.ArrayList;
import java.util.List;

public class PageAdapter extends FragmentPagerAdapter {
    private final String[] title={"今日头条","今日趣闻","网络安全","体育新闻"};
    private List<Fragment> fragments=new ArrayList<Fragment>();
    public PageAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(new LatestFragment());
        fragments.add(new InterestFragment());
        fragments.add(new InternetFragment());
        fragments.add(new SportFragment());
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return 4;
    }

}
