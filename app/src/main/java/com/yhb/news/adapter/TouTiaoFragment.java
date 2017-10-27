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
import com.yhb.news.utils.LineDecoration;

import java.io.IOException;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
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
        if (unbinder != null) {
            unbinder.unbind();
        }

    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        String type = bundle.getString("type");

        final View view = inflater.inflate(R.layout.toutiao_fragment, null);
        String url = "http://pc.recommend.kandian.360.cn/youlike?u=50067044.3549630852473969700.1509085179855.3418&n=20&f=json&o=rand&fr=home&option=history";
        final Request request = new Request.Builder().url(url).build();

        unbinder = ButterKnife.bind(this, view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(inflater.getContext());
        toutiao_list.setItemAnimator(new DefaultItemAnimator());
        toutiao_list.addItemDecoration(new LineDecoration(inflater.getContext(), LineDecoration.VERTICAL_LIST));
        toutiao_list.setLayoutManager(linearLayoutManager);
        toutiao_swip.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_blue_bright, android.R.color.holo_green_light);
        toutiao_swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData(view, request);

            }
        });


        loadData(view, request);

        return view;
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
                final TouTiao[] touTiao = gson.fromJson(json, TouTiao[].class);

                final Runnable mRunnable = new Runnable() {
                    public void run() {
                        TouTiaoAdapter adapter = new TouTiaoAdapter(view.getContext(), Arrays.asList(touTiao));
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
}
