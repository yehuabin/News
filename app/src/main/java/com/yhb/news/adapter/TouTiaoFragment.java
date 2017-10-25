package com.yhb.news.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.yhb.news.R;
import com.yhb.news.model.TouTiao;
import com.yhb.news.model.TouTiaoBmob;
import com.yhb.news.utils.LineDecoration;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TouTiaoFragment extends Fragment {
    private static final String TAG = "TouTiaoFragment";
    @BindView(R.id.toutiao_list)
    RecyclerView toutiao_list;
    @BindView(R.id.toutiao_swipe)
    SwipeRefreshLayout toutiao_swip;
    Handler handler = new Handler();


    OkHttpClient okHttpClient = new OkHttpClient();
    private Unbinder unbinder;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        final String type = bundle.getString("type");

        final View view = inflater.inflate(R.layout.toutiao_fragment, null);
       // String url = "http://v.juhe.cn/toutiao/index?type=" + type + "&key=2e4d0cd4db3d8879e0cacad7afca0bf3";
        //final Request request = new Request.Builder().url(url).build();

        unbinder = ButterKnife.bind(this, view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(inflater.getContext());
        toutiao_list.setItemAnimator(new DefaultItemAnimator());
        toutiao_list.addItemDecoration(new LineDecoration(inflater.getContext(), LineDecoration.VERTICAL_LIST));
        toutiao_list.setLayoutManager(linearLayoutManager);
        toutiao_swip.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_blue_bright, android.R.color.holo_green_light);
        toutiao_swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData(type, view);

            }
        });

        loadData(type, view);

        // loadData(view, request);

        return view;
    }

    private void loadData(String type, final View view) {
        BmobQuery<TouTiaoBmob> query = new BmobQuery<>();
        query.addWhereEqualTo("category", type);
        query.setLimit(10);
        query.findObjects(new FindListener<TouTiaoBmob>() {
            @Override
            public void done(final List<TouTiaoBmob> list, BmobException e) {
                if (list == null) {
                    return;
                }
                final Runnable mRunnable = new Runnable() {
                    public void run() {
                        TouTiaoAdapter adapter = new TouTiaoAdapter(view.getContext(), list);
                        toutiao_list.setAdapter(adapter);
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.line_progress);
                        linearLayout.setVisibility(View.GONE);
                        if (toutiao_swip.isRefreshing()) {
                            toutiao_swip.setRefreshing(false);
                        }
                    }
                };
                new Thread() {
                    public void run() {

                        handler.post(mRunnable);
                    }
                }.start();
            }
        });
    }

    private void loadData(final View view, Request request) {
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new Gson();
                final TouTiao touTiao = gson.fromJson(json, TouTiao.class);
                //写入bmob云数据库
                final List<TouTiao.ResultBean.DataBean> data = touTiao.getResult().getData();

                for (int i = 0; i < data.size(); i++) {
                    final TouTiao.ResultBean.DataBean bean = data.get(i);
                    final TouTiaoBmob touTiaoBmob = new TouTiaoBmob();
                    touTiaoBmob.setAuthor_name(bean.getAuthor_name());
                    touTiaoBmob.setCategory(bean.getCategory() == "" ? "时尚" : bean.getCategory());
                    touTiaoBmob.setDate(bean.getDate());
                    touTiaoBmob.setThumbnail_pic_s(bean.getThumbnail_pic_s());
                    touTiaoBmob.setThumbnail_pic_s02(bean.getThumbnail_pic_s02());
                    touTiaoBmob.setThumbnail_pic_s03(bean.getThumbnail_pic_s03());
                    touTiaoBmob.setTitle(bean.getTitle());
                    touTiaoBmob.setUrl(bean.getUrl());
                    touTiaoBmob.setUniquekey(bean.getUniquekey());
                    touTiaoBmob.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {

                        }
                    });
                }


            }
        });
    }
}
