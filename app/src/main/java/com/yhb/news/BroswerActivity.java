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
        final String source=bundle.getString("source");
        final String newsUrl = bundle.getString("url");

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
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.d(TAG, "shouldOverrideUrlLoading: "+url);
                if (url.indexOf("163.com")==-1){
                    return true;
                }

               return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                Log.d(TAG, "onPageFinished: "+url);
                super.onPageFinished(view, url);
                    webView.loadUrl("javascript:if($('.doc-footer-wrapper')){$('.doc-footer-wrapper').remove();}" +
                            "if($('.js-topad')){$('.js-topad').remove();}" +
                            "if($('.js-altop')){$('.js-altop').remove();}" +
                            "if($('.js-columsADBlowContent')){$('.js-columsADBlowContent').remove();}" +
                            "if($('.icon_index')){$('.icon_index').remove();}" +
                            "if($('.js-slider')){$('.js-slider').remove();}" +
                            "if($('.redpacket-wrap')){$('.redpacket-wrap').remove();}" +
                            "if($('header')){$('header').remove();}");
            }

        });
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        webView.loadUrl(newsUrl);
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
