package cdu.jyjw.dao;

import cdu.jyjw.entity.*;

import java.sql.Connection;
import java.util.List;

public interface CourseDao {
    /**
     *根据学生id查看所选课程及成绩
     * @param conn
     * @param sId
     * @return
     */
    List<StudentCourseScore> getCourseAndScoreBySId(Connection conn, int sId);
    /**
     *添加课程
     * @param conn
     * @return
     */
    boolean addCourse(Connection conn,Course course);

    /**
     * 所有教师获取本人所有课程
     * @param conn
     * @return
     */
    List<Teacher> getAllCourse(Connection conn);

    /**
     * 学生选课
     * @param conn
     * @param score
     * @return
     */
    boolean StudentSeCourse(Connection conn, Score score);

    /**
     * 判断学生是否已选过该课程
     * @param conn
     * @param score
     * @return
     */
    boolean judgeSeCourse(Connection conn,Score score);

    /**
     * 判断是否有同名课程
     * @param conn
     * @param cName
     * @param tId
     * @param type
     * @return
     */
    boolean judgeSameCourse(Connection conn,String cName,int tId,String type);

    /**
     * 教师获取所开课程
     * @param tId
     * @return
     */
    List<Course> getCourseByTId(Connection conn, int tId);
    /**
     * 修改课程信息
     *
     * @param conn
     * @param course
     * @return
     */
    boolean modCourse(Connection conn, Course course);

    /**
     * 根据教师id获取教师的全部课程时间
     * @param conn
     * @param tId
     * @return
     */
    String getCourseWeekByTId(Connection conn, int tId) ;

    /**
     * 根据课程id获取开课时间
     * @param conn
     * @param cId
     * @return
     */
    String getCourseWeekByCId(Connection conn,int cId);

    /**
     * 学生获取删除课程集合
     * @param connection
     * @param sId
     * @return
     */
    List<StudentCourseScore> getDropCourseBySId(Connection connection, int sId);

    /**
     * 学生退课
     * @param conn
     * @param cId
     * @param sId
     * @return
     */
    boolean dropCourse(Connection conn,String cId, int sId);
}
