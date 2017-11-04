package com.yhb.news.adapter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.yhb.news.R;
import com.yhb.news.model.XiaoHuaModel;
import com.yhb.news.utils.HttpUtil;
import com.yhb.news.utils.LineDecoration;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class XiaoHuaFragment extends Fragment {
    LayoutInflater inflater;
    RecyclerView rv_xiaohua;
    XiaoHuaAdapter adapter;
    View view;
    int lastVisibleItem;
    int page = 1;

    public XiaoHuaFragment() {
        // Required empty public constructor
    }

    String url = "http://route.showapi.com/341-1?showapi_appid=48278&showapi_sign=8e890585f9634beda7ac94a10a2c0142&maxResult=10&page=%d";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.inflater = inflater;
        view = inflater.inflate(R.layout.xiaohua_fragment, container, false);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(inflater.getContext());
        rv_xiaohua = (RecyclerView) view.findViewById(R.id.rv_xiaohua);
        rv_xiaohua.addItemDecoration(new LineDecoration(inflater.getContext(), LineDecoration.VERTICAL_LIST));
        rv_xiaohua.setLayoutManager(linearLayoutManager);
        rv_xiaohua.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter.getItemCount()) {
                    page++;
                    loadData(String.format(url, page));
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });
        loadData(String.format(url, page));
        return view;
    }

    private void loadData(String url) {
        HttpUtil.Request(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new Gson();
                final XiaoHuaModel xiaoHuaModel = gson.fromJson(json, XiaoHuaModel.class);
                getActivity().runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        if (page == 1)

                        {
                            // 第一次加载
                            adapter = new XiaoHuaAdapter(inflater, xiaoHuaModel.getShowapi_res_body().getContentlist());

                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.line_progress);
                            linearLayout.setVisibility(View.GONE);
                            rv_xiaohua.setAdapter(adapter);
                        } else

                        {
                            //加载更多
                            adapter.addMoreItem(xiaoHuaModel.getShowapi_res_body().getContentlist());
                        }
                    }
                });
            }
        });
    }

}
