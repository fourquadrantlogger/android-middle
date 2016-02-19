package xyz.moechat.sqlitedoing.model;

/**
 * Created by timeloveboy on 16/2/20.
 */
public class Projectscore {
    public Projectscore(String project,int score) {
        this.project = project;
        this.score=score;
    }

    String project;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
