package com.news.abhishek.newsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
                "https://cdn.images.express.co.uk/img/dynamic/80/590x/Mars-news-UFO-space-spacecraft-Medusae-Fossae-Formation-977668.jpg?r=1533562611012", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfOH1wx2Mahb_D09jyrgTSE10Ut_PoIcLitwdXdCcwQEiUv4mp"
                , "https://www.aljazeera.com/mritems/imagecache/mbdxxlarge/mritems/Images/2018/8/2/4e1c7e1718684757b6550c92690f48b6_18.jpg",
                "https://www.fairobserver.com/wp-content/uploads/2018/04/Narendra-Modi-news-Indian-news-India-news-1-938x450.jpg"};
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new AdapterRecyclerView(MainActivity.this, links) {
        });
    }
}
