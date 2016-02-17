package xyz.moechat.mvploginactivity.presenter;

import android.app.Activity;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

import xyz.moechat.mvploginactivity.model.Iuserdoing;
import xyz.moechat.mvploginactivity.model.OnLoginListener;
import xyz.moechat.mvploginactivity.model.User;
import xyz.moechat.mvploginactivity.model.userdoing;
import xyz.moechat.mvploginactivity.view.Iloginview;

/**
 * Created by timeloveboy on 16/2/17.
 */
public class loginpresenter {
    Iuserdoing userdoing;
    Iloginview loginview;


    public loginpresenter(Iloginview loginview) {
        this.loginview=loginview;
        this.userdoing=new userdoing();
    }

    public void login(final Activity UI){
        loginview.showloading();
        userdoing.login(loginview.getname(), loginview.getpassword(), new OnLoginListener() {
            @Override
            public void passwordError() {
                UI.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loginview.showFailedError();
                        loginview.hideloading();
                    }
                });
            }

            @Override
            public void Success(final User user) {
                UI.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loginview.hideloading();
                        loginview.toMainActivity(user);
                    }
                });

            }
        });
    }

    public void clear() {
        loginview.clearName();
        loginview.clearPassword();
    }
}
