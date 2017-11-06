package com.yhb.news.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.yhb.news.utils.MeiTuUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */

public class MeiTuPagerAdapter extends FragmentPagerAdapter {
    private Context context;
    private List<String> data;
    private List<Fragment> fragmentList;
    FragmentManager fm;

    public MeiTuPagerAdapter(FragmentManager fm, Context context, List<String> data) {
        super(fm);
        this.context = context;
        this.data = data;
        this.fm = fm;
        fragmentList = new ArrayList<>();
        fragmentList.add(new MeiTuFragment());
        fragmentList.add(new MeiTuFragment());
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return MeiTuUtil.getVal(String.valueOf(position));
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = fragmentList.get(position);
        Bundle bundle = new Bundle();

        bundle.putInt("position", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public Fragment instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container,
                position);
        fm.beginTransaction().show(fragment).commit();

        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // super.destroyItem(container, position, object);
        Fragment fragment = fragmentList.get(position);
        fm.beginTransaction().hide(fragment).commit();

    }
}
