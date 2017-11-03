package com.yhb.news.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yhb.news.BroswerActivity;
import com.yhb.news.R;
import com.yhb.news.model.GenTieModel;
import com.yhb.news.utils.ConstantUtil;

import java.util.List;

import static com.yhb.news.utils.ConstantUtil.CONTENT_ITEM;

/**
 * Created by Administrator on 2017/11/2.
 */

public class GenTieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    LayoutInflater inflater;
    List<GenTieModel> data;

    public GenTieAdapter(LayoutInflater inflater, List<GenTieModel> data) {

        this.data = data;
        this.inflater = inflater;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View view;
        if (viewType == CONTENT_ITEM) {
            view = inflater.inflate(R.layout.joke_item, parent, false);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), BroswerActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("url", v.getTag().toString());
                    bundle.putString("source","GenTie");
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

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof ContentViewHolder) {
            final GenTieModel item = data.get(position);
            final ContentViewHolder contentViewHolder = (ContentViewHolder) holder;
            contentViewHolder.title.setText(item.getThread().getTitle());

            contentViewHolder.itemView.setTag(item.getThread().getUrl());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(inflater.getContext());
            contentViewHolder.rv_comments.setItemAnimator(new DefaultItemAnimator());
            contentViewHolder.rv_comments.setLayoutManager(linearLayoutManager);
            contentViewHolder.rv_comments.setAdapter(new GenTieCommentAdapter(inflater, item.getComments()));
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == data.size()) {
            return ConstantUtil.FOOT_ITEM;
        }
        return ConstantUtil.CONTENT_ITEM;
    }

    @Override
    public int getItemCount() {
        return data.size() + 1;
    }

    //添加数据
    public int addItem(List<GenTieModel> newDatas) {
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

    public void addMoreItem(List<GenTieModel> newDatas) {

        data.addAll(newDatas);

        notifyDataSetChanged();

    }


    public static class ContentViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        RecyclerView rv_comments;

        public ContentViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            rv_comments = (RecyclerView) itemView.findViewById(R.id.rv_comments);

        }
    }

    public static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View itemView) {
            super(itemView);
        }
    }
}
