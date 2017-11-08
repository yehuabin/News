package com.yhb.news.adapter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.yhb.news.R;
import com.yhb.news.model.MeiTuModel;
import com.yhb.news.utils.HttpUtil;
import com.yhb.news.utils.MeiTuUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeiTuFragment extends Fragment {
    private static final String TAG = "MeiTuFragment";
    MeiTuAdapter adapter;
    private int page = 1;
    private int lastVisibleItem = 0;
    LayoutInflater inflater;
    RecyclerView rv_meitu;
    String url;
    View view;

    public MeiTuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.inflater = inflater;
        int position=getArguments().getInt("position");
        view = inflater.inflate(R.layout.meitu_fragment, container, false);
        final StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        rv_meitu = (RecyclerView) view.findViewById(R.id.rv_meitu);
        rv_meitu.setLayoutManager(staggeredGridLayoutManager);
        rv_meitu.setHasFixedSize(true);
        rv_meitu.addItemDecoration(new SpaceItemDecoration(8));
        rv_meitu.addOnScrollListener(new RecyclerView.OnScrollListener() {


            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                super.onScrollStateChanged(recyclerView, newState);
                staggeredGridLayoutManager.invalidateSpanAssignments();
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter.getItemCount()) {
                    page++;


                    loadData(String.format(url, page));
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int[] positions = staggeredGridLayoutManager.findLastVisibleItemPositions(null);
                lastVisibleItem = Math.max(positions[0], positions[1]);
                Log.d(TAG, "onScrolled: positions[0]" + positions[0] + " positions[1]:" + positions[0]);
            }
        });
        switch (position){
            case 0:
                url = "https://stocksnap.io/api/load-photos/date/desc/%d";
                break;
            default:
                url = "https://stocksnap.io/api/search-photos/"+ MeiTuUtil.getVal(String.valueOf(position))+"/relevance/desc/%d";
        }
        // url = "https://stocksnap.io/api/load-photos/date/desc/%d";

        //girl https://stocksnap.io/api/search-photos/girl/relevance/desc/1
        //girl https://stocksnap.io/api/search-photos/girl/relevance/desc/1
        loadData(String.format(url, page));
        return view;
    }

    private void loadData(final String url) {
        HttpUtil.Request(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse: "+url);
                String json = response.body().string();
                Gson gson = new Gson();
                final MeiTuModel meiTuModel = gson.fromJson(json, MeiTuModel.class);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (page > 1) {
                            adapter.addMoreItem(meiTuModel.getResults());
                        } else {
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.line_progress);
                            linearLayout.setVisibility(View.GONE);
                            adapter = new MeiTuAdapter(inflater, meiTuModel.getResults());
                            rv_meitu.setAdapter(adapter);
                        }
                    }
                });


            }
        });
    }
}
