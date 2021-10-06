package com.example.mathsp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mathsp.R;
import com.example.mathsp.adapters.NotesAdapter;
import com.example.mathsp.adapters.QuestionsAdapter;
import com.example.mathsp.extras.QuestionsObject;

import java.util.ArrayList;

public class Questions extends Fragment {
    private LinearLayout linear1;
    private Button submit;
    private RecyclerView recyclerView;
    private QuestionsAdapter adapter;
    private Context context;
    private ArrayList<QuestionsObject> arrayList;
    private TextView totalque;
    private int questions = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View v = inflater.inflate(R.layout.fragment_questions, container, false);
       linear1 = v.findViewById(R.id.linear_questions);
       context = getContext();
       submit = v.findViewById(R.id.btn_submit_ans);
       recyclerView = v.findViewById(R.id.recycler_view_questions);
       arrayList = new ArrayList<>();
       totalque = v.findViewById(R.id.total_questions);

        arrayList.add(new QuestionsObject("1","Questions number","A","B","C","D","ANS"));
        arrayList.add(new QuestionsObject("1","Questions number","A","B","C","D","ANS"));
        arrayList.add(new QuestionsObject("1","Questions number","A","B","C","D","ANS"));
        arrayList.add(new QuestionsObject("1","Questions number","A","B","C","D","ANS"));
        arrayList.add(new QuestionsObject("1","Questions number","A","B","C","D","ANS"));
        arrayList.add(new QuestionsObject("1","Questions number","A","B","C","D","ANS"));


        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter =new QuestionsAdapter(context,arrayList,questions);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

       submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (submit.getText().equals("Submit")){
               linear1.setVisibility(View.VISIBLE);
               submit.setText("Cancel");
               totalque.setText(String.valueOf(arrayList));
               }else if (submit.getText().equals("Cancel")){
                   linear1.setVisibility(View.INVISIBLE);
                   submit.setText("Submit");
               }
           }
       });
       return v;
    }
}