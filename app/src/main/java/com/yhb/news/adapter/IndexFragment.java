package com.yhb.news.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yhb.news.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.support.design.widget.TabLayout.MODE_SCROLLABLE;

/**
 * Created by smk on 2017/10/20.
 */

public class IndexFragment extends Fragment {
    @BindView(R.id.toutiao_tab)
    TabLayout toutiao_tab;

    @BindView(R.id.toutiao_viewpager)
    ViewPager toutiao_viewpager;
    private Unbinder unbinder;
    public IndexFragment() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle=getArguments();
        int position=bundle.getInt("position");
        View view;
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
        else {
            view=inflater.inflate(R.layout.index_2,null);
            //http://www.laifudao.com/api.asp
        }

        return view;
    }
}
