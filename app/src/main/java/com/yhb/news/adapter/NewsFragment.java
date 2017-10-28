package com.yhb.news.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.yhb.news.R;
import com.yhb.news.model.NewsCommonModel;
import com.yhb.news.model.NewsModel;
import com.yhb.news.utils.LineDecoration;
import com.yhb.news.utils.NewsUtil;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NewsFragment extends Fragment {
    private static final String TAG = "NewsFragment";
    private int position;
    private String url;
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
        position = bundle.getInt("position");

        final View view = inflater.inflate(R.layout.news_fragment, null);

        switch (position) {
            case 1://新闻
                url = "http://3g.163.com/touch/reconstruct/article/list/BBM54PGAwangning/0-10.html";
                break;
            case 2://娱乐
                url = "http://3g.163.com/touch/reconstruct/article/list/BA10TA81wangning/0-10.html";
                break;
            case 3://NBA
                url = "https://3g.163.com/touch/reconstruct/article/list/BD2AQH4Qwangning/0-10.html";
                break;
            case 4://体育
                url = "http://3g.163.com/touch/reconstruct/article/list/BA8E6OEOwangning/0-10.html";
                break;
            default:
                url = "https://3g.163.com/touch/jsonp/sy/recommend/0-10.html?hasad=0&offset=0&size=20&refresh=A&miss=00";
                break;
        }
        Request request = new Request.Builder().url(url).build();

        unbinder = ButterKnife.bind(this, view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(inflater.getContext());
        toutiao_list.setItemAnimator(new DefaultItemAnimator());
        toutiao_list.addItemDecoration(new LineDecoration(inflater.getContext(), LineDecoration.VERTICAL_LIST));
        toutiao_list.setLayoutManager(linearLayoutManager);
        toutiao_swip.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_blue_bright, android.R.color.holo_green_light);
        toutiao_swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                loadData(view, new Request.Builder().url(url).build());

            }
        });


        loadData(view, request);

        return view;
    }

    NewsAdapter adapter;

    private void loadData(final View view, Request request) {
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: " + e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string().replace("artiList(", "");
                json = json.substring(0, json.length() - 1);
                Gson gson = new Gson();
                NewsModel newsModel = gson.fromJson(json, NewsModel.class);
                List<NewsModel.News> dataSrc = newsModel.getNewsList();
                //去广告
                int i = 0;
                while (i < dataSrc.size()) {
                    if (dataSrc.get(i).getSource() == "广告") {
                        dataSrc.remove(i);
                    } else if (dataSrc.get(i).getCategory() == null && dataSrc.get(i).getPicInfo() != null) {
                        dataSrc.remove(i);
                    }
                    i++;
                }
                final List<NewsCommonModel> data = NewsUtil.getRecommend(dataSrc);


                final Runnable mRunnable = new Runnable() {
                    public void run() {

                        if (toutiao_swip.isRefreshing()) {
                            //下拉刷新
                            adapter.addItem(data);
                            toutiao_swip.setRefreshing(false);
                        } else {
                            //第一次加载
                            adapter = new NewsAdapter(view.getContext(), data);
                            toutiao_list.setAdapter(adapter);
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.line_progress);
                            linearLayout.setVisibility(View.GONE);
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
