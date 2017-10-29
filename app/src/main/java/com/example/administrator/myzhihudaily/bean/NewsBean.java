package com.example.administrator.myzhihudaily.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/10/20 0020.
 *
 */

public class NewsBean {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("images")
    private List<String> imagesUrl;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(List<String> imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getImageUrl() {
        return imagesUrl;
    }
}
