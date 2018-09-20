package com.news.abhishek.newsapp;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.Holder> {
    //private String url[];
    private Context context;

    public AdapterRecyclerView(Context context) {
        this.context = context;
        // this.url = list;

    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(parent.getContext());
        View view = inflate.inflate(R.layout.recyclerview_row, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int position) {

        holder.titleView.setText(SplashScreen.newsList.get(position).getNewsTitle());
        holder.detailsView.setText(SplashScreen.newsList.get(position).getNewsDetail());
        Glide.with(context).load(SplashScreen.newsList.get(position).getNewsImageUrl()).into(holder.imgView);

        //holder.hiddenUrl.setText(SplashScreen.newsList.get(position).getNewsUrl());

        holder.explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), newsExplore.class);
                myIntent.putExtra("newsUrl", SplashScreen.newsList.get(position).getNewsUrl());
                v.getContext().startActivity(myIntent);
            }
        });

        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "This news is shared using Abhishek News app :: " + "\n\n" + SplashScreen.newsList.get(position).getNewsUrl() + "\n\n Follw him on GitHub : https://github.com/Abhi5h3k";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                v.getContext().startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

    @Override
    public int getItemCount() {
        return SplashScreen.newsList.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        ImageView imgView;
        TextView titleView;
        TextView detailsView;
        TextView hiddenUrl;
        Button explore;
        Button share;

        public Holder(View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.imgID);
            titleView = itemView.findViewById(R.id.titleTextViewID);
            detailsView = itemView.findViewById(R.id.detailsTextViewID);
            explore = itemView.findViewById(R.id.exploreButtonId);
            share = itemView.findViewById(R.id.shareButtonId);
            hiddenUrl = itemView.findViewById(R.id.hiddenUrl);


        }
    }


}
