package xyz.moechat.sqlitedoing.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import xyz.moechat.sqlitedoing.R;
import xyz.moechat.sqlitedoing.common.MoeActivity;

/**
 * Created by timeloveboy on 16/2/18.
 */
public class Activityshowapp extends MoeActivity {
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        setContentView(R.layout.showapp);
    }


    @Override
    protected void onStart() {
        super.onStart();
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(5000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                Intent intent=new Intent(Activityshowapp.this,Activityquery.class);
                startActivity(intent);
            }
        }.start();
    }
}
