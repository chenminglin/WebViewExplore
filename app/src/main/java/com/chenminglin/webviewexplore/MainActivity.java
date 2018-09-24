package com.chenminglin.webviewexplore;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    final String url = "https://cpu.baidu.com/api/1022/f0dd3047/detail/23268057535259363/news?cpid=EP1UgZ6gsYjN-qelNE_e-dfHZS0nRtzNwfawAVmho4qwqdxwwIidU7SoCM0DVxErWr0nD4pln3eZFWiAq2db0WCIasQpr_a3zVxSZTF_eTExBvB2-cC8WurkoRGgQJJnM1QES1Xznhd6v0SvprQPRoCqgM09wXEuCY-OofdK-i_oywUx_zQ7GOrv1wLmZoejkXlh0lfTyUkoCgHPKBm3fuZxyM4mfdymUH0G-xOAd5QnIkZMp2Z0qYAyXsy2tZQQBdQ1sd53YLXERTKC5HQxEKej1ryFyJzMYWsdGA_qiJ9mSnHRhDUHryE2pzuZaC9VsZOVuS6fMZbp5xVmJnlMBw&scene=0&log_id=1537784553070bb89431b2deed6d6b6c&no_list=1&forward=api&api_version=2&rts=4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.webview);

        webView.loadUrl(url);

        WebSettings webSettings = webView.getSettings();
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        //5.0以上开启混合模式加载
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        //允许js代码
        webSettings.setJavaScriptEnabled(true);
        //允许SessionStorage/LocalStorage存储
        webSettings.setDomStorageEnabled(true);
        //禁用放缩
        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(false);
        //禁用文字缩放
        webSettings.setTextZoom(100);
        //10M缓存，api 18后，系统自动管理。
        webSettings.setAppCacheMaxSize(10 * 1024 * 1024);
        //允许缓存，设置缓存位置
        webSettings.setAppCacheEnabled(true);

        webSettings.setAppCachePath(this.getDir("appcache", 0).getPath());
        //允许WebView使用File协议
        webSettings.setAllowFileAccess(true);
        //不保存密码
        webSettings.setSavePassword(false);
        //设置UA
        webSettings.setUserAgentString(webSettings.getUserAgentString() +"/test");
        //自动加载图片
        webSettings.setLoadsImagesAutomatically(true);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        webView.setWebChromeClient(new WebChromeClient(){

        });


    }
}
