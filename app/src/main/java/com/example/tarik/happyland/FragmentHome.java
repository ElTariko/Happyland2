package com.example.tarik.happyland;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tarik.happyland.FragmentEdm;

public class FragmentHome extends Fragment {
    View view;

    private Button edmButton;
    private Button tranceButton;
    private Button psyButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_home, container, false);

        edmButton = (Button) view.findViewById(R.id.edmButton);
        edmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, new FragmentEdm()).commit();
            }
        });
        tranceButton = (Button) view.findViewById(R.id.tranceButton);
        tranceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, new FragmentTrance()).commit();
            }
        });
        psyButton = (Button) view.findViewById(R.id.psyButton);
        psyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, new FragmentPsy()).commit();
            }
        });
        return view;
    }
}
