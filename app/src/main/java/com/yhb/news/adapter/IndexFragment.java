package com.yhb.news.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.yhb.news.R;
import com.yhb.news.model.MeiNvModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.support.design.widget.TabLayout.MODE_SCROLLABLE;

/**
 * Created by smk on 2017/10/20.
 */

public class IndexFragment extends Fragment {
    private static final String TAG = "IndexFragment";
    @BindView(R.id.toutiao_tab)
    TabLayout toutiao_tab;

    @BindView(R.id.toutiao_viewpager)
    ViewPager toutiao_viewpager;
    private Unbinder unbinder;
    public IndexFragment() {
    }
    Handler handler = new Handler();
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder!=null){
        unbinder.unbind();
        }
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle=getArguments();
        int position=bundle.getInt("position");
        final View view;
        if (position==0){
            view=inflater.inflate(R.layout.index_1,null);
            unbinder= ButterKnife.bind(this,view);
            List<String> data = new ArrayList<String>();
            data.add("top");
            data.add("shehui");
            data.add("guonei");
            data.add("guoji");
            data.add("yule");
            data.add("tiyu");
            data.add("junshi");
            data.add("keji");
            data.add("caijing");
            data.add("shishang");
            toutiao_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    tab.getText();
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
            toutiao_tab.setTabMode(MODE_SCROLLABLE);
            TouTiaoViewPagerAdapter adapter = new TouTiaoViewPagerAdapter(getFragmentManager(), view.getContext(), data);
            toutiao_viewpager.setAdapter(adapter);
            toutiao_tab.setupWithViewPager(toutiao_viewpager);
        }
        else if(position==1) {
            view=inflater.inflate(R.layout.index_2,null);
            //http://www.laifudao.com/api.asp
        }
        else {
            view=inflater.inflate(R.layout.index_3,null);
            StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL);
            staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
            final RecyclerView rv_meinv= (RecyclerView) view.findViewById(R.id.rv_meinv);
            rv_meinv.setLayoutManager(staggeredGridLayoutManager);

            String url="http://route.showapi.com/1208-2?showapi_appid=48278&showapi_sign=8e890585f9634beda7ac94a10a2c0142&type=1&rows=50&page=1";
            Request request=new Request.Builder().url(url).build();
            OkHttpClient okHttpClient=new OkHttpClient();
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String json = response.body().string();
                    Gson gson = new Gson();
                    final MeiNvModel meiNvModel = gson.fromJson(json, MeiNvModel.class);


                    final Runnable mRunnable = new Runnable() {
                        public void run() {
                            MeiNvAdapter adapter = new MeiNvAdapter(inflater, meiNvModel.getShowapi_res_body().getData());
                            rv_meinv.setAdapter(adapter);

                        }
                    };
                    new Thread() {
                        @Override
                        public void run() {

                            handler.post(mRunnable);
                        }
                    }.start();

                }
            });
        }

        return view;
    }
}
