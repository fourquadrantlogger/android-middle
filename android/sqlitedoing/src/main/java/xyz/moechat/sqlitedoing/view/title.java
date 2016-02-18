package xyz.moechat.sqlitedoing.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import xyz.moechat.sqlitedoing.R;

/**
 * Created by timeloveboy on 16/2/19.
 */
public class title extends LinearLayout {
    public title(Context context,AttributeSet attributeSet) {
        super(context,attributeSet);
        LayoutInflater.from(context).inflate(R.layout.title, this);
    }
}
