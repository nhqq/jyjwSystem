package cdu.jyjw.entity;

public class Teacher {
    private int tId;
    private int tNumber;
    private String tName;
    private String username;
    private String password;
    private String tSex;
    private int  tAge;
    private Course course;

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public int gettNumber() {
        return tNumber;
    }

    public void settNumber(int tNumber) {
        this.tNumber = tNumber;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
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

    public String gettSex() {
        return tSex;
    }

    public void settSex(String tSex) {
        this.tSex = tSex;
    }

    public int gettAge() {
        return tAge;
    }

    public void settAge(int tAge) {
        this.tAge = tAge;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tId=" + tId +
                ", tNumber=" + tNumber +
                ", tName='" + tName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tSex='" + tSex + '\'' +
                ", tAge=" + tAge +
                ", course=" + course +
                '}';
    }
}
