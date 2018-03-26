package com.ankithacks.ipwebcam;

import android.app.ProgressDialog;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {


    private static ProgressDialog progressDialog;
    String videourl="You video url"; //It should be 3gp or mp4
    VideoView videoView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*

        VideoView videoView=(VideoView)findViewById(R.id.videoView);

        //setting media controller

        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(videoView);

        //set the url of the video

        Uri uri =Uri.parse("https://10.190.8.253:8080");

        //setting the video

        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();*/

        /* videoView = (VideoView) findViewById(R.id.videoView);

        progressDialog = ProgressDialog.show(MainActivity.this, "", "Buffering video...",true);
        progressDialog.setCancelable(false);


        PlayVideo(); */

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("http://192.168.43.160:8080");
        final WebSettings settings=myWebView.getSettings();
        settings.setJavaScriptEnabled(true);
    }

    private void PlayVideo()
    {
        try
        {
            getWindow().setFormat(PixelFormat.TRANSLUCENT);
            MediaController mediaController = new MediaController(MainActivity.this);
            mediaController.setAnchorView(videoView);

            Uri video = Uri.parse("http://techslides.com/demos/sample-videos/small.mp4");
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(video);
            videoView.requestFocus();
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
            {

                public void onPrepared(MediaPlayer mp)
                {
                    progressDialog.dismiss();
                    videoView.start();
                }
            });

        }
        catch(Exception e)
        {
            progressDialog.dismiss();
            System.out.println("Video Play Error :"+e.toString());
            finish();

        }

    }
}
