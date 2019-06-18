package com.example.tarik.happyland;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class tranceViewHolder extends RecyclerView.ViewHolder {
    TextView podcastName;
    TextView podcastTime;
    TextView podcastDj;
    ImageView playButtonImage;
    CardView playButtonCardView;

    public tranceViewHolder(@NonNull View itemView) {
        super(itemView);
        this.podcastName = itemView.findViewById(R.id.podcastName);
        this.podcastTime = itemView.findViewById(R.id.podcastTime);
        this.podcastDj = itemView.findViewById(R.id.podcastDj);
        this.playButtonImage = itemView.findViewById(R.id.playButtonImage);
        this.playButtonCardView = itemView.findViewById((R.id.cardView));

    }
}
