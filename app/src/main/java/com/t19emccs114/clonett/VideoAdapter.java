package com.t19emccs114.clonett;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder>{

    private List<VideoItem> mvideoItems;

    public VideoAdapter(List<VideoItem> videoItems) {
        mvideoItems = videoItems;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_video,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(mvideoItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mvideoItems.size();
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder{
        VideoView videoView;
        TextView videoTitle,videoDescription;
        ProgressBar progressBar;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            videoView = itemView.findViewById(R.id.videoView);
            videoTitle = itemView.findViewById(R.id.videoTitle);
            videoDescription = itemView.findViewById(R.id.videoDescription);
            progressBar = itemView.findViewById(R.id.progressBar);
        }

        void setVideoData(VideoItem videoItem){
            videoTitle.setText(videoItem.videoTitle);
            videoDescription.setText(videoItem.videoDescription);
            videoView.setVideoPath(videoItem.videoURL);

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    progressBar.setVisibility(View.GONE);
                    mp.start();

                    float videoRate = mp.getVideoWidth()/(float)mp.getVideoHeight();
                    float screenRatio = videoView.getWidth()/(float)videoView.getHeight();
                    float scale = videoRate/screenRatio;

                    if (scale>=1f){
                        videoView.setScaleX(scale);
                    }
                    else{
                        videoView.setScaleY(1f/scale);
                    }
                }
            });

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });

        }

    }
}
