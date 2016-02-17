package xyz.moechat.mvploginactivity.view;

import xyz.moechat.mvploginactivity.model.User;


/**
 * Created by timeloveboy on 16/2/17.
 */
public interface Iloginview {
    String getname();
    String getpassword();
    void clearName();
    void clearPassword();
    void showloading();
    void hideloading();
    void toMainActivity(User user);
    void showFailedError();
}
