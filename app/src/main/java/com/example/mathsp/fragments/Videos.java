package com.example.mathsp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.mathsp.R;
import com.example.mathsp.extras.MediaObject;
import com.example.mathsp.extras.Resources;
import com.example.mathsp.extras.VerticalSpacingItemDecorator;
import com.example.mathsp.extras.VideoPlayerRecyclerAdapter;
import com.example.mathsp.extras.VideoPlayerRecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class Videos extends Fragment {

    private VideoPlayerRecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_videos, container, false);
        mRecyclerView =v.findViewById(R.id.recycler_view);

        initRecyclerView();
        return v;
    }

    private void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(itemDecorator);

        ArrayList<MediaObject> mediaObjects = new ArrayList<MediaObject>(Arrays.asList(Resources.MEDIA_OBJECTS));
        mRecyclerView.setMediaObjects(mediaObjects);
        VideoPlayerRecyclerAdapter adapter = new VideoPlayerRecyclerAdapter(mediaObjects, initGlide());
        mRecyclerView.setAdapter(adapter);
    }

    private RequestManager initGlide(){
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.white_background)
                .error(R.drawable.white_background);

        return Glide.with(this)
                .setDefaultRequestOptions(options);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mRecyclerView!=null)
            mRecyclerView.releasePlayer();
    }

    @Override
    public void onPause() {
        super.onPause();
        if(mRecyclerView!=null)
            mRecyclerView.releasePlayer();
    }
}