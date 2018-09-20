package com.news.abhishek.newsapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class newsExplore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_explore);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

        String newsUrl = intent.getStringExtra("newsUrl");


        WebView webview = findViewById(R.id.webView);
        webview.loadUrl(newsUrl);
        webview.setWebViewClient(new WebViewClient() {
            //if app crash on before lolipop check this
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });

    }
}
