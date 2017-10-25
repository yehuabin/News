package com.yhb.news.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.yhb.news.R;
import com.yhb.news.model.MeiNvModel;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author yhb
 */

public class MeiNvFragment extends Fragment {
    Handler handler = new Handler();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.index_3,null);
        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.rv_meinv);
        String url="http://route.showapi.com/819-1?showapi_appid=48278&showapi_sign=8e890585f9634beda7ac94a10a2c0142";
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




            }
        });
        return view;
    }
}
