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

public class psyAdapter extends RecyclerView.Adapter<psyViewHolder> {
    ArrayList<PSYrecyclerViewItem> podcastList;
    Context context;
    FragmentManager fragmentManager;

    public psyAdapter(ArrayList<PSYrecyclerViewItem> podcastList, Context context, FragmentManager fragmentManager) {
        this.podcastList = podcastList;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public psyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recylerview_item, viewGroup, false);
        psyViewHolder psyViewHolder = new psyViewHolder(view);
        return psyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull psyViewHolder psyViewHolder, int i) {
        final PSYrecyclerViewItem recyclerViewItem = podcastList.get(i);
        psyViewHolder.podcastName.setText(recyclerViewItem.podcastName);
        psyViewHolder.podcastTime.setText(recyclerViewItem.podcastTime);
        psyViewHolder.podcastDj.setText(recyclerViewItem.podcastDj);
        psyViewHolder.playButtonCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Gson gson = new Gson();
                bundle.putString("Track", gson.toJson(recyclerViewItem, PSYrecyclerViewItem.class));
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
