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
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.Holder> {
     //private String url[];
    private Context context;
    public static int explorePosition;
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
    public void onBindViewHolder(@NonNull Holder holder, final int position) {

        holder.titleView.setText(SplashScreen.newsList.get(position).getNewsTitle());
        holder.detailsView.setText(SplashScreen.newsList.get(position).getNewsDetail());
        Glide.with(context).load(SplashScreen.newsList.get(position).getNewsImageUrl()).into(holder.imgView);

         holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.exploreButtonId)
                explorePosition= position;
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
        Button explore;

        public Holder(View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.imgID);
            titleView = itemView.findViewById(R.id.titleTextViewID);
            detailsView = itemView.findViewById(R.id.detailsTextViewID);
            explore=itemView.findViewById(R.id.exploreButtonId);

        }
    }




}
