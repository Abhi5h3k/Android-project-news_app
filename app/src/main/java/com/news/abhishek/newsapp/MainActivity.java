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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


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
        actionBar.setHomeAsUpIndicator(R.drawable.icons8_menu_30);
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
                switch (item.getItemId()) {

                    case R.id.aboutDev: {

                        Intent myIntent = new Intent(MainActivity.super.getBaseContext(), about_dev.class);
                        startActivity(myIntent);

                        break;
                    }

                    case R.id.share: {
                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        String shareBody = "\nApp project is available at :\n\nGitHub : https://github.com/Abhi5h3k/Android-project-news_app \n Follw him on GitHub : https://bit.ly/2Nuv1O8";
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(sharingIntent, "Share via"));
                        break;
                    }

                    default: { //create toast
                        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();

                    }
                }

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


}



