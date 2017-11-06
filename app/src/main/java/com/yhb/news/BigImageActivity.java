package com.yhb.news;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;

import uk.co.senab.photoview.PhotoView;

public class BigImageActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bigimage);
        setFullScreen();
        PhotoView photoView= (PhotoView) findViewById(R.id.photoView);
        Intent intent= getIntent();
        String url=intent.getStringExtra("url");
        Glide.with(this).load(url).into(photoView);
    }

    @Override
    public void onBackPressed() {
        supportFinishAfterTransition();
    }
}
