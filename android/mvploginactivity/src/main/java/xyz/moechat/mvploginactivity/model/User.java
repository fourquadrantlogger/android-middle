package xyz.moechat.mvploginactivity.model;

/**
 * Created by timeloveboy on 16/2/16.
 */
public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    int password;

}
