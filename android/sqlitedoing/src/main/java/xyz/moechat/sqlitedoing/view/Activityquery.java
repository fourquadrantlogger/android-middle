package xyz.moechat.sqlitedoing.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import xyz.moechat.sqlitedoing.common.Sqlitehelper;
import xyz.moechat.sqlitedoing.model.Student;
import xyz.moechat.sqlitedoing.presenter.Adapterstudent;
import xyz.moechat.sqlitedoing.view.title;
import xyz.moechat.sqlitedoing.R;
import xyz.moechat.sqlitedoing.common.MoeActivity;

/**
 * Created by timeloveboy on 16/2/17.
 */
public class Activityquery extends MoeActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        initViews();
    }

    void initViews(){
        title=(title)findViewById(R.id.moetitle);
        title.settitle("sqlite query");

        listView_projects=(ListView)findViewById(R.id.listView_projects);
        listView_projects.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Dialogmenu dialogmenu = new Dialogmenu((Activity) Activityquery.this);
                dialogmenu.show();
                return false;
            }
        });
        sqlitehelper=new Sqlitehelper(this,"school.db",null,2);
        List<Student> studentList=sqlitehelper.studentquery();
        Log.v("moe","studentlist:"+studentList.size());
        listView_projects.setTag(studentList);
        Adapterstudent adapterstudent=new Adapterstudent(this,R.layout.viewstudentscores,(List<Student>)(listView_projects.getTag()));
        listView_projects.setAdapter(adapterstudent);

        button_query=(Button)findViewById(R.id.button_query);
        button_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> studentList=sqlitehelper.studentquery();
                Log.v("moe","studentlist:"+studentList.size());
                listView_projects.setTag(studentList);
                Adapterstudent adapterstudent=new Adapterstudent(Activityquery.this,R.layout.viewstudentscores,(List<Student>)(listView_projects.getTag()));
                listView_projects.setAdapter(adapterstudent);
            }
        });
    }
    Button button_query;
    ListView listView_projects;
    title title;
    Sqlitehelper sqlitehelper;
}