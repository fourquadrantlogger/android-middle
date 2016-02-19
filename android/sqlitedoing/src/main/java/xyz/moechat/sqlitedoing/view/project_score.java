package xyz.moechat.sqlitedoing.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import xyz.moechat.sqlitedoing.R;
import xyz.moechat.sqlitedoing.model.Projectscore;

/**
 * Created by timeloveboy on 16/2/20.
 */
public class project_score extends LinearLayout {
    public project_score(Context context, AttributeSet attrs ,View view) {
        super(context,attrs);
        this.editText_project=(EditText)view.findViewById(R.id.editText_project);
        this.editText_score=(EditText)view.findViewById(R.id.editText_score);
    }

    public project_score(Context context, AttributeSet attrs) {
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.project_score, this);

        initViews();
    }
    void initViews(){
        editText_project=(EditText)findViewById(R.id.editText_project);
        editText_score=(EditText)findViewById(R.id.editText_score);


    }
    EditText editText_project,editText_score;
    public void setproject_score(Projectscore p){
        editText_project.setText(p.getProject());
        editText_score.setText(Integer.toString(p.getScore()));
    }
    public Projectscore getproject_score(){
        Projectscore p=new Projectscore("",0);
        p.setProject(editText_project.getText().toString());
        p.setScore(Integer.parseInt(editText_score.getText().toString()));
        return p;
    }
}
