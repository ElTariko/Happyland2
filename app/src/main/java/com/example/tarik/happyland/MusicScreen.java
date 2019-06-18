package com.example.tarik.happyland;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;

public class MusicScreen extends Fragment {
    View view;
    Button playPause;
    MediaPlayer sound;
    SeekBar seekBar;
    //ileri ve geri butonlarım
    //Button back, next;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_music_screen, container, false);

        Gson gson = new Gson();
        String value = getArguments().getString("Track", "Null");
        recyclerViewItem recyclerViewItem = gson.fromJson(value, recyclerViewItem.class);
        playPause = (Button) view.findViewById(R.id.startStopButton);//oynatDUraklat butonumu tanımlıyorum.

        TextView DJName = view.findViewById(R.id.podcastEpisodeTV); //çalan müziğin sanatçısını nerede göstereceği.
        TextView PodcastName = view.findViewById(R.id.podcastNameTV); //çalan müziğin adını nerede göstereceği.

        PodcastName.setText(recyclerViewItem.podcastName); //çalan müziğin sanatçısını göstermek için.
        DJName.setText(recyclerViewItem.podcastDj); //çalan müziğin adını göstermek için.

        //ileri ve geri butonlarım
        //back = (Button) view.findViewById((R.id.backButton));
        //next = (Button) view.findViewById(R.id.nextButton);

        /*
        final MediaPlayer sound = MediaPlayer.create(getActivity(), R.raw.tiesto_titanic);

        el ile eklediğim müziği çalmak için TEST amaçlı. //res
        */

        playPause.setOnClickListener(new View.OnClickListener() {//butona tıklandığında şunları yap
            @Override
            public void onClick(View v) {
                if (sound.isPlaying()) {//eğer çalışıyorsa
                    sound.pause();//duraklat

                    playPause.setBackgroundResource(R.drawable.ic_play_button);//arkaplanı değiştir
                } else {
                    //sound.setLooping(true);//başa sarması için
                    sound.start();//başlat
                    playPause.setBackgroundResource(R.drawable.ic_pause_button);//arkaplanı değiştir
                }
            }
        });

        sound = new MediaPlayer();
        try {
            sound.setDataSource(recyclerViewItem.musicUrl);
            sound.prepareAsync();
            sound.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
        } catch (IOException e) {
            Log.wtf("Error", e.getMessage());
        }

        return view;
    }
}
