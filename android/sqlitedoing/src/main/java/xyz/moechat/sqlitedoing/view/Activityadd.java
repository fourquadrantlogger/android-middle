package xyz.moechat.sqlitedoing.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import xyz.moechat.sqlitedoing.R;
import xyz.moechat.sqlitedoing.common.MoeActivity;
import xyz.moechat.sqlitedoing.common.Sqlitehelper;
import xyz.moechat.sqlitedoing.model.Project;
import xyz.moechat.sqlitedoing.model.Student;
import xyz.moechat.sqlitedoing.presenter.Adapterproject_edit;

public class Activityadd extends MoeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        initViews();

    }

    ListView listView_scores;
    Adapterproject_edit adapterproject_edit;
    Button button_addscore,button_add;
    title title;
    EditText editText_stuid,editText_stuname;
    Sqlitehelper sqlitehelper;
    void initViews(){
        title=(title)findViewById(R.id.moetitle);
        title.settitle("sqlite add");
        listView_scores=(ListView)findViewById(R.id.listView_scores);

        List<Project> projectscores=new ArrayList<Project>();
        projectscores.add(new Project("", 0));
        listView_scores.setTag(projectscores);

        adapterproject_edit =new Adapterproject_edit(Activityadd.this,R.layout.viewproject_edit,(List<Project> )(listView_scores.getTag()));
        listView_scores.setAdapter(adapterproject_edit);
        listView_scores.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Dialogmenu dialogmenu=new Dialogmenu((Activity)Activityadd.this);
                dialogmenu.show();
                return false;
            }
        });

        button_addscore=(Button)findViewById(R.id.button_addscore);
        button_addscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Project> projectscores=(List<Project> )(listView_scores.getTag());
                projectscores.add(new Project("", 0));
                listView_scores.setTag(projectscores);
                adapterproject_edit.notifyDataSetChanged();
            }
        });

        button_add=(Button)findViewById(R.id.button_add);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_stuid=(EditText)findViewById(R.id.editText_sduid);
                editText_stuname=(EditText)findViewById(R.id.editText_stuname);
                Student student=new Student();

                if(editText_stuid.getText().toString().equals("")) {
                    Toast.makeText(getBaseContext(), "学号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(editText_stuname.getText().toString().equals("")) {
                    Toast.makeText(getBaseContext(), "姓名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                student.setSduid(Integer.parseInt(editText_stuid.getText().toString()));
                student.setName(editText_stuname.getText().toString());

                sqlitehelper.Studentadd(student);

                List<Project> projectscores=(List<Project> )(listView_scores.getTag());
                for(Project p:projectscores){
                    if(p.getProjectname().equals("")){
                        Toast.makeText(getBaseContext(), "科目不能为空", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    sqlitehelper.Projectadd(student.getSduid(),p);
                }

                final Dialogmessage dialogmessage=new Dialogmessage(Activityadd.this, "添加成功",Dialogmessage.SHOW_CONFIRM);
                dialogmessage.button_confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogmessage.close();
                        clearView();
                    }
                });
                dialogmessage.show();

            }
        });
        sqlitehelper=new Sqlitehelper(this,"school.db",null,2);
    }

    void clearView(){
        editText_stuid.setText("");
        editText_stuname.setText("");
        List<Project> projectscores=(List<Project> )(listView_scores.getTag());
        projectscores.add(new Project("", 0));
        listView_scores.setTag(projectscores);
        adapterproject_edit.notifyDataSetChanged();
    }
}
