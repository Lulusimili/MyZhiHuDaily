package com.example.administrator.myzhihudaily.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/21 0021.
 *
 */

public class RootNews {
    @SerializedName("stories")
    private ArrayList<NewsBean> newsBeenList ;
    public void setStories(ArrayList<NewsBean> newsBeenList){
        this.newsBeenList = newsBeenList;
    }
    public ArrayList<NewsBean> getNewsBeenList(){
        return this.newsBeenList;
    }
}
