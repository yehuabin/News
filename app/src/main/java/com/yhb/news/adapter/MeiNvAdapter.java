package com.yhb.news.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yhb.news.R;
import com.yhb.news.model.MeiNvModel;

import java.util.List;

/**
 * Created by smk on 2017/10/25.
 */

public class MeiNvAdapter extends RecyclerView.Adapter<MeiNvAdapter.ViewHolder>  {
    private List<MeiNvModel.ShowapiResBodyBean.DataBean> data;
    private LayoutInflater inflater;

    public MeiNvAdapter( LayoutInflater inflater,List<MeiNvModel.ShowapiResBodyBean.DataBean> data) {
        this.data = data;
        this.inflater = inflater;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view=inflater.inflate(R.layout.meinv_item,null);

        return new ViewHolder(view);
    }
//http://www.jianshu.com/p/5761fa9b7414
    //http://blog.csdn.net/m0_38079174/article/details/70998973
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        Glide.with(holder.itemView.getContext()).load(data.get(position).getImgurl()).asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .placeholder(R.drawable.loading).into(holder.thumb);

        holder.title.setText(data.get(position).getTitle());
    }
    public static Bitmap zoomImg(Bitmap bm, int newWidth, int newHeight) {
        // 获得图片的宽高
        int width = bm.getWidth();
        int height = bm.getHeight();
        // 计算缩放比例
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
        return newbm;
    }
    //获取屏幕宽度的方法
    public static int getScreenWidth(Context context)
    {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

      public   TextView title;
      public   ImageView thumb;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);

            thumb = (ImageView) itemView.findViewById(R.id.iv_thumb);

        }
    }
}
