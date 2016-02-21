package xyz.moechat.sqlitedoing.presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import xyz.moechat.sqlitedoing.R;
import xyz.moechat.sqlitedoing.model.Student;

/**
 * Created by timeloveboy on 16/2/21.
 */
public class Adapterstudent extends ArrayAdapter<Student> {
    public Adapterstudent(Context context, int resource, List<Student> objects) {
        super(context, resource, objects);
        this.resource=resource;
    }
    int resource;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Student student=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resource, null);

        TextView textView_stuid=(TextView)view.findViewById(R.id.textView_stuid);
        TextView textView_stuname=(TextView)view.findViewById(R.id.textView_stuname);

        textView_stuid.setText(Integer.toString(student.getSduid()));
        textView_stuname.setText(student.getName());

        return view;
    }
}
