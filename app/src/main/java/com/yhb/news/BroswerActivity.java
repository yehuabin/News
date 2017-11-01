package com.yhb.news;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BroswerActivity extends BaseActivity {
    private static final String TAG = "BroswerActivity";
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broswer);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("");

        webView = (WebView) findViewById(R.id.webView);

        Bundle bundle = getIntent().getExtras();
        final String newsUrl = bundle.getString("url");
        webView.loadUrl(newsUrl);
        //webView.loadUrl("http://ceshi.sxjz.gov.cn/bmtzgg/content_196215");

        webView.setWebViewClient(new WebViewClient() {
            //覆盖shouldOverrideUrlLoading 方法
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (!newsUrl.equals(url)) {
                    return false;
                }
                Log.d(TAG, "shouldOverrideUrlLoading: " + url);
                view.loadUrl(url);
                return true;
            }
        });
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {  //表示按返回键
                        webView.goBack();   //后退
                        //webview.goForward();//前进
                        return true;    //已处理
                    }
                }
                return false;
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webView.loadUrl("javascript:$(\".doc-footer-wrapper,header,.js-topad,.js-altop,.footer,.icon_index\").remove()");
            }
        });
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
