package com.yhb.news.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yhb.news.BroswerActivity;
import com.yhb.news.R;
import com.yhb.news.model.TouTiao;

import java.util.List;

/**
 * Created by smk on 2017/10/13.
 */

public class TouTiaoAdapter extends RecyclerView.Adapter<TouTiaoAdapter.ViewHolder> {
    TouTiao result;
    LayoutInflater inflater;
    List<TouTiao.ResultBean.DataBean> data;

    public TouTiaoAdapter(Context context, TouTiao result) {
        this.result = result;
        data = result.getResult().getData();
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
                //Toast.makeText(v.getContext(), ""+v.getTag(), Toast.LENGTH_SHORT).show();
            }
        });
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
        if (holder.thumb.getTag(R.id.tag_asyc) instanceof AsyncTask)
        {
//            AsyncTask asyncTask= (AsyncTask<Void, Void, Bitmap>) holder.thumb.getTag(R.id.tag_asyc);
//            asyncTask.cancel(true);
//            Log.d(TAG, "onViewRecycled: ");
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        //holder.thumb.setImageResource((R.mipmap.ic_launcher));

        final TouTiao.ResultBean.DataBean item = data.get(position);
        holder.title.setText(item.getTitle());
        holder.author.setText(item.getAuthor_name());
        holder.date.setText(item.getDate());
       // new ImageService(holder.thumb).execute(item.getThumbnail_pic_s());
        holder.itemView.setTag(item.getUrl());

        Glide.with(holder.itemView.getContext()).load(item.getThumbnail_pic_s())
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .placeholder(R.mipmap.image_loading).crossFade().into(holder.thumb);
//        AsyncTask<Void, Void, Bitmap> asyncTask =  new AsyncTask<Void, Void, Bitmap>() {
//            @Override
//            protected Bitmap doInBackground(Void... params) {
//                try {
//                    URL url = new URL(item.getThumbnail_pic_s());
//                    Bitmap bitmap = BitmapFactory.decodeStream(url.openStream());
//                    return bitmap;
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Bitmap bitmap) {
//                super.onPostExecute(bitmap);
//                holder.thumb.setImageBitmap(bitmap);
//            }
//        };
//        holder.thumb.setTag(R.id.tag_asyc,asyncTask);
//        asyncTask.execute();

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

