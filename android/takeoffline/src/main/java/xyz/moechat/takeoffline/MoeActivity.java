package xyz.moechat.takeoffline;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by timeloveboy on 16/2/12.
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
        ActivityCollector.removeActivity(this);
    }
}
