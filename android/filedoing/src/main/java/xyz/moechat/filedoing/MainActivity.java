package xyz.moechat.filedoing;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends  Activity {
    String file="text.txt";
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.save);
        editText=(EditText)findViewById(R.id.writetext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=((EditText)findViewById(R.id.writetext)).getText().toString();
                if(!content.equals("")){
                    Log.v("moe",content);
                    save("text.txt", content);
                    Toast.makeText(MainActivity.this,"已保存",Toast.LENGTH_SHORT).show();
                }
            }
        });


        if(file!=null){
            AlertDialog.Builder dialogBuilder =new AlertDialog.Builder(this);
            dialogBuilder.setTitle("发现上次保存的文件");
            dialogBuilder.setMessage(" 是否打开？ ");
            dialogBuilder.setCancelable(false);
            dialogBuilder.setPositiveButton("好", new DialogInterface.OnClickListener() {
                //确认按钮的点击事件
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String content=read(file);
                    editText.setText(content);
                    //移动输入光标到末尾
                    editText.setSelection(content.length());
                }
            });
            dialogBuilder.setNegativeButton("不", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog dialog=dialogBuilder.create();
            dialog.show();

        }
    }

    @Override
    protected void onDestroy() {

        String content=((EditText)findViewById(R.id.writetext)).getText().toString();
        if(!content.equals("")){
            save(file,content);
            Toast.makeText(MainActivity.this, "已保存", Toast.LENGTH_SHORT).show();
        }
        super.onDestroy();
    }

    public void save(String filename,String content){
        FileOutputStream outputStream=null;
        BufferedWriter bufferedWriter=null;
        try{
            outputStream=openFileOutput(filename, Context.MODE_PRIVATE);//默认模式，覆盖原文件
            bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write(content);

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(bufferedWriter!=null){
                    bufferedWriter.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public  String  read(String filename){
        FileInputStream fileInputStream=null;
        BufferedReader bufferedReader=null;
        StringBuilder content=new StringBuilder();
        try {
            fileInputStream=openFileInput(file);
            bufferedReader=new BufferedReader(new InputStreamReader(fileInputStream));
            String line="";
            while ((line=bufferedReader.readLine())!=null){
                content.append(line);
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(bufferedReader!=null){
                try{
                    bufferedReader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }
}
