package xyz.moechat.sqlitedoing;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;

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
                
            }
        }
    }
}
