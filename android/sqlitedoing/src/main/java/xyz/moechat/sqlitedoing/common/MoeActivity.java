package xyz.moechat.sqlitedoing.common;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by timeloveboy on 16/2/18.
 */
public class MoeActivity extends Activity {
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        overridePendingTransition(0, 0);
        ActivityCollector.removeActivity(this);
    }
}