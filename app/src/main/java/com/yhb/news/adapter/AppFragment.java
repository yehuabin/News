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
import com.yhb.news.model.MeiTuModel;
import com.yhb.news.utils.HttpUtil;
import com.yhb.news.utils.JokeUtil;
import com.yhb.news.utils.NewsUtil;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static android.support.design.widget.TabLayout.MODE_SCROLLABLE;

/**
 * Created by smk on 2017/10/20.
 */

public class AppFragment extends Fragment {
    private static final String TAG = "AppFragment";
    @BindView(R.id.toutiao_tab)
    TabLayout toutiao_tab;

    @BindView(R.id.toutiao_viewpager)
    ViewPager toutiao_viewpager;
    private Unbinder unbinder;

    public AppFragment() {
    }

    Handler handler = new Handler();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        int position = bundle.getInt("position");
        final View view;
        if (position == 0) {
            view = inflater.inflate(R.layout.news_page, null);
            unbinder = ButterKnife.bind(this, view);


//            toutiao_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//                @Override
//                public void onTabSelected(TabLayout.Tab tab) {
//                    tab.getText();
//                }
//
//                @Override
//                public void onTabUnselected(TabLayout.Tab tab) {
//
//                }
//
//                @Override
//                public void onTabReselected(TabLayout.Tab tab) {
//
//                }
//            });
            toutiao_tab.setTabMode(MODE_SCROLLABLE);
            NewsPagerAdapter adapter = new NewsPagerAdapter(getFragmentManager(), view.getContext(), NewsUtil.getData());
            toutiao_viewpager.setAdapter(adapter);
            toutiao_tab.setupWithViewPager(toutiao_viewpager);
        } else if (position == 1) {
            view = inflater.inflate(R.layout.joke_page, null);
            TabLayout tab_joke = (TabLayout) view.findViewById(R.id.tab_joke);
            ViewPager vp_joke = (ViewPager) view.findViewById(R.id.vp_joke);
            //tab_joke.setTabMode(MODE_SCROLLABLE);
            JokePagerAdapter jokePagerAdapter = new JokePagerAdapter(getFragmentManager(), view.getContext(), JokeUtil.getData());
            vp_joke.setAdapter(jokePagerAdapter);
            tab_joke.setupWithViewPager(vp_joke);

        } else {
            view = inflater.inflate(R.layout.meitu_page, null);
            final StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL);
            staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
            final RecyclerView rv_meinv = (RecyclerView) view.findViewById(R.id.rv_meinv);
            rv_meinv.setLayoutManager(staggeredGridLayoutManager);
            rv_meinv.setHasFixedSize(true);
            rv_meinv.addItemDecoration(new SpaceItemDecoration(8));

            rv_meinv.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    staggeredGridLayoutManager.invalidateSpanAssignments();
                }
            });
            String url = "https://stocksnap.io/api/load-photos/date/desc/1";
            HttpUtil.Request(url, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String json = response.body().string();
                    Gson gson = new Gson();
                    final MeiTuModel meiTuModel = gson.fromJson(json, MeiTuModel.class);


                    final Runnable mRunnable = new Runnable() {
                        public void run() {
                            MeiTuAdapter adapter = new MeiTuAdapter(inflater, meiTuModel.getResults());
                            rv_meinv.setAdapter(adapter);
                        }
                    };
                    handler.post(mRunnable);
                }
            });
        }

        return view;
    }
}
