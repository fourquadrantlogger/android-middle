package xyz.moechat.sqlitedoing.view;

import android.os.Bundle;

import xyz.moechat.sqlitedoing.R;
import xyz.moechat.sqlitedoing.common.MoeActivity;

/**
 * Created by timeloveboy on 16/2/17.
 */
public class Activityupdate extends MoeActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        initViews();
    }
    void initViews(){
        title=(title)findViewById(R.id.moetitle);
        title.settitle("sqlite update");
    }
    title title;

}
