package com.yhb.news;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yhb.news.adapter.IndexViewPagerAdpater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.nav_tab)
    TabLayout nav_tab;

    @BindView(R.id.index_viewpager)
    ViewPager index_viewpager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);

        IndexViewPagerAdpater adpater=new IndexViewPagerAdpater(getSupportFragmentManager(),getBaseContext());
        index_viewpager.setAdapter(adpater);
        nav_tab.setupWithViewPager(index_viewpager);
        for (int i=0;i<nav_tab.getTabCount();i++){
            TabLayout.Tab tab=nav_tab.getTabAt(i);
            tab.setCustomView(adpater.getTabView(i));
            tab.setTag(i);

        }
        nav_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               View view= tab.getCustomView();
               TextView textView= (TextView) view.findViewById(R.id.index_title);
                textView.setTextColor(Color.parseColor("#d81e06"));
                ImageView imageView= (ImageView) view.findViewById(R.id.index_image);
                imageView.setImageResource((int)imageView.getTag(R.id.img_selected));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view= tab.getCustomView();
                TextView textView= (TextView) view.findViewById(R.id.index_title);
                textView.setTextColor(Color.parseColor("#767676"));
                ImageView imageView= (ImageView) view.findViewById(R.id.index_image);
                imageView.setImageResource((int)imageView.getTag(R.id.img_unselected));

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
