package com.chenminglin.webviewexplore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
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
