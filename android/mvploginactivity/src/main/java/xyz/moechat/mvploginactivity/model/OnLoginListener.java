package xyz.moechat.mvploginactivity.model;

/**
 * Created by timeloveboy on 16/2/17.
 */
public interface OnLoginListener {
        void passwordError();

        void Success(User user);
}
