package xyz.moechat.sqlitedoing.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import xyz.moechat.sqlitedoing.R;
import xyz.moechat.sqlitedoing.common.MoeActivity;
import xyz.moechat.sqlitedoing.model.Projectscore;
import xyz.moechat.sqlitedoing.presenter.Adapterprojectscore;

public class Activityadd extends MoeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        initViews();
    }
    List<Projectscore> projectscores;
    ListView listView_scores;
    Adapterprojectscore adapter;
    Button button_addscore;
    void initViews(){
        title=(title)findViewById(R.id.moetitle);
        title.settitle("sqlite add");

        projectscores=new ArrayList<Projectscore>();
        projectscores.add(new Projectscore("  ",0));
        adapter=new Adapterprojectscore(Activityadd.this,R.layout.project_score,projectscores);
        listView_scores=(ListView)findViewById(R.id.listView_scores);
        listView_scores.setAdapter(adapter);

        button_addscore=(Button)findViewById(R.id.button_addscore);
        button_addscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                projectscores.add(new Projectscore("  ",0));
                listView_scores.setAdapter(adapter);
            }
        });
    }
    title title;

}
