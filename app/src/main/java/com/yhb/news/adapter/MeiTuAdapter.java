package com.yhb.news.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.yhb.news.R;
import com.yhb.news.model.MeiTuModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by smk on 2017/10/25.
 */

public class MeiTuAdapter extends RecyclerView.Adapter<MeiTuAdapter.ViewHolder> {
    private static final String TAG = "MeiTuAdapter";
    private List<MeiTuModel.HitsBean> data;
    private LayoutInflater inflater;

    public MeiTuAdapter(LayoutInflater inflater, List<MeiTuModel.HitsBean> data) {
        this.data = data;
        this.inflater = inflater;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.meitu_item, null);

        return new ViewHolder(view);
    }

    //http://www.jianshu.com/p/5761fa9b7414
    //http://blog.csdn.net/m0_38079174/article/details/70998973
    private Map<Integer, Integer> mHeights = new HashMap<>();

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (mHeights.containsKey(position)) {
            ViewGroup.LayoutParams layoutParams = holder.thumb.getLayoutParams();
            layoutParams.height = mHeights.get(position);
        }
        Glide.with(holder.itemView.getContext()).asBitmap().load(data.get(position).getPreviewURL())
                .transition(BitmapTransitionOptions.withCrossFade(500))
                .listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                        int imageViewWidth = getScreenWidth(inflater.getContext()) / 2;
                        int imageViewHeight = (int) ((double) imageViewWidth / resource.getWidth()) * resource.getHeight();
                        mHeights.put(position, imageViewHeight);
                        ViewGroup.LayoutParams layoutParams = holder.thumb.getLayoutParams();
                        layoutParams.height = imageViewHeight;
                        layoutParams.width = imageViewWidth;
                        return false;
                    }
                })
                .into(holder.thumb);

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
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageView thumb;

        public ViewHolder(View itemView) {
            super(itemView);

            thumb = (ImageView) itemView.findViewById(R.id.iv_thumb);

        }
    }
}
