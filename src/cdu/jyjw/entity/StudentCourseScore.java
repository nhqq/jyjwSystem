package cdu.jyjw.entity;

public class StudentCourseScore {
   private int cId;
   private int cNumber;
   private String cName;
   private int tId;
   private String tName;
   private String score;
   private String cWeek;
   private String cTimeFinish;
    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getcNumber() {
        return cNumber;
    }

    public void setcNumber(int cNumber) {
        this.cNumber = cNumber;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getcWeek() {
        return cWeek;
    }

    public void setcWeek(String cWeek) {
        this.cWeek = cWeek;
    }

    public String getcTimeFinish() {
        return cTimeFinish;
    }

    public void setcTimeFinish(String cTimeFinish) {
        this.cTimeFinish = cTimeFinish;
    }

    @Override
    public String toString() {
        return "StudentCourseScore{" +
                "cId=" + cId +
                ", cNumber=" + cNumber +
                ", cName='" + cName + '\'' +
                ", tId=" + tId +
                ", tName='" + tName + '\'' +
                ", score='" + score + '\'' +
                ", cWeek='" + cWeek + '\'' +
                ", cTimeFinish='" + cTimeFinish + '\'' +
                '}';
    }
}
