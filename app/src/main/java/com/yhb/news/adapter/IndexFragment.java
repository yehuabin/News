package com.yhb.news.adapter;

import android.graphics.Rect;
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
import com.yhb.news.model.MeiNvModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.support.design.widget.TabLayout.MODE_SCROLLABLE;

/**
 * Created by smk on 2017/10/20.
 */

public class IndexFragment extends Fragment {
    private static final String TAG = "IndexFragment";
    @BindView(R.id.toutiao_tab)
    TabLayout toutiao_tab;

    @BindView(R.id.toutiao_viewpager)
    ViewPager toutiao_viewpager;
    private Unbinder unbinder;
    public IndexFragment() {
    }
    Handler handler = new Handler();
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder!=null){
        unbinder.unbind();
        }
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle=getArguments();
        int position=bundle.getInt("position");
        final View view;
        if (position==0){
            view=inflater.inflate(R.layout.index_1,null);
            unbinder= ButterKnife.bind(this,view);
            List<String> data = new ArrayList<String>();
            Integer i=-1;
            while (i<19){
                data.add(i.toString());
                i++;
            }
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
        else if(position==1) {
            view=inflater.inflate(R.layout.index_2,null);

            //http://www.laifudao.com/api.asp
        }
        else {
            view=inflater.inflate(R.layout.index_3,null);
            final StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL);
            staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
            final RecyclerView rv_meinv= (RecyclerView) view.findViewById(R.id.rv_meinv);
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
            String url="http://route.showapi.com/1208-2?showapi_appid=48278&showapi_sign=8e890585f9634beda7ac94a10a2c0142&type=1&rows=50&page=1";
            Request request=new Request.Builder().url(url).build();
            OkHttpClient okHttpClient=new OkHttpClient();
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String json = response.body().string();
                    Gson gson = new Gson();
                    final MeiNvModel meiNvModel = gson.fromJson(json, MeiNvModel.class);


                    final Runnable mRunnable = new Runnable() {
                        public void run() {
                            MeiNvAdapter adapter = new MeiNvAdapter(inflater, meiNvModel.getShowapi_res_body().getData());
                            rv_meinv.setAdapter(adapter);

                        }
                    };
                    new Thread() {
                        @Override
                        public void run() {

                            handler.post(mRunnable);
                        }
                    }.start();

                }
            });
        }

        return view;
    }
}
 class SpaceItemDecoration extends RecyclerView.ItemDecoration{
     int mSpace;

     /**
      * Retrieve any offsets for the given item. Each field of <code>outRect</code> specifies
      * the number of pixels that the item view should be inset by, similar to padding or margin.
      * The default implementation sets the bounds of outRect to 0 and returns.
      * <p>
      * <p>
      * If this ItemDecoration does not affect the positioning of item views, it should set
      * all four fields of <code>outRect</code> (left, top, right, bottom) to zero
      * before returning.
      * <p>
      * <p>
      * If you need to access Adapter for additional data, you can call
      * {@link RecyclerView#getChildAdapterPosition(View)} to get the adapter position of the
      * View.
      *
      * @param outRect Rect to receive the output.
      * @param view    The child view to decorate
      * @param parent  RecyclerView this ItemDecoration is decorating
      * @param state   The current state of RecyclerView.
      */
     @Override
     public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
         super.getItemOffsets(outRect, view, parent, state);
         outRect.left = mSpace;
         outRect.right = mSpace;
         outRect.bottom = mSpace;
         if (parent.getChildAdapterPosition(view) == 0) {
             outRect.top = mSpace;
         }

     }

     public SpaceItemDecoration(int space) {
         this.mSpace = space;
     }
}