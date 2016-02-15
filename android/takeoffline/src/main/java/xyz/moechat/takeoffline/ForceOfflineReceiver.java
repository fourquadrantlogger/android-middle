package xyz.moechat.takeoffline;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by timeloveboy on 16/2/12.
 */
public class ForceOfflineReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder dialogBuilder =new AlertDialog.Builder(context);
        dialogBuilder.setTitle("下线通知");
        dialogBuilder.setMessage(" 您的账号已经在另一台设备登录 ");
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton("是我登录", new DialogInterface.OnClickListener() {
            //确认按钮的点击事件
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCollector.finishAll();
                Intent intent = new Intent(context, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//在activity之外startactivity需要一个flag
                context.startActivity(intent);
            }
        });
        dialogBuilder.setNegativeButton("不是我登录", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "已强制对方下线", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog=dialogBuilder.create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);//设置AlertDialog类型，保证在广播接收器中可以正常弹出
        dialog.show();
    }
}
