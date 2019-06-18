package com.example.tarik.happyland;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;

public class edmAdapter extends RecyclerView.Adapter<edmViewHolder> {
    ArrayList<EDMrecyclerViewItem> podcastList;
    Context context;
    FragmentManager fragmentManager;

    public edmAdapter(ArrayList<EDMrecyclerViewItem> podcastList, Context context, FragmentManager fragmentManager) {
        this.podcastList = podcastList;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public edmViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recylerview_item, viewGroup, false);
        edmViewHolder edmViewHolder = new edmViewHolder(view);
        return edmViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull edmViewHolder edmViewHolder, int i) {
        final EDMrecyclerViewItem recyclerViewItem = podcastList.get(i);
        edmViewHolder.podcastName.setText(recyclerViewItem.podcastName);
        edmViewHolder.podcastTime.setText(recyclerViewItem.podcastTime);
        edmViewHolder.podcastDj.setText(recyclerViewItem.podcastDj);
                edmViewHolder.playButtonCardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        Gson gson = new Gson();
                        bundle.putString("Track", gson.toJson(recyclerViewItem, EDMrecyclerViewItem.class));
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
