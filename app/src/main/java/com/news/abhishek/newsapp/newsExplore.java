package com.news.abhishek.newsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class newsExplore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_explore);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
       /* String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        String url = intent.getStringExtra("url");*/
        String newsUrl = intent.getStringExtra("newsUrl");

        // Capture the layout's TextView and set the string as its text
       /* ImageView image=findViewById(R.id.imageViewinExlore);
        Glide.with(this).load(url).into(image);

        TextView titleView = findViewById(R.id.titleInExplore);
        titleView.setText(title);
        TextView detailsView = findViewById(R.id.newsInExplore);
        detailsView.setText(content);
*/

        WebView webview=findViewById(R.id.webView);
        webview.loadUrl(newsUrl);

    }
}
