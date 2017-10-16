package com.yhb.news;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.yhb.news.adapter.TouTiaoViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.design.widget.TabLayout.MODE_SCROLLABLE;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toutiao_tab)
    TabLayout toutiao_tab;

    @BindView(R.id.toutiao_viewpager)
    ViewPager toutiao_viewpager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        List<String> data = new ArrayList<String>();
        data.add("头条");
        data.add("社会");
        data.add("国内");
        data.add("国际");
        data.add("娱乐");
        data.add("体育");
        data.add("军事");
        data.add("科技");
        data.add("财经");
        data.add("时尚");

        toutiao_tab.setTabMode(MODE_SCROLLABLE);
        TouTiaoViewPagerAdapter adapter = new TouTiaoViewPagerAdapter(getSupportFragmentManager(), this, data);
        toutiao_viewpager.setAdapter(adapter);
        toutiao_tab.setupWithViewPager(toutiao_viewpager);


    }
}
