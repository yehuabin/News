package com.yhb.news.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yhb.news.R;
import com.yhb.news.model.GenTieModel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2017/11/2.
 */

public class GenTieCommentAdapter extends RecyclerView.Adapter<GenTieCommentAdapter.ViewHolder>  {
    LayoutInflater inflater;
    List<GenTieModel.CommentsBean> data;

    public GenTieCommentAdapter(LayoutInflater inflater, List<GenTieModel.CommentsBean> data) {
        this.inflater =inflater;
        Collections.sort(data, new Comparator<GenTieModel.CommentsBean>() {
            @Override
            public int compare(GenTieModel.CommentsBean o1, GenTieModel.CommentsBean o2) {
                return o1.getBuildLevel()>o2.getBuildLevel()?1:-1;
            }
        });
        this.data = data;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(data.get(position).getContent());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.gentie_comment,null);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.tv_comment);
        }
    }
}
