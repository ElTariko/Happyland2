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

public class FragmentEdm extends Fragment {
    View view;
    RecyclerView recyclerView;
    ArrayList<EDMrecyclerViewItem> recyclerViewItems;
    DatabaseReference databaseReference;
    edmAdapter podcastAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_edm, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recylerview);
        recyclerViewItems = new ArrayList<EDMrecyclerViewItem>();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        podcastAdapter = new edmAdapter(recyclerViewItems, getActivity(), getFragmentManager());
        recyclerView.setAdapter(podcastAdapter);

        databaseReference.child("Edm").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                recyclerViewItems.clear();
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    EDMrecyclerViewItem item = childSnapshot.getValue(EDMrecyclerViewItem.class);
                    recyclerViewItems.add(item);
                }
                podcastAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        /*
        EDMrecyclerViewItem item = new EDMrecyclerViewItem("Deneme", "12:53", "Tiesto", "asasas");
        String key = databaseReference.push().getKey();
        databaseReference.child("Edm").child(key).setValue(item);
        */
        return view;
    }
}
