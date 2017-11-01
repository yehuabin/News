package com.yhb.news.adapter;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
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
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yhb.news.R;
import com.yhb.news.model.NewsCommonModel;
import com.yhb.news.model.NewsModel;
import com.yhb.news.utils.LineDecoration;
import com.yhb.news.utils.NewsUtil;
import com.yhb.news.utils.RefreshEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

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
    private int lastVisibleItem;
    private int page = 0;
    private String url;
    View view;
    @BindView(R.id.toutiao_list)
    RecyclerView toutiao_list;
    @BindView(R.id.toutiao_swipe)
    SwipeRefreshLayout toutiao_swip;
    Handler handler = new Handler();
    LayoutInflater inflater;

    OkHttpClient okHttpClient = new OkHttpClient();
    private Unbinder unbinder;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
        EventBus.getDefault().unregister(this);
    }


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        this.inflater=inflater;
        Bundle bundle = getArguments();
        position = bundle.getInt("position");
        Log.d(TAG, "onCreateView:position: " + position+" page:"+page);
        view = inflater.inflate(R.layout.news_fragment, null);

        switch (position) {
            case 1://新闻
                url = "http://3g.163.com/touch/reconstruct/article/list/BBM54PGAwangning/%d-10.html";
                break;
            case 2://娱乐
                url = "http://3g.163.com/touch/reconstruct/article/list/BA10TA81wangning/%d-10.html";
                break;
            case 3://NBA
                url = "https://3g.163.com/touch/reconstruct/article/list/BD2AQH4Qwangning/%d-10.html";
                break;
            case 4://体育
                url = "http://3g.163.com/touch/reconstruct/article/list/BA8E6OEOwangning/%d-10.html";
                break;
            default:
                url = "https://3g.163.com/touch/jsonp/sy/recommend/%d-10.html?hasad=0&offset=0&size=20";

                break;
        }
        Request request = new Request.Builder().url(String.format(url, page)).build();

        unbinder = ButterKnife.bind(this, view);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(inflater.getContext());
        toutiao_list.setItemAnimator(new DefaultItemAnimator());
        toutiao_list.addItemDecoration(new LineDecoration(inflater.getContext(), LineDecoration.VERTICAL_LIST));
        toutiao_list.setLayoutManager(linearLayoutManager);

        toutiao_list.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter.getItemCount()) {
                    page++;
                    String moreUrl = url;
                    if (position == 0) {
                        moreUrl = url + "&refresh=A&miss=00";
                    }

                    loadData(new Request.Builder().url(String.format(moreUrl, page * 10)).build());
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });
        toutiao_swip.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_blue_bright, android.R.color.holo_green_light);
        toutiao_swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData( new Request.Builder().url(String.format(url, 0)).build());

            }
        });


        loadData( request);

        return view;
    }

    NewsAdapter adapter;
    PopupWindow popupWindow;
    CountDownTimer timer;
    View popupView;
    private void loadData( Request request) {
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
                if (dataSrc==null||dataSrc.size()==0){
                    Toast.makeText(view.getContext(), "数据加载出错!", Toast.LENGTH_SHORT).show();
                    toutiao_swip.setRefreshing(false);
                    return;
                }

                final List<NewsCommonModel> data = NewsUtil.getRecommend(dataSrc);
                //去广告
                int i = 0;
                while (i < data.size()) {
                    NewsCommonModel model=data.get(i);
                    if (model.getAuthor() == "广告") {
                        data.remove(i);
                    }
                    else if (model.getUrl()==null){
                        data.remove(i);
                    }
                    else if (model.getImage()==null){
                        data.remove(i);
                    }
                    i++;
                }



                final Runnable mRunnable = new Runnable() {
                    public void run() {

                        if (toutiao_swip.isRefreshing()) {
                            //下拉刷新
                           int updateCount= adapter.addItem(data);
                            toutiao_swip.setRefreshing(false);
                            TabLayout tab=(TabLayout) getActivity().findViewById(R.id.toutiao_tab);
                            if (popupWindow == null) {
                                popupView= inflater.inflate(R.layout.popup_loadfinish, null);
                                popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                                ColorDrawable dw = new ColorDrawable(0xb0000000);
                                popupWindow.setBackgroundDrawable(dw);
                                // popupWindow.setAnimationStyle(R.style.PopupAnimation);
                                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                                    @Override
                                    public void onDismiss() {
                                        if (timer != null) {
                                           // timer.cancel();
                                            timer = null;
                                        }
                                    }
                                });
                                popupWindow.showAsDropDown(tab);

                            } else {
                                if (popupWindow.isShowing()) {
                                    popupWindow.dismiss();

                                } else {
                                    popupWindow.showAsDropDown(tab);
                                }
                            }
                            if (timer==null){
                                timer = new CountDownTimer(1000, 1000) {

                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                    }

                                    @Override
                                    public void onFinish() {
                                        Log.d("test", "onFinish: ");
                                        popupWindow.dismiss();

                                    }
                                };
                               TextView textView= (TextView) popupView.findViewById(R.id.popup_info);
                                if (updateCount>0){
                                    textView.setText("更新了"+updateCount+"条数据");
                                }
                                else {
                                    textView.setText("已经是最新数据");
                                }
                                timer.start();
                            }
                        } else if (page > 0) {
                            //上拉加载更多
                            adapter.addMoreItem(data);
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

    //首页tab点击刷新当前fragment
    @Subscribe
    public void onEvent(RefreshEvent event) {
        if (event.getTabPosition()!=position){
            return;
        }
        toutiao_swip.setRefreshing(true);
        toutiao_list.scrollToPosition(0);
        loadData(new Request.Builder().url(String.format(url, 0)).build());
    }
}
