package com.example.mathsp.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathsp.R;
import com.example.mathsp.adapters.NotesAdapter;
import com.example.mathsp.extras.DBHelper;
import com.example.mathsp.extras.MediaObject;
import com.example.mathsp.extras.NotesObject;
import com.example.mathsp.extras.Resources;
import com.example.mathsp.extras.VerticalSpacingItemDecorator;
import com.example.mathsp.extras.VideoPlayerRecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class Notes extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<NotesObject> arrayList = new ArrayList<>();
    private NotesAdapter adapter;
    private FloatingActionButton add;
    private DBHelper db;
    private Context context;
    private ImageView img;
    private RelativeLayout r1;
    private BiometricManager manager;
    BiometricPrompt prompt;
    BiometricPrompt.PromptInfo info;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View v= inflater.inflate(R.layout.fragment_notes, container, false);
      context = getContext();
      db = new DBHelper(context);

        recyclerView =v.findViewById(R.id.recycler_view_2);
        add = v.findViewById(R.id.floatingbar);
        r1 = v.findViewById(R.id.notes_linear);
        img = v.findViewById(R.id.image_empty);

        getData();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertmethod();
            }
        });

      return v;
    }

    public void method(){
        manager = BiometricManager.from(getActivity());


        prompt = new BiometricPrompt(this,
                ContextCompat.getMainExecutor(context),
                new BiometricPrompt.AuthenticationCallback() {
                    @Override
                    public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                        super.onAuthenticationError(errorCode, errString);
                    }

                    @Override
                    public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                        super.onAuthenticationSucceeded(result);
                        r1.setVisibility(View.VISIBLE);

                    }

                    @Override
                    public void onAuthenticationFailed() {
                        super.onAuthenticationFailed();
                    }
                });

        info = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biometric")
                .setNegativeButtonText("Cancel").build();

    }

    public void alertmethod(){
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.custom_dialog_new);
        EditText topic = dialog.findViewById(R.id.edit_topic);
        EditText details = dialog.findViewById(R.id.edit_Details);
        Button confirm = dialog.findViewById(R.id.btn_submit);
        Button cancel = dialog.findViewById(R.id.btn_cancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tc = topic.getText().toString();
                String dt = details.getText().toString();
                boolean result =db.insertData(tc,dt);
                if (result){
                    Toast.makeText(context, "Successful", Toast.LENGTH_SHORT).show();
                    getData();
                    dialog.dismiss();
                }else {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.show();
    }

    public void getData(){
        Cursor cursor = db.getData();
        cursor.isBeforeFirst();
        arrayList.clear();
        if (cursor.getCount() == 0){
           img.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            Toast.makeText(context, "No Entry Available", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                String date = cursor.getString(1);
                String topic = cursor.getString(2);
                String details = cursor.getString(3);
                arrayList.add(new NotesObject(date,topic,details));
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            adapter =new NotesAdapter(context,arrayList);
            adapter.notifyDataSetChanged();
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        method();
        prompt.authenticate(info);
    }

}