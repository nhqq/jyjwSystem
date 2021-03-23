package cdu.jyjw.entity;

import java.util.Date;

public class Course {
    private int cId;
    private int tId;
    private int cNumber;
    private String cName;
    private Date createTime;
    private String cWeek;
    private String timeFinish;

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getcWeek() {
        return cWeek;
    }

    public void setcWeek(String cWeek) {
        this.cWeek = cWeek;
    }

    public String getTimeFinish() {
        return timeFinish;
    }

    public void setTimeFinish(String timeFinish) {
        this.timeFinish = timeFinish;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cId=" + cId +
                ", tId=" + tId +
                ", cNumber=" + cNumber +
                ", cName='" + cName + '\'' +
                ", createTime=" + createTime +
                ", cWeek='" + cWeek + '\'' +
                ", timeFinish='" + timeFinish + '\'' +
                '}';
    }
}
