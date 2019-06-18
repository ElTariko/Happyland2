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

public class FragmentPsy extends Fragment {
    View view;
    RecyclerView recyclerView;
    ArrayList<PSYrecyclerViewItem> recyclerViewItems;
    DatabaseReference databaseReference;
    psyAdapter podcastAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_psy, container, false);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        recyclerView = (RecyclerView) view.findViewById(R.id.recylerview);
        recyclerViewItems = new ArrayList<PSYrecyclerViewItem>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        podcastAdapter = new psyAdapter(recyclerViewItems, getActivity(), getFragmentManager());
        recyclerView.setAdapter(podcastAdapter);

        databaseReference.child("Psy").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                recyclerViewItems.clear();
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    PSYrecyclerViewItem item = childSnapshot.getValue(PSYrecyclerViewItem.class);
                    recyclerViewItems.add(item);
                }
                podcastAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        /*
        PSYrecyclerViewItem item = new PSYrecyclerViewItem("Deneme","12:53","Tiesto","asasas");
        String key = databaseReference.push().getKey();
        databaseReference.child("Psy").child(key).setValue(item);
        */
        return view;
    }
}
