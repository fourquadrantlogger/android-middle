package xyz.moechat.sqlitedoing.model;

import java.util.Map;

/**
 * Created by timeloveboy on 16/2/18.
 */
public class Student {
    public int getSduid() {
        return sduid;
    }

    public void setSduid(int sduid) {
        this.sduid = sduid;
    }

    int sduid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public Map<String,Integer> getScore() {
        return score;
    }

    public void setScore(Map<String,Integer> score) {
        this.score = score;
    }

    Map<String,Integer> score;
}
