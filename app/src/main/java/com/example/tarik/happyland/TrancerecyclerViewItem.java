package com.example.tarik.happyland;

public class TrancerecyclerViewItem {
    public String podcastName;
    public String podcastTime;
    public String podcastDj;
    public String musicUrl;

    public TrancerecyclerViewItem() {
    }

    public TrancerecyclerViewItem(String podcastName, String podcastTime, String podcastDj, String musicUrl) {
        this.podcastName = podcastName;
        this.podcastTime = podcastTime;
        this.podcastDj = podcastDj;
        this.musicUrl = musicUrl;
    }
}
