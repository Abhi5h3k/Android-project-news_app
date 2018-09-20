package com.news.abhishek.newsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class about_dev extends AppCompatActivity {
    ImageView github;
    ImageView linkedin;
    ImageView stackoverflow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_dev);

        github = findViewById(R.id.github);
        linkedin = findViewById(R.id.linkedin);
        stackoverflow = findViewById(R.id.stackoverflow);


        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent myIntent = new Intent(v.getContext(), newsExplore.class);
                myIntent.putExtra("newsUrl", "https://github.com/Abhi5h3k");
                v.getContext().startActivity(myIntent);*/
                String url = "https://github.com/Abhi5h3k";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent myIntent = new Intent(v.getContext(), newsExplore.class);
                myIntent.putExtra("newsUrl", "https://www.linkedin.com/in/abhishek-bhardwaj-b16764166");
                v.getContext().startActivity(myIntent);*/
                String url = "https://www.linkedin.com/in/abhishek-bhardwaj-b16764166";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        stackoverflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   Intent myIntent = new Intent(v.getContext(), newsExplore.class);
                myIntent.putExtra("newsUrl", "https://stackoverflow.com/users/6870223/abhi?tab=profile");
                v.getContext().startActivity(myIntent);*/
                String url = "https://stackoverflow.com/users/6870223/abhi?tab=profile";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}
