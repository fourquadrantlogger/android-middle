package xyz.moechat.sqlitedoing.model;

/**
 * Created by timeloveboy on 16/2/20.
 */
public class Project {
    public Project(String projectname, int score) {
        this.projectname = projectname;
        this.score=score;
    }

    String projectname;

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
