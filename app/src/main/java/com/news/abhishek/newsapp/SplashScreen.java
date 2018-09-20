package com.news.abhishek.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class SplashScreen extends AppCompatActivity {

    static List<news_Objects> newsList = new ArrayList<>();
    private RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        rq = Volley.newRequestQueue(this);
        jsonParse();


    }


    private void jsonParse() {
        String url = "https://newsapi.org/v2/top-headlines?country=in&apiKey=713465b432e64b05bec7c2b3d4f309dc";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArr = response.getJSONArray("articles");

                    for (int i = 0; i < jsonArr.length(); i++) {
                        JSONObject newsDetail = jsonArr.getJSONObject(i);
                        news_Objects news = new news_Objects();

                        String imtUrl = newsDetail.getString("urlToImage");
                        String title = newsDetail.getString("title");
                        String detail = newsDetail.getString("description");
                        String newsUrl = newsDetail.getString("url");
                        String content = newsDetail.getString("content");


                        news.setNewsImageUrl(imtUrl);
                        news.setNewsTitle(title);
                        news.setNewsDetail(detail);
                        news.setNewsUrl(newsUrl);
                        news.setContent(content);
                        newsList.add(news);


                    }


                    //added here so that is loads after everything is loaded json
                    Intent loadMainActivity = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(loadMainActivity);
                    finish();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        rq.add(request);
    }

}
