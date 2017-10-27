package com.yhb.news.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yhb.news.utils.TouTiaoType;

import java.util.List;

/**
 * Created by smk on 2017/10/16.
 */

public class TouTiaoViewPagerAdapter extends FragmentPagerAdapter {
    private Context context;
    private List<String> data;

    public TouTiaoViewPagerAdapter(FragmentManager fm, Context context,List<String> data) {
        super(fm);
        this.context = context;
        this.data=data;

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TouTiaoType.getVal(String.valueOf(position));
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=new TouTiaoFragment();
        Bundle bundle=new Bundle();

        bundle.putString("type",TouTiaoType.getVal(String.valueOf(position)));
        fragment.setArguments(bundle);
        return fragment;
    }
}

