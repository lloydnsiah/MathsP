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

        arrayList.add(new QuestionsObject("1",R.string.questions,"5","4","10","1","10"));
        arrayList.add(new QuestionsObject("2",R.string.question_2,"b_n = 20 - 2n","b_n = 22 - 2n","b_n = 18 - 2n","b_n = 18n","b_n = 22 - 2n"));
        arrayList.add(new QuestionsObject("3",R.string.question_3, "5, 2, -1, -4, -7, -10, -13, -16, -19...", "4, 4, 4, 4, 4, 4, 4, 4, 4...", "2.13, 3.34, 4.55, 5.76, 6.97, 8.18, 9.39, 10.6, 11.81...", "1, 1, 2, 3, 5, 8, 13, 21, 34...", "1, 1, 2, 3, 5, 8, 13, 21, 34..."));
        arrayList.add(new QuestionsObject("4",R.string.question_4,"It will be prime", "It will be a perfect square", "It will be odd", "It will be even.", "It will be a perfect square"));



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