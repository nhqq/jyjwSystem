package cdu.jyjw.service.Impl;

import cdu.jyjw.dao.BaseDao;
import cdu.jyjw.dao.CourseDao;
import cdu.jyjw.dao.Impl.CourseDaoImpl;
import cdu.jyjw.dao.Impl.ScoreDaoImpl;
import cdu.jyjw.dao.ScoreDao;
import cdu.jyjw.entity.*;
import cdu.jyjw.service.CourseService;
import cdu.jyjw.util.StrUtil;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao;

    public CourseServiceImpl() {
        courseDao = new CourseDaoImpl();
    }

    /**
     * 学生获取已选课程的成绩和课程
     *
     * @param sId
     * @return
     */
    @Override
    public List<StudentCourseScore> getCourseAndScoreBySId(int sId) {
        Connection connection = null;
        List<StudentCourseScore> courseList = new ArrayList<>();
        try {
            connection = BaseDao.getConnection();
            courseList = courseDao.getCourseAndScoreBySId(connection, sId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return courseList;
    }

    /**
     * 查看所有课程
     *
     * @return
     */
    @Override
    public List<Teacher> getAllCourse() {
        Connection connection = null;
        List<Teacher> courseList = new ArrayList<>();
        try {
            connection = BaseDao.getConnection();
            courseList = courseDao.getAllCourse(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return courseList;
    }

    /**
     * 学生选课
     *
     * @param score
     * @return
     */
    @Override
    public boolean StudentSeCourse(Score score) {
        Connection conn = null;
        boolean flag = false;
        StringBuffer weekData = new StringBuffer();
        String weekStr = null;
        try {
            conn = BaseDao.getConnection();
            List<StudentCourseScore> courseAndScoreBySId = courseDao.getCourseAndScoreBySId(conn, score.getsId());
            for (StudentCourseScore studentCourseScore : courseAndScoreBySId) {
                weekData.append(studentCourseScore.getcWeek());
                weekData.append("、");
            }
            if(weekData.length()>0){
                weekStr = weekData.substring(0, weekData.length() - 1);
            }else {
                weekStr="未设置";
            }
            System.out.println(courseDao.judgeSeCourse(conn, score));
            System.out.println(StrUtil.week2Utils(courseDao.getCourseWeekByCId(conn, score.getcId()), weekStr));

            if (courseDao.judgeSeCourse(conn, score) && StrUtil.week2Utils(courseDao.getCourseWeekByCId(conn, score.getcId()), weekStr) && courseDao.StudentSeCourse(conn, score)) {
                flag = true;
            } else {
                System.out.println("CourseService==>选课错误或者插入默认成绩错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(conn, null, null);
        }
        return flag;
    }

    /**
     * 添加课程
     *
     * @param course
     * @return
     */
    @Override
    public boolean addCourse(Course course,String type) {
        Connection conn = null;
        boolean flag = false;
        try {
            conn = BaseDao.getConnection();
            if (courseDao.judgeSameCourse(conn, course.getcName(),course.gettId(),type) && StrUtil.week2Utils(course.getcWeek(), courseDao.getCourseWeekByTId(conn, course.gettId())) && courseDao.addCourse(conn, course)) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(conn, null, null);
        }
        return flag;
    }

    /**
     * 教师获取所开课程
     *
     * @param tId
     * @return
     */
    @Override
    public List<Course> getCourseByTId(int tId) {
        Connection conn = null;
        List<Course> courseList = new ArrayList<>();
        try {
            conn = BaseDao.getConnection();
            courseList = courseDao.getCourseByTId(conn, tId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(conn, null, null);
        }
        return courseList;
    }

    /**
     * 修改课程信息
     *
     * @param course
     * @return
     */
    @Override
    public boolean modCourse(Course course,String type) {
        Connection conn = null;
        boolean flag = false;
        try {
            conn = BaseDao.getConnection();
            //对修改课程进行课程名同名、教师上课时间是否冲突进行判定
            if (courseDao.judgeSameCourse(conn, course.getcName(),course.gettId(),type) && StrUtil.week2Utils(course.getcWeek(), courseDao.getCourseWeekByTId(conn, course.gettId())) && courseDao.modCourse(conn, course)) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(conn, null, null);
        }
        return flag;
    }

    /**
     * 学生获取删除课程集合
     * @param sId
     * @return
     */
    @Override
    public List<StudentCourseScore> getDropCourseBySId(int sId) {
        Connection connection = null;
        List<StudentCourseScore> courseList = new ArrayList<>();
        try {
            connection = BaseDao.getConnection();
            courseList = courseDao.getDropCourseBySId(connection, sId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return courseList;

    }

    /**
     * 学生退课
     * @param cId
     * @param sId
     * @return
     */
    @Override
    public boolean dropCourse(String cId, int sId) {
        Connection conn = null;
        boolean flag = false;
        try {
            conn=BaseDao.getConnection();
            flag=courseDao.dropCourse(conn,cId,sId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(conn,null,null);
        }
        return flag;
    }

}
