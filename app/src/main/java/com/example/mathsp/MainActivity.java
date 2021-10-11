package com.example.mathsp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mathsp.adapters.CustomAdapter;
import com.example.mathsp.adapters.FirstAdapter;
import com.example.mathsp.fragments.Explanation;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayList<String> topicsList = new ArrayList<>();
    private FirstAdapter firstAdapter;
    private ArrayAdapter<String> arrayAdapter;
    private Context context;
    private ListView listView;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        arrayList.add("Angles");
        arrayList.add("Surd");
        arrayList.add("Geometry I");
        arrayList.add("Statistics");
        arrayList.add("Geometry II");
        arrayList.add("Algebra");

        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        firstAdapter = new FirstAdapter(context,arrayList);
        recyclerView.setAdapter(firstAdapter);
        firstAdapter.notifyDataSetChanged();


        reference = FirebaseDatabase.getInstance().getReference().child("Topics");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snap: snapshot.getChildren()){
                    topicsList.add(snap.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        arrayAdapter = new ArrayAdapter<>(this,R.layout.topics_list_txt,arrayList);
        arrayAdapter.notifyDataSetChanged();
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = arrayList.get(position).toString();
                Intent intent = new Intent(context, Details.class);
                intent.putExtra("Topic",data);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

//        CustomAdapter customAdapter = new CustomAdapter(context,topicsList);
//        listView.setAdapter(customAdapter);


    }

    public void init(){
        recyclerView = findViewById(R.id.recyclerview_1);
        context = getApplicationContext();
        listView = findViewById(R.id.listview_1);
    }

}