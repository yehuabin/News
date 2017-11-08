package com.yhb.news.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yhb.news.R;
import com.yhb.news.utils.JokeUtil;
import com.yhb.news.utils.MeiTuUtil;
import com.yhb.news.utils.NewsUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

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

            toutiao_tab.setTabMode(MODE_SCROLLABLE);
            NewsPagerAdapter adapter = new NewsPagerAdapter(getFragmentManager(), view.getContext(), NewsUtil.getData());
            toutiao_viewpager.setAdapter(adapter);
            toutiao_tab.setupWithViewPager(toutiao_viewpager);
        } else if (position == 1) {
            view = inflater.inflate(R.layout.joke_page, null);
            TabLayout tab_joke = (TabLayout) view.findViewById(R.id.tab_joke);
            ViewPager vp_joke = (ViewPager) view.findViewById(R.id.vp_joke);
            JokePagerAdapter jokePagerAdapter = new JokePagerAdapter(getFragmentManager(), view.getContext(), JokeUtil.getData());
            vp_joke.setAdapter(jokePagerAdapter);
            tab_joke.setupWithViewPager(vp_joke);

        } else {
            view = inflater.inflate(R.layout.meitu_page, null);
            TabLayout tab_meitu = (TabLayout) view.findViewById(R.id.tab_meitu);
            tab_meitu.setTabMode(MODE_SCROLLABLE);
            ViewPager vp_meitu = (ViewPager) view.findViewById(R.id.vp_meitu);
            MeiTuPagerAdapter meiTuPagerAdapter = new MeiTuPagerAdapter(getFragmentManager(), view.getContext(), MeiTuUtil.getData());
            vp_meitu.setAdapter(meiTuPagerAdapter);
            tab_meitu.setupWithViewPager(vp_meitu);
        }

        return view;
    }
}
