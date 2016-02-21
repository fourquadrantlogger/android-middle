package xyz.moechat.sqlitedoing.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.TextView;

import xyz.moechat.sqlitedoing.R;

/**
 * Created by timeloveboy on 16/2/21.
 */
public class Dialogmessage {

    Activity parentview;
    AlertDialog dialog;
    TextView textView_message;

    public Button getButton_confirm() {
        return button_confirm;
    }

    public void setButton_confirm(Button button_confirm) {
        this.button_confirm = button_confirm;
    }
    public static final int NOSHOW=0,SHOW_CONFIRM=1,SHOW_CANCEL=2,SHOW_CONFIRM_CANCEL=3;
    Button button_confirm;

    public Button getButton_cancel() {
        return button_cancel;
    }

    public void setButton_cancel(Button button_cancel) {
        this.button_cancel = button_cancel;
    }

    Button button_cancel;
    public Dialogmessage(Activity parentview,String message,int SHOW) {

        this.parentview=parentview;
        dialog= new AlertDialog.Builder(parentview).create();//创建一个AlertDialog对象
        View view = LayoutInflater.from(parentview).inflate(R.layout.dialogmessage, null);//自定义布局
        dialog.setView(view, 0, 0, 0, 0);//把自定义的布局设置到dialog中，注意，布局设置一定要在show之前。从第二个参数分别填充内容与边框之间左、上、右、下、的像素

        textView_message=(TextView)view.findViewById(R.id.textView_message);
        textView_message.setText(message);

        button_confirm=(Button)view.findViewById(R.id.button_confirm);
        button_cancel=(Button)view.findViewById(R.id.button_cancel);
        switch (SHOW){
            case 0:button_confirm.setVisibility(View.GONE);
                button_cancel.setVisibility(View.GONE);
                break;
            case 1:button_cancel.setVisibility(View.GONE);
                break;
            case 2:button_confirm.setVisibility(View.GONE);
                break;
            case 3:break;
        }
    }

    public void show(){

        dialog.show();//一定要先show出来再设置dialog的参数，不然就不会改变dialog的大小了
        int width = parentview.getWindowManager().getDefaultDisplay().getWidth();//得到当前显示设备的宽度，单位是像素
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();//得到这个dialog界面的参数对象
        params.width = width-(width/6);//设置dialog的界面宽度
        params.height =  AbsListView.LayoutParams.WRAP_CONTENT;//设置dialog高度为包裹内容
        params.gravity = Gravity.CENTER;//设置dialog的重心
        //dialog.getWindow().setLayout(width-(width/6),  LayoutParams.WRAP_CONTENT);//用这个方法设置dialog大小也可以，但是这个方法不能设置重心之类的参数，推荐用Attributes设置
        dialog.getWindow().setAttributes(params);//最后把这个参数对象设置进去，即与dialog绑定
    }

    public void close(){
        dialog.dismiss();
    }
}
