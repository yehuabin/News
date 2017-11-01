package com.yhb.news.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yhb.news.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smk on 2017/10/20.
 */

public class IndexViewPagerAdpater extends FragmentPagerAdapter {
    List<String> data;
    private Context context;
    public IndexViewPagerAdpater(FragmentManager fm,Context context) {
        super(fm);
        this.context=context;
        data=new ArrayList<>();
        data.add("资讯");
        data.add("笑话");
        data.add("美图");
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return data.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle=new Bundle();
        bundle.putInt("position",position);
        Fragment fragment=new IndexFragment();

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    public View getTabView(int position){
        View view= LayoutInflater.from(context).inflate(R.layout.index_tab,null);
        TextView textView= (TextView) view.findViewById(R.id.index_title);
        ImageView imageView= (ImageView) view.findViewById(R.id.index_image);
        switch (position){
            case 1:
                imageView.setImageResource(R.drawable.tab2);
                imageView.setTag(R.id.img_unselected,R.drawable.tab2);
                imageView.setTag(R.id.img_selected,R.drawable.tab2_selected);

                break;
            case 2:
                imageView.setImageResource(R.drawable.tab3);
                imageView.setTag(R.id.img_unselected,R.drawable.tab3);
                imageView.setTag(R.id.img_selected,R.drawable.tab3_selected);

                break;
            default:
                imageView.setImageResource(R.drawable.tab1);
                imageView.setTag(R.id.img_unselected,R.drawable.tab1);
                imageView.setTag(R.id.img_selected,R.drawable.tab1_selected);

                break;
        }

        textView.setText(data.get(position));

        return view;
    }
}

