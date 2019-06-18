package com.example.tarik.happyland;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;

public class tranceAdapter extends RecyclerView.Adapter<tranceViewHolder> {
    ArrayList<TrancerecyclerViewItem> podcastList;
    Context context;
    FragmentManager fragmentManager;

    public tranceAdapter(ArrayList<TrancerecyclerViewItem> podcastList, Context context, FragmentManager fragmentManager) {
        this.podcastList = podcastList;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public tranceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recylerview_item, viewGroup, false);
        tranceViewHolder tranceViewHolder = new tranceViewHolder(view);
        return tranceViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull tranceViewHolder tranceViewHolder, int i) {
        final TrancerecyclerViewItem recyclerViewItem = podcastList.get(i);
        tranceViewHolder.podcastName.setText(recyclerViewItem.podcastName);
        tranceViewHolder.podcastTime.setText(recyclerViewItem.podcastTime);
        tranceViewHolder.podcastDj.setText((recyclerViewItem.podcastDj));
        tranceViewHolder.playButtonCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Gson gson = new Gson();
                bundle.putString("Track", gson.toJson(recyclerViewItem, TrancerecyclerViewItem.class));
                MusicScreen musicScreen = new MusicScreen();
                musicScreen.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.content_frame, musicScreen).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return podcastList.size();
    }
}
