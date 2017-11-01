package com.yhb.news.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.yhb.news.BroswerActivity;
import com.yhb.news.R;
import com.yhb.news.model.NewsCommonModel;
import com.yhb.news.utils.NewsUtil;

import java.util.List;

/**
 * Created by smk on 2017/10/13.
 */

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int CONTENT_ITEM = 1;
    private int FOOT_ITEM = 2;
    LayoutInflater inflater;
    List<NewsCommonModel> data;

    public NewsAdapter(Context context, List<NewsCommonModel> data) {

        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View view;
        if (viewType == CONTENT_ITEM) {
            view = inflater.inflate(R.layout.news_item, parent, false);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), BroswerActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("url", v.getTag().toString());
                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);

                }
            });
            viewHolder = new ContentViewHolder(view);
        } else {
            view = inflater.inflate(R.layout.news_foot_item, parent, false);
            viewHolder = new FootViewHolder(view);
        }
        return viewHolder;
    }

    //添加数据
    public int addItem(List<NewsCommonModel> newDatas) {
        int sum = 0;
        boolean hasNew = false;
        for (int i = newDatas.size() - 1; i >= 0; i--) {
            if (!data.contains(newDatas.get(i))) {
                data.add(0, newDatas.get(i));
                hasNew = true;
                sum++;
            }
        }
        if (hasNew) {
            notifyDataSetChanged();
        }
        return sum;
    }

    public void addMoreItem(List<NewsCommonModel> newDatas) {
        boolean hasNew = false;
        for (int i = newDatas.size() - 1; i >= 0; i--) {
            if (!data.contains(newDatas.get(i))) {
                data.add(data.size(), newDatas.get(i));
                hasNew = true;
            }
        }
        if (hasNew) {
            notifyDataSetChanged();
        }

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof ContentViewHolder) {
            final NewsCommonModel item = data.get(position);
            final ContentViewHolder contentViewHolder = (ContentViewHolder) holder;
            contentViewHolder.title.setText(item.getTitle());
            contentViewHolder.author.setText(item.getAuthor());
            contentViewHolder.date.setText(NewsUtil.publishTime(item.getDate()));
            contentViewHolder.itemView.setTag(item.getUrl());

            if (item.getImage() != null) {
                Glide.with(contentViewHolder.itemView.getContext()).asBitmap().load(item.getImage())
                        .transition(BitmapTransitionOptions.withCrossFade(500))
                        .into(contentViewHolder.thumb);
            }
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == data.size()) {
            return FOOT_ITEM;
        }
        return CONTENT_ITEM;
    }

    @Override
    public int getItemCount() {
        return data.size() + 1;
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView date;
        TextView author;
        ImageView thumb;

        public ContentViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            date = (TextView) itemView.findViewById(R.id.tv_date);
            author = (TextView) itemView.findViewById(R.id.tv_author);
            thumb = (ImageView) itemView.findViewById(R.id.iv_thumb);
        }
    }

    public static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View itemView) {
            super(itemView);
        }
    }
}

