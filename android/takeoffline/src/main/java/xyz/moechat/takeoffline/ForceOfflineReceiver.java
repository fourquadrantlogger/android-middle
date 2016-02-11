package xyz.moechat.takeoffline;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

/**
 * Created by timeloveboy on 16/2/12.
 */
public class ForceOfflineReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        AlertDialog.Builder dialog =new AlertDialog.Builder(context);
        dialog.setTitle("下线通知");
        dialog.setMessage(" 您的账号已经在另一台设备登录 ");
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            //确认按钮的点击事件
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog,int which){}
        });
        dialog.show();
    }
}
