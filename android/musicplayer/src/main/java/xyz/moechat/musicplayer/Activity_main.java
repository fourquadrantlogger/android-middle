package xyz.moechat.musicplayer;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

public class Activity_main extends Activity  implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    void initViews() {
        button_choose=(Button)findViewById(R.id.button_choose);
        button_choose.setOnClickListener(this);
        button_play=(Button)findViewById(R.id.button_play);
        button_play.setOnClickListener(this);
        button_parse=(Button)findViewById(R.id.button_pause);
        button_parse.setOnClickListener(this);
        button_stop=(Button)findViewById(R.id.button_stop);
        button_stop.setOnClickListener(this);

    }

    MediaPlayer mediaPlayer;
    String mediaPlayerDataSource="";
    Button button_choose,button_play,button_parse,button_stop;

    public static final int RequestCode_CHOOSEMUSIC=1;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case RequestCode_CHOOSEMUSIC: {
                Uri uri=data.getData();
                mediaPlayerDataSource=uri.toString().substring(7);
            }
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_choose:{
                Intent intent=new Intent("android.intent.action.GET_CONTENT");
                intent.setType("audio/*");
                startActivityForResult(intent, RequestCode_CHOOSEMUSIC);
                initMediaPlayer();
                break;
            }
            case R.id.button_play:{
                if(!mediaPlayer.isPlaying()){
                    Log.v("moe","play");
                    mediaPlayer.start();
                }
                break;
            }
            case R.id.button_pause:{
                if(mediaPlayer.isPlaying()) {
                    Log.v("moe", "pause");
                    mediaPlayer.pause();
                }
                break;

            }
            case R.id.button_stop:{
                if(mediaPlayer.isPlaying()) {
                    Log.v("moe","stop");
                    mediaPlayer.reset();
                    initMediaPlayer();
                }

                break;
            }
        }
    }

    private void initMediaPlayer() {
        try {
            mediaPlayer=new MediaPlayer();
            Log.v("moe", mediaPlayerDataSource);
            mediaPlayer.setDataSource(mediaPlayerDataSource);
            mediaPlayer.prepare();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
