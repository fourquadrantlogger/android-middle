package xyz.moechat.sqlitedoing.presenter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import xyz.moechat.sqlitedoing.R;
import xyz.moechat.sqlitedoing.model.Project;

/**
 * Created by timeloveboy on 16/2/20.
 */
public class Adapterproject_edit extends ArrayAdapter<Project> {
    public Adapterproject_edit(Context context, int resource, List<Project> objects) {
        super(context, resource,objects);
        this.resource=resource;
    }
    int resource;

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        Project project=getItem(position);
        View view=LayoutInflater.from(getContext()).inflate(resource,null);

        final EditText editText_project=(EditText)view.findViewById(R.id.editText_project);
        editText_project.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ArrayList<Project> projectList = (ArrayList<Project>) parent.getTag();
                projectList.get(position).setProjectname(s.toString());
            }
        });
        final EditText editText_score=(EditText)view.findViewById(R.id.editText_score);

        editText_project.setText(project.getProjectname());
        editText_score.setText(Integer.toString(project.getScore()));

        editText_score.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ArrayList<Project> projectList = (ArrayList<Project>) parent.getTag();
                String score = s.toString();
                if (score == null || score.equals("")) {
                    score = "0";
                    Log.v("moe",score);
                }
                projectList.get(position).setScore(Integer.parseInt(score));
            }
        });
        return view;
    }
}
