package xyz.moechat.sqlitedoing.view;

import android.os.Bundle;
import android.widget.TextView;
import xyz.moechat.sqlitedoing.view.title;
import xyz.moechat.sqlitedoing.R;
import xyz.moechat.sqlitedoing.common.MoeActivity;

/**
 * Created by timeloveboy on 16/2/17.
 */
public class Activityquery extends MoeActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        initViews();
    }
    void initViews(){
        title=(title)findViewById(R.id.moetitle);
        title.settitle("sqlite query");
    }
    title title;

}