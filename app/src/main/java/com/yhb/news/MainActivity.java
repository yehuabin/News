package com.yhb.news;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yhb.news.adapter.AppPagerAdapter;
import com.yhb.news.utils.RefreshEvent;
import com.yhb.news.views.NoScrollViewPager;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.hugeterry.updatefun.UpdateFunGO;
import cn.hugeterry.updatefun.config.UpdateKey;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.nav_tab)
    TabLayout nav_tab;

    @BindView(R.id.index_viewpager)
    NoScrollViewPager index_viewpager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        UpdateKey.API_TOKEN = "c111a91b782f380bc3c3fec232ca0a5a";
        UpdateKey.APP_ID = "59fbf4b4ca87a808ea000149";
//下载方式:
//UpdateKey.DialogOrNotification=UpdateKey.WITH_DIALOG;通过Dialog来进行下载
//UpdateKey.DialogOrNotification=UpdateKey.WITH_NOTIFITION;通过通知栏来进行下载(默认)
        UpdateFunGO.init(this);
        ButterKnife.bind(this);

        AppPagerAdapter adpater=new AppPagerAdapter(getSupportFragmentManager(),getBaseContext());
        index_viewpager.setAdapter(adpater);
        index_viewpager.setOffscreenPageLimit(3);
        index_viewpager.setNoScroll(true);
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

                index_viewpager.setCurrentItem(tab.getPosition(), false);
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
                if (tab.getPosition()==0) {
                    TabLayout tabLayout = (TabLayout) index_viewpager.findViewById(R.id.toutiao_tab);

                    EventBus.getDefault().post(new RefreshEvent(tabLayout.getSelectedTabPosition()));
                }
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        UpdateFunGO.onResume(this);
    }
    @Override
    protected void onStop() {
        super.onStop();
        UpdateFunGO.onStop(this);
    }
}
