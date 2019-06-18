package com.example.tarik.happyland;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FragmentTrance extends Fragment {
    View view;
    RecyclerView recyclerView;
    ArrayList<TrancerecyclerViewItem> recyclerViewItems;
    DatabaseReference databaseReference;
    tranceAdapter podcastAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_trance, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recylerview);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        recyclerViewItems = new ArrayList<TrancerecyclerViewItem>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        podcastAdapter = new tranceAdapter(recyclerViewItems, getActivity(), getFragmentManager());
        recyclerView.setAdapter(podcastAdapter);

        databaseReference.child("Trance").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                recyclerViewItems.clear();
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    TrancerecyclerViewItem item = childSnapshot.getValue(TrancerecyclerViewItem.class);
                    recyclerViewItems.add(item);
                }
                podcastAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        /*
        TrancerecyclerViewItem item = new TrancerecyclerViewItem("Deneme","12:53","Tiesto","asasas");
        String key = databaseReference.push().getKey();
        databaseReference.child("Trance").child(key).setValue(item);
        */
        return view;
    }
}
