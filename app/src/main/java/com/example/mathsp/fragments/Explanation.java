package com.example.mathsp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathsp.Details;
import com.example.mathsp.R;

public class Explanation extends Fragment {
    private TextView txt;
    private String topic;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_explanation, container, false);

        txt = v.findViewById(R.id.explanation_txt);
        topic = Details.topic;

        if (topic.equals("Arithmetic")){
            txt.setText(R.string.Arithmetic);
        }else if(topic.equals("Number Properties")){
            txt.setText(R.string.numberproperty);
        }else {
            txt.setText(topic);
        }

        return v;
    }
}