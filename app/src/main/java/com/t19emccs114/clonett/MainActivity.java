package com.t19emccs114.clonett;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.t19emccs114.clonett.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        getSupportActionBar().hide();

        ArrayList<VideoItem> videoItems = new ArrayList<>();

        VideoItem videoItem1 = new VideoItem();
        videoItem1.videoTitle = "Tiktok";
        videoItem1.videoDescription = "Learn";
        videoItem1.videoURL = "https://liciolentimo.co.ke/img/videos/facebook.mp4";

        VideoItem videoItem2 = new VideoItem();
        videoItem2.videoURL = "http://mediamusic-journal.com/video/Casta%20(2019).mp4";
        videoItem2.videoTitle = "Goku";
        videoItem2.videoDescription = "DBZ";

        VideoItem videoItem3 = new VideoItem();
        videoItem2.videoURL = "https://pixabay.com/videos/id-61695/";
        videoItem2.videoTitle ="tech";
        videoItem2.videoDescription = "techno";

        videoItems.add(videoItem1);
        videoItems.add(videoItem2);
        videoItems.add(videoItem3);

        mainBinding.viewpager2.setAdapter(new VideoAdapter(videoItems));
    }
}

