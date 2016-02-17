package xyz.moechat.sqlitedoing.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import xyz.moechat.sqlitedoing.Activity.showtable;
import xyz.moechat.sqlitedoing.R;

public class MainActivity extends  Activity implements DialogInterface.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which){
            case R.id.showtable:{
                Button btn_showtable=(Button)findViewById(R.id.showtable);
                btn_showtable.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(MainActivity.this, showtable.class);
                        startActivity(intent);
                    }
                });
            }
        }
    }
}
