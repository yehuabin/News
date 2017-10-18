package com.yhb.news;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.yhb.news.adapter.TouTiaoViewPagerAdapter;
import com.yhb.news.utils.TouTiaoType;

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
        getSupportActionBar().hide();
        ButterKnife.bind(this);
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
        TouTiaoViewPagerAdapter adapter = new TouTiaoViewPagerAdapter(getSupportFragmentManager(), this, data);
        toutiao_viewpager.setAdapter(adapter);
        toutiao_tab.setupWithViewPager(toutiao_viewpager);

        for (int i=0;i<toutiao_tab.getTabCount();i++){
            TabLayout.Tab tab=toutiao_tab.getTabAt(i);
            //tab.setCustomView(getTabView(i,data));
        }
    }

    private View getTabView(int position,List<String> data){
        View view= LayoutInflater.from(getBaseContext()).inflate(R.layout.toutiao_tab,null);
       TextView textView= (TextView) view.findViewById(R.id.text_title);
        textView.setText(TouTiaoType.GetVal( data.get(position)));

        return view;
    }
}
