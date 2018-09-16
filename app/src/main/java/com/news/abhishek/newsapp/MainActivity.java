package com.news.abhishek.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity  {


    //data
    /*String links[] = {"http://press.gettyimages.com/wp-content/uploads/2018/04/GettyImages-860827376-537x350.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-RDjpGmhSugzvHx56mWtXpVs5AvUCy7Zw7fT4hGd2vKy4FFC8",
            "https://cdn.images.express.co.uk/img/dynamic/80/590x/Mars-news-UFO-space-spacecraft-Medusae-Fossae-Formation-977668.jpg?r=1533562611012", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfOH1wx2Mahb_D09jyrgTSE10Ut_PoIcLitwdXdCcwQEiUv4mp"
            , "https://www.aljazeera.com/mritems/imagecache/mbdxxlarge/mritems/Images/2018/8/2/4e1c7e1718684757b6550c92690f48b6_18.jpg",
            "https://www.fairobserver.com/wp-content/uploads/2018/04/Narendra-Modi-news-Indian-news-India-news-1-938x450.jpg"};*/
    //

    RecyclerView recycler;

    //setup navigation drawer
    Toolbar toolBar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupNavigaationDrawer();

        recycler = findViewById(R.id.recyclerID);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new AdapterRecyclerView(MainActivity.this) {
        });
    }


    private void setupNavigaationDrawer() {

        // 1 Set the toolbar as the action bar
        toolBar = findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);

        //2 Add the nav drawer button
        ActionBar actionBar = getSupportActionBar();
        // 3 arrow ajani
        actionBar.setDisplayHomeAsUpEnabled(true);
        //4 ab arrow ke jgha (the icon is 3 horizontal lines).
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_drag_indicator_24px);
        //5
        drawerLayout = findViewById(R.id.drawerLayout);


        //6 set item click
        navigationView = findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // set item as selected to persist highlight
                item.setChecked(true);
                // close drawer when item is tapped
                drawerLayout.closeDrawers();

                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here

                //create toast
                Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }


    //5 open drawer on hamburger click
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {

            case android.R.id.home: {
                drawerLayout.openDrawer(GravityCompat.START);
                return true;//https://stackoverflow.com/questions/5719287/should-android-onoptionsitemselected-return-true-or-false#
            }
        }
        return super.onOptionsItemSelected(item);
    }


    public void explore(View v){
        Intent intent = new Intent(this, newsExplore.class);

      /*  intent.putExtra("title",SplashScreen.newsList.get(AdapterRecyclerView.explorePosition).getNewsTitle());
        intent.putExtra("content",SplashScreen.newsList.get(AdapterRecyclerView.explorePosition).getContent());
        intent.putExtra("url",SplashScreen.newsList.get(AdapterRecyclerView.explorePosition).getNewsImageUrl());*/
        intent.putExtra("newsUrl",SplashScreen.newsList.get(AdapterRecyclerView.explorePosition).getNewsUrl());

        // Toast.makeText(getApplicationContext(),"hello", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void share(View v){

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "This news is shared using Abhishek News app :: "+"\n\n"+SplashScreen.newsList.get(AdapterRecyclerView.explorePosition).getNewsUrl();
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));

    }
}



