package com.yhb.news.adapter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yhb.news.R;
import com.yhb.news.model.GenTieModel;
import com.yhb.news.utils.HttpUtil;
import com.yhb.news.utils.LineDecoration;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class GenTieFragment extends Fragment {

    GenTieAdapter adapter;
    private int page = 0;
    private int lastVisibleItem = 0;
    LayoutInflater inflater;
    RecyclerView rv_joke;
    String url;
    View view;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.gentie_fragment, container, false);
        this.inflater = inflater;
        url = "https://3g.163.com/touch/jsonp/hot/comments/%d-10.html";
        rv_joke = (RecyclerView) view.findViewById(R.id.rv_joke);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(inflater.getContext());
        rv_joke.setItemAnimator(new DefaultItemAnimator());
        rv_joke.addItemDecoration(new LineDecoration(inflater.getContext(), LineDecoration.VERTICAL_LIST));
        rv_joke.setLayoutManager(linearLayoutManager);
        rv_joke.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter.getItemCount()) {
                    page++;


                    loadData(String.format(url, page * 10));
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });
        loadData(String.format(url, 0));
        return view;
    }

    private void loadData(String url) {
        HttpUtil.Request(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string().replace("hotcomment(", "");
                json = json.substring(0, json.length() - 1);
                Gson gson = new Gson();
                final List<GenTieModel> genTieModels = gson.fromJson(json, new TypeToken<List<GenTieModel>>() {
                }.getType());
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (page > 0) {
                            //上拉加载更多
                            adapter.addMoreItem(genTieModels);
                        } else {
                            //第一次加载
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.line_progress);
                            linearLayout.setVisibility(View.GONE);
                            adapter = new GenTieAdapter(inflater, genTieModels);
                            rv_joke.setAdapter(adapter);
                        }


                    }

                });

            }
        });
    }
}
