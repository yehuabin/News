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
import com.yhb.news.model.TouTiao;

import java.util.List;

/**
 * Created by smk on 2017/10/13.
 */

public class TouTiaoAdapter extends RecyclerView.Adapter<TouTiaoAdapter.ViewHolder> {

    LayoutInflater inflater;
    List<TouTiao> data;

    public TouTiaoAdapter(Context context,   List<TouTiao> data) {

       this.data=data;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.toutiao_item, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), BroswerActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("url",v.getTag().toString());
                intent.putExtras(bundle);
                v.getContext().startActivity(intent);
            }
        });
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final   TouTiao item = data.get(position);
        holder.title.setText(item.getT());
        holder.author.setText(item.getF());
       // holder.date.setText(item.getP());
       // new ImageService(holder.thumb).execute(item.getThumbnail_pic_s());
        holder.itemView.setTag(item.getU());

        Glide.with(holder.itemView.getContext()).asBitmap().load(item.getI())
                .transition(BitmapTransitionOptions.withCrossFade(500))
               .into(holder.thumb);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView date;
        TextView author;
        ImageView thumb;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            date = (TextView) itemView.findViewById(R.id.tv_date);
            author = (TextView) itemView.findViewById(R.id.tv_author);
            thumb = (ImageView) itemView.findViewById(R.id.iv_thumb);
        }
    }
}

