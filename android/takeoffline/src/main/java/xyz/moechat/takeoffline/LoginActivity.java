package xyz.moechat.takeoffline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends MoeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button login=(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account=((EditText)findViewById(R.id.account)).getText().toString();
                String password=((EditText)findViewById(R.id.password)).getText().toString();
                Log.v("moe","account:"+account);
                Log.v("moe", "password:" + password);
                if(password.equals( "123456") && account.equals("admin")){
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,"账号或者密码不对",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
