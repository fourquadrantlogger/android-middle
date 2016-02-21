package xyz.moechat.sqlitedoing.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;

import xyz.moechat.sqlitedoing.R;

/**
 * Created by timeloveboy on 16/2/20.
 */
public class viewproject_edit extends LinearLayout {
    public viewproject_edit(Context context, AttributeSet attrs) {
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.viewproject_edit, this);
        initViews();
    }
    void initViews(){
        editText_project=(EditText)findViewById(R.id.editText_project);
        editText_score=(EditText)findViewById(R.id.editText_score);
    }
    EditText editText_project,editText_score;

}
