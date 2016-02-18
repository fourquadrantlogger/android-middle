package xyz.moechat.sqlitedoing.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import xyz.moechat.sqlitedoing.R;

/**
 * Created by timeloveboy on 16/2/18.
 */
public class buttomnav extends LinearLayout{

    private ImageView imageView_query,imageView_add,imageView_update;
    private TextView textView_query,textView_add,textView_update;
    LinearLayout linearLayout_query,linearLayout_add,linearLayout_update;
    public buttomnav(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.buttomnav, this);
        initViews();
        String selected=(this.getTag()).toString();
        showselect(Integer.parseInt(selected));
    }
    void initViews(){
        imageView_query=(ImageView)findViewById(R.id.imageView_query);
        linearLayout_query=(LinearLayout)findViewById(R.id.linearLayout_query);
        linearLayout_query.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(1);
            }
        });
        imageView_add=(ImageView)findViewById(R.id.imageView_add);
        linearLayout_add=(LinearLayout)findViewById(R.id.linearLayout_add);
        linearLayout_add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(2);
            }
        });
        imageView_update=(ImageView)findViewById(R.id.imageView_update);
        linearLayout_update=(LinearLayout)findViewById(R.id.linearLayout_update);
        linearLayout_update.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(3);
            }
        });

        textView_query=(TextView)findViewById(R.id.textView_query);
        textView_add=(TextView)findViewById(R.id.textView_add);
        textView_update=(TextView)findViewById(R.id.textView_update);
    }
    public void showselect(int id){
        int color_select=getResources().getColor(R.color.moepink);
        int color_unselect=getResources().getColor(R.color.moeblack);
        if(id==1) {
            imageView_query.setImageResource(R.drawable.query_selected);
            textView_query.setTextColor(color_select);
            imageView_add.setImageResource(R.drawable.add);
            textView_add.setTextColor(color_unselect);
            imageView_update.setImageResource(R.drawable.update);
            textView_update.setTextColor(color_unselect);
        }else if(id==2){
            imageView_query.setImageResource(R.drawable.query);
            textView_query.setTextColor(color_unselect);
            imageView_add.setImageResource(R.drawable.add_selected);
            textView_add.setTextColor(color_select);
            imageView_update.setImageResource(R.drawable.update);
            textView_update.setTextColor(color_unselect);

        }else if(id==3){
            imageView_query.setImageResource(R.drawable.query);
            textView_query.setTextColor(color_unselect);
            imageView_add.setImageResource(R.drawable.add);
            textView_add.setTextColor(color_unselect);
            imageView_update.setImageResource(R.drawable.update_selected);
            textView_update.setTextColor(color_select);
        }

    }
    public int getselectedid(){
        String selected=(this.getTag()).toString();
       return Integer.parseInt(selected);
    }
    public void toActivity(int id){
        Intent intent;

        if(id==getselectedid())return;

        if(id==1) {
            intent=new Intent(buttomnav.this.getContext(),Activityquery.class);
        }else if(id==2){
            intent=new Intent(buttomnav.this.getContext(),Activityadd.class);
        }else{
            intent=new Intent(buttomnav.this.getContext(),Activityupdate.class);
        }
        Log.v("moe","startActivity"+Integer.toString(getselectedid()));

        //设置没有动画
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        buttomnav.this.getContext().startActivity(intent);
    }
}
