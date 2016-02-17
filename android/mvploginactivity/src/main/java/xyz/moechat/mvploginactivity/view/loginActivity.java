package xyz.moechat.mvploginactivity.view;

import android. app. Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import xyz.moechat.mvploginactivity.R;
import xyz.moechat.mvploginactivity.model.User;
import xyz.moechat.mvploginactivity.presenter.loginpresenter;

public class loginActivity extends Activity implements Iloginview{

    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin, mBtnClear;
    private ProgressBar mPbLoading;

    private loginpresenter loginpresenter=new loginpresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        initview();
    }

    void initview(){
        mEtUsername = (EditText) findViewById(R.id.name);
        mEtPassword = (EditText) findViewById(R.id.password);

        mBtnClear = (Button) findViewById(R.id.clear);
        mBtnLogin = (Button) findViewById(R.id.login);

        mPbLoading = (ProgressBar) findViewById(R.id.progressBar);

        mBtnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                loginpresenter.login(loginActivity.this);
            }
        });

        mBtnClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                loginpresenter.clear();
            }
        });
    }

    @Override
    public String getname()
    {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getpassword()
    {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearName()
    {
        mEtUsername.setText("");
    }

    @Override
    public void clearPassword()
    {
        mEtPassword.setText("");
    }

    @Override
    public void showloading()
    {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideloading()
    {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user)
    {
        Toast.makeText(this, user.getName() +" login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError()
    {
        Toast.makeText(this,"login failed", Toast.LENGTH_SHORT).show();
    }
}
