package com.example.mathsp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathsp.Details;
import com.example.mathsp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Explanation extends Fragment {
    private TextView txt;
    private String topic;
    private DatabaseReference reference;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_explanation, container, false);

        txt = v.findViewById(R.id.explanation_txt);
        topic = Details.topic;

//        if (topic.equals("Arithmetic")){
//            txt.setText(R.string.Arithmetic);
//        }else if(topic.equals("Number Properties")){
//            txt.setText(R.string.numberproperty);
//        }else {
//            txt.setText(topic);
//        }

        reference = FirebaseDatabase.getInstance().getReference().child(topic);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String data = "";
                for (DataSnapshot snap :snapshot.getChildren()){
                   data = snap.getValue().toString();
                }
                txt.setText(data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });



        return v;
    }
}