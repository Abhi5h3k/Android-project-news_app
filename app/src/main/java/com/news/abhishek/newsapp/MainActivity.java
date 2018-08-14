package com.news.abhishek.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recycler = findViewById(R.id.recyclerID);

        String links[] = {"http://press.gettyimages.com/wp-content/uploads/2018/04/GettyImages-860827376-537x350.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-RDjpGmhSugzvHx56mWtXpVs5AvUCy7Zw7fT4hGd2vKy4FFC8",
                "https://cdn.images.express.co.uk/img/dynamic/80/590x/Mars-news-UFO-space-spacecraft-Medusae-Fossae-Formation-977668.jpg?r=1533562611012"};
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new AdapterRecyclerView(MainActivity.this, links) {
        });
    }
}
