package com.yhb.news.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
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
import com.yhb.news.BigImageActivity;
import com.yhb.news.R;
import com.yhb.news.model.MeiTuModel;
import com.yhb.news.utils.ConstantUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.yhb.news.utils.ConstantUtil.CONTENT_ITEM;

/**
 * Created by smk on 2017/10/25.
 */

public class MeiTuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "MeiTuAdapter";
    private List<MeiTuModel.ResultsBean> data;
    private LayoutInflater inflater;

    public MeiTuAdapter(LayoutInflater inflater, List<MeiTuModel.ResultsBean> data) {
        this.data = data;
        this.inflater = inflater;
    }


    @Override
    public int getItemCount() {
        return data.size() + 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View view;
        if (viewType == CONTENT_ITEM) {
            view = inflater.inflate(R.layout.meitu_item, parent, false);
            viewHolder = new ContentViewHolder(view);
        } else {
            view = inflater.inflate(R.layout.foot_loadmore_item, parent, false);
            viewHolder = new FootViewHolder(view);
        }
        return viewHolder;
    }

    //http://www.jianshu.com/p/5761fa9b7414
    //http://blog.csdn.net/m0_38079174/article/details/70998973
    private Map<Integer, Integer> mHeights = new HashMap<>();

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ContentViewHolder) {
            final ContentViewHolder contentViewHolder=(ContentViewHolder)holder;
            if (mHeights.containsKey(position)) {
                ViewGroup.LayoutParams layoutParams = contentViewHolder.thumb.getLayoutParams();
                layoutParams.height = mHeights.get(position);
            }
            contentViewHolder.thumb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(inflater.getContext(), BigImageActivity.class);
                    intent.putExtra("url", "https://cdn.stocksnap.io/img-thumbs/960w/" + data.get(position).getImg_id() + ".jpg");
                    ActivityCompat.startActivity(inflater.getContext(), intent, ActivityOptions.makeSceneTransitionAnimation((Activity) inflater.getContext(), v, "sharedView").toBundle());
                }
            });
            String url = "https://cdn.stocksnap.io/img-thumbs/280h/" + data.get(position).getImg_id() + ".jpg";
            Glide.with(holder.itemView.getContext()).asBitmap().load(url)
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
                            ViewGroup.LayoutParams layoutParams = contentViewHolder.thumb.getLayoutParams();
                            layoutParams.height = imageViewHeight;
                            layoutParams.width = imageViewWidth;
                            return false;
                        }
                    })
                    .into(contentViewHolder.thumb);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == data.size()) {
            return ConstantUtil.FOOT_ITEM;
        }
        return CONTENT_ITEM;
    }
    public void addMoreItem(List<MeiTuModel.ResultsBean> newDatas) {

        data.addAll(newDatas);

        notifyDataSetChanged();

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




    public static class ContentViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageView thumb;

        public ContentViewHolder(View itemView) {
            super(itemView);

            thumb = (ImageView) itemView.findViewById(R.id.iv_thumb);

        }
    }

    public static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View itemView) {
            super(itemView);
        }
    }
}
