package com.example.mathsp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathsp.R;
import com.example.mathsp.extras.QuestionsObject;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.ViewHolder> {
    private Context context;
    private ArrayList<QuestionsObject> arrayList;
    private int marks;

    public QuestionsAdapter(Context context, ArrayList<QuestionsObject> arrayList,int marks) {
        this.context = context;
        this.arrayList = arrayList;
        this.marks = marks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.questions_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.qnum.setText("Q" + arrayList.get(position).getQuesNo());
        holder.question.setText(arrayList.get(position).getQuestion());
        holder.ans1.setText(arrayList.get(position).getAns_one());
        holder.ans2.setText(arrayList.get(position).getAns_two());
        holder.ans3.setText(arrayList.get(position).getAns_three());
        holder.ans4.setText(arrayList.get(position).getAns_four());




    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView qnum,question;
        private RadioGroup radioGroup;
        private RadioButton ans1,ans2,ans3,ans4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            qnum = itemView.findViewById(R.id.ques_no);
            question = itemView.findViewById(R.id.questions);
            radioGroup = itemView.findViewById(R.id.answers_rg);
            ans1 = itemView.findViewById(R.id.answer_1);
            ans2 = itemView.findViewById(R.id.answer_2);
            ans3 = itemView.findViewById(R.id.answer_3);
            ans4 = itemView.findViewById(R.id.answer_4);

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Toast.makeText(context,"Okay", Toast.LENGTH_SHORT).show();
                    marks++;
                }
            });
        }
    }
}
