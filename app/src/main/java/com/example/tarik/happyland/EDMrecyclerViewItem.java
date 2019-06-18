package com.example.tarik.happyland;

public class EDMrecyclerViewItem {
    public String podcastName;
    public String podcastTime;
    public String podcastDj;
    public String musicUrl;

    public EDMrecyclerViewItem() {
    }

    public EDMrecyclerViewItem(String podcastName, String podcastTime, String podcastDj,String musicUrl) {
        this.podcastName = podcastName;
        this.podcastTime = podcastTime;
        this.podcastDj = podcastDj;
        this.musicUrl = musicUrl;
    }
}
