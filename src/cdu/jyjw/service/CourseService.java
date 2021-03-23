package cdu.jyjw.service;

import cdu.jyjw.entity.*;


import java.util.List;

public interface CourseService {

    /**
     * 学生获取已选课程的成绩和课程
     * @param sId
     * @return
     */
    List<StudentCourseScore> getCourseAndScoreBySId(int sId);

    /**
     * 学生获取所有教师所开课程
     * @return
     */
    List<Teacher> getAllCourse();

    /**
     * 学生选课
     * @param score
     * @return
     */
    boolean StudentSeCourse(Score score);
    /**
     *添加课程
     * @param course
     * @return
     */
    boolean addCourse(Course course,String type);

    /**
     * 教师获取所开课程
     * @param tId
     * @return
     */
    List<Course> getCourseByTId(int tId);

    /**
     * 修改课程信息
     * @param course
     * @return
     */
    boolean modCourse(Course course,String type);

    /**
     * 学生获取删除课程集合
     * @param sId
     * @return
     */
    List<StudentCourseScore> getDropCourseBySId(int sId);

    /**
     * 学生退课
     * @param cId
     * @param sId
     * @return
     */
    boolean dropCourse(String cId, int sId);
}
