package com.example.administrator.myzhihudaily.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myzhihudaily.R;
import com.example.administrator.myzhihudaily.bean.NewsBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2017/10/21 0021.
 *
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
    private List<NewsBean> mNewBeanList;
    private Context context;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView newsImage;
        TextView newsTitle;
        public ViewHolder(View view){
            super(view);
            newsImage=view.findViewById(R.id.news_image);
            newsTitle=view.findViewById(R.id.news_title);
        }

    }
    public NewsAdapter(List<NewsBean>newsBeenList, Context context){
        mNewBeanList=newsBeenList;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_items,null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsBean newsBean=mNewBeanList.get(position);
        holder.newsTitle.setText(newsBean.getTitle());
        Picasso
                .with(context)
                .load(newsBean.getImageUrl().get(0))
                .into(holder.newsImage);
    }

    @Override
    public int getItemCount() {
        return mNewBeanList.size();
    }
}
