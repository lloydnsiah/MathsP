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
        holder.qnum.setText("Q" + arrayList.get(position).getNo());
        holder.question.setText(arrayList.get(position).getQuestion());
        holder.ans1.setText(arrayList.get(position).getAns1());
        holder.ans2.setText(arrayList.get(position).getAns2());
        holder.ans3.setText(arrayList.get(position).getAns3());
        holder.ans4.setText(arrayList.get(position).getAns4());

        holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String answer = "";
                String correct_answer = arrayList.get(position).getCorrectans();
                switch (checkedId){
                    case R.id.answer_1:
                        answer = (String) holder.ans1.getText();
                        break;
                    case R.id.answer_2:
                        answer = (String) holder.ans2.getText();
                        break;
                    case R.id.answer_3:
                        answer = (String) holder.ans3.getText();
                        break;
                    case R.id.answer_4:
                        answer = (String) holder.ans4.getText();
                        break;
                    default:
                }
                if (answer.equals(correct_answer)){
                    Toast.makeText(context, "Correct", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Wrong, Please Try Again", Toast.LENGTH_SHORT).show();
                }
            }
        });
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

        }
    }
}
