package com.yhb.news.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yhb.news.R;
import com.yhb.news.model.TouTiao;

import java.io.IOException;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TouTiaoFragment extends Fragment {
    @BindView(R.id.toutiao_list)
    RecyclerView toutiao_list;

    @BindView(R.id.toutiao_swipe)
    SwipeRefreshLayout toutiao_swip;

    OkHttpClient okHttpClient = new OkHttpClient();

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        final View view = inflater.inflate(R.layout.toutiao_fragment, null);
        toutiao_list = (RecyclerView) view.findViewById(R.id.toutiao_list);
        toutiao_swip = (SwipeRefreshLayout) view.findViewById(R.id.toutiao_swipe);

        String url = "http://v.juhe.cn/toutiao/index?type=&key=2e4d0cd4db3d8879e0cacad7afca0bf3";
        final Request request = new Request.Builder().url(url).build();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(inflater.getContext());
        toutiao_list.setItemAnimator(new DefaultItemAnimator());
        toutiao_list.setLayoutManager(linearLayoutManager);
        toutiao_swip.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_blue_bright, android.R.color.holo_green_light);
        toutiao_swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        toutiao_swip.setRefreshing(false);
                        Toast.makeText(inflater.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String json = response.body().string();
                        Gson gson = new Gson();
                        final TouTiao touTiao = gson.fromJson(json, TouTiao.class);
//
//                        MainActivity.this.runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                TouTiaoAdapter adapter = new TouTiaoAdapter(inflater.getContext(), touTiao);
//                                toutiao_list.setAdapter(adapter);
//                            }
//                        });
                        toutiao_swip.setRefreshing(false);
                    }
                });
            }
        });


        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new Gson();
                final TouTiao touTiao = gson.fromJson(json, TouTiao.class);
                Runnable mRunnable = new Runnable() {
                    public void run() {
                        TouTiaoAdapter adapter = new TouTiaoAdapter(view.getContext(), touTiao);
                        toutiao_list.setAdapter(adapter);
                    }
                };
                mRunnable.run();
//                MainActivity.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        TouTiaoAdapter adapter = new TouTiaoAdapter(MainActivity.this, touTiao);
//                        toutiao_list.setAdapter(adapter);
//                    }
//                });
            }
        });
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
