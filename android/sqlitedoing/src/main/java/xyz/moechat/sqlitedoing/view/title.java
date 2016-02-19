package xyz.moechat.sqlitedoing.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import xyz.moechat.sqlitedoing.R;

/**
 * Created by timeloveboy on 16/2/19.
 */
public class title extends LinearLayout {
    public title(Context context,AttributeSet attributeSet) {
        super(context,attributeSet);
        LayoutInflater.from(context).inflate(R.layout.title, this);

        initViews();
    }
    void initViews(){
        textView_title=(TextView)findViewById(R.id.textView_title);
    }
    TextView textView_title;
    public void settitle(String title){
        textView_title.setText(title);
    }
}
