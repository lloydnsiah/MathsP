package com.example.mathsp.adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mathsp.R;
import com.example.mathsp.extras.DBHelper;
import com.example.mathsp.extras.NotesObject;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    Context context;
    ArrayList<NotesObject> arrayList;

    public NotesAdapter(Context context, ArrayList<NotesObject> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_list_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.date.setText(arrayList.get(position).getDate());
        holder.topic.setText(arrayList.get(position).getTopic());
        holder.topic2.setText(arrayList.get(position).getTopic());
        holder.details.setText(arrayList.get(position).getDetails());

        holder.down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.linear1.setVisibility(View.GONE);
                holder.linear2.setVisibility(View.VISIBLE);
            }
        });

        holder.up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.linear1.setVisibility(View.VISIBLE);
                holder.linear2.setVisibility(View.GONE);
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Delete entry")
                        .setMessage("Are you sure you want to delete this entry?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                DBHelper db = new DBHelper(context);
                                db.deleteAll();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout linear1;
        private RelativeLayout linear2;
        private TextView date,topic,topic2,details,delete;
        private ImageView up,down;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            linear1 =itemView.findViewById(R.id.linear_2);
            linear2= itemView.findViewById(R.id.linear_3);
            date = itemView.findViewById(R.id.recycler_note_date);
            topic = itemView.findViewById(R.id.recycler_note_Topic);
            topic2 = itemView.findViewById(R.id.recycler_note_Topic_2);
            details = itemView.findViewById(R.id.recycler_note_detail_2);
            up = itemView.findViewById(R.id.recycler_note_arrow_top);
            down =itemView.findViewById(R.id.recycler_note_arrow);
            delete = itemView.findViewById(R.id.recycler_note_delete);
        }
    }
}
