package cdu.jyjw.entity;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private int sId;
    private int sNumber;
    private String sName;
    private String username;
    private String password;
    private String sSex;
    private int  sAge;
    private Score score;


    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public int getsNumber() {
        return sNumber;
    }

    public void setsNumber(int sNumber) {
        this.sNumber = sNumber;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", sNumber=" + sNumber +
                ", sName='" + sName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sSex='" + sSex + '\'' +
                ", sAge=" + sAge +
                ", score=" + score +
                '}';
    }
}
