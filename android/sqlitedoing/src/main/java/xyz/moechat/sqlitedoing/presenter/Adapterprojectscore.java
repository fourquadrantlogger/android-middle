package xyz.moechat.sqlitedoing.presenter;

import android.content.Context;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.List;

import xyz.moechat.sqlitedoing.R;
import xyz.moechat.sqlitedoing.model.Projectscore;
import xyz.moechat.sqlitedoing.view.project_score;

/**
 * Created by timeloveboy on 16/2/20.
 */
public class Adapterprojectscore extends ArrayAdapter<Projectscore> {
    public Adapterprojectscore(Context context, int resource,List<Projectscore> objects) {
        super(context, resource,objects);
        this.resource=resource;
    }
    int resource;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Projectscore projectscore=getItem(position);
        View view=LayoutInflater.from(getContext()).inflate(resource, null);

        EditText editText_project=(EditText)view.findViewById(R.id.editText_project);
        EditText editText_score=(EditText)view.findViewById(R.id.editText_score);

        editText_project.setText(projectscore.getProject());
        editText_score.setText(Integer.toString(projectscore.getScore()));
        return view;
    }
}
