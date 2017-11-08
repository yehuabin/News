package com.yhb.news;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class BigImageActivity extends BaseActivity {
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bigimage);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        getSupportActionBar().hide();
        final ImageView iv_download = (ImageView) findViewById(R.id.iv_download);
        final PhotoView photoView = (PhotoView) findViewById(R.id.photoView);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        Glide.with(this).asBitmap().load(url).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                bitmap = resource;
                photoView.setImageBitmap(resource);
                iv_download.setVisibility(View.VISIBLE);
            }
        });
        PhotoViewAttacher photoViewAttacher = new PhotoViewAttacher(photoView);
        photoViewAttacher.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
            @Override
            public void onPhotoTap(View view, float x, float y) {
                supportFinishAfterTransition();
            }
        });
        photoViewAttacher.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
            @Override
            public void onViewTap(View view, float x, float y) {
                supportFinishAfterTransition();
            }
        });


        iv_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/youwen/img/";
                if (!Environment.getExternalStorageState().equals( Environment.MEDIA_MOUNTED)) {
                    Toast.makeText(BigImageActivity.this, "外部存储状态有误", Toast.LENGTH_SHORT).show();
                    return;
                }
                Calendar now = new GregorianCalendar();
                SimpleDateFormat simpleDate = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
                String fileName = simpleDate.format(now.getTime());
                try {
                     File dirFile=new File(dir);
                    if (!dirFile.exists()){
                     dirFile.mkdirs();
                    }
                    String path=dir + fileName + ".jpg";
                    File file = new File(path);
                    FileOutputStream out = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                    out.flush();
                    out.close();
                    //保存图片后发送广播通知更新数据库
                    Uri uri = Uri.fromFile(file);
                    sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
                    Toast.makeText(BigImageActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(BigImageActivity.this, "保存失败"+e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        supportFinishAfterTransition();
    }
}
