package com.georgieva.vyara.videostreamsampleapp.Activities;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import com.georgieva.vyara.videostreamsampleapp.R;

public class LivestreamVideoActivity extends AppCompatActivity {

    private int duration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livestream_video);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        String httpLiveUrl = "http://qthttp.apple.com.edgesuite.net/1010qwoeiuryfg/sl.m3u8";




        if(videoView.canSeekForward()){

            if (videoView != null) {
                videoView.setVideoURI(Uri.parse(httpLiveUrl));
                videoView.setMediaController(new MediaController(this));
            }

        }

        videoView.requestFocus();
        videoView.start();
        unmute();
    }

    public void mute() {
        AudioManager am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        am.setStreamMute(AudioManager.STREAM_MUSIC, true);
    }

    public void unmute() {
        AudioManager am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        am.setStreamMute(AudioManager.STREAM_MUSIC, false);
    }
}