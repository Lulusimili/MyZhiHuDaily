package com.example.administrator.myzhihudaily.bean;

/**
 * Created by Administrator on 2017/10/20 0020.
 *
 */

public class NewsBean {
    private String title;
    private String imageUrl;
    //private String newsUrl;
    private int id;

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

//    public String getNewsUrl() {
//        return newsUrl;
//    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

//    public void setNewsUrl(String newsUrl) {
//        this.newsUrl = newsUrl;
//    }
}
