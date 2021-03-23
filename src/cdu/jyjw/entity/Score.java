package cdu.jyjw.entity;

public class Score {
  private int scId;
  private int cId;
  private int sId;
  private String score;

    public int getScId() {
        return scId;
    }

    public void setScId(int scId) {
        this.scId = scId;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scId=" + scId +
                ", cId=" + cId +
                ", sId=" + sId +
                ", score='" + score + '\'' +
                '}';
    }
}
