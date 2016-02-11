package xyz.moechat.takeoffline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by timeloveboy on 16/2/12.
 */
public class MainActivity extends MoeActivity {
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        Button forceOffline=(Button)findViewById(R.id.force_offline);
        forceOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("xyz.moechat.takeoffline.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}
