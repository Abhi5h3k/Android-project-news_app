package com.news.abhishek.newsapp;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.Holder> {

    private String url[];
    private Context context;

    public  AdapterRecyclerView(Context context,String list[]){
        this.context=context;
        this.url = list;

    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(parent.getContext());
        View view = inflate.inflate(R.layout.recyclerview_row, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        String address= url[position];
        holder.tv.setText(url[position]);
        Glide.with(context).load(address).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return url.length;    }

    public static class Holder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView tv;

        public Holder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.imgID);
            tv = (TextView) itemView.findViewById(R.id.textID);
        }
    }
}
