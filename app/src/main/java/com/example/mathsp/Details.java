package com.example.mathsp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.TextView;

import com.example.mathsp.fragments.Explanation;
import com.example.mathsp.fragments.Notes;
import com.example.mathsp.fragments.Questions;
import com.example.mathsp.fragments.Videos;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Details extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Context context;
    public static String topic;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        init();
        topic = getIntent().getStringExtra("Topic");
        txt.setText(topic);
        MainAdap adapter = new MainAdap(getSupportFragmentManager());
        adapter.addFragment(new Explanation(),"Explanation");
        adapter.addFragment(new Questions(),"Questions");
        adapter.addFragment(new Videos(),"Videos");
        adapter.addFragment(new Notes(),"Notes");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        Intent intent = new Intent(context, Explanation.class);
        intent.putExtra("Topics",topic);

    }

    public void init(){
        context = getApplicationContext();
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        txt = findViewById(R.id.txt_topic_name);
    }

    private class MainAdap extends FragmentPagerAdapter {

        List<Fragment> fragments = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        public void addFragment(Fragment fragment,String s){
            fragments.add(fragment);
            strings.add(s);

        }
        public MainAdap(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return strings.get(position);
        }
    }
}