package com.yhb.news.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yhb.news.R;
import com.yhb.news.model.XiaoHuaModel;
import com.yhb.news.utils.ConstantUtil;

import java.util.List;

import static com.yhb.news.utils.ConstantUtil.CONTENT_ITEM;

/**
 * Created by Administrator on 2017/11/4.
 */

public class XiaoHuaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<XiaoHuaModel.ShowapiResBodyBean.ContentlistBean> data;
    LayoutInflater inflater;

    public XiaoHuaAdapter( LayoutInflater inflater,
                           List<XiaoHuaModel.ShowapiResBodyBean.ContentlistBean> data) {
        this.data = data;
        this.inflater = inflater;
    }

    @Override
    public int getItemViewType(int position)
    {
        if (position == data.size()) {
            return ConstantUtil.FOOT_ITEM;
        }
        return CONTENT_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View view;
        if (viewType == CONTENT_ITEM) {
            view=inflater.inflate(R.layout.xiaohua_item,null);
            viewHolder = new ContentViewHolder(view);
        } else {
            view = inflater.inflate(R.layout.foot_loadmore_item, parent, false);
            viewHolder = new FootViewHolder(view);
        }

        return viewHolder;
    }
    public void addMoreItem(List<XiaoHuaModel.ShowapiResBodyBean.ContentlistBean> newDatas) {

        data.addAll(newDatas);

        notifyDataSetChanged();

    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ContentViewHolder) {
            final ContentViewHolder contentViewHolder = (ContentViewHolder) holder;
            contentViewHolder.tv_content.setText(data.get(position).getText());
            contentViewHolder.tv_title.setText(data.get(position).getTitle());
        }

    }

    @Override
    public int getItemCount() {
        return data.size()+1;
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_content;
        public TextView tv_title;

        public ContentViewHolder(View itemView) {
            super(itemView);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View itemView) {
            super(itemView);
        }
    }

}
