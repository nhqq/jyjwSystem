package cdu.jyjw.dao.Impl;

import cdu.jyjw.dao.BaseDao;
import cdu.jyjw.dao.CourseDao;
import cdu.jyjw.entity.*;
import cdu.jyjw.util.StrUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    /**
     * 根据学生id查看所选课程
     *
     * @param conn
     * @param sId
     * @return
     */
    @Override
    public List<StudentCourseScore> getCourseAndScoreBySId(Connection conn, int sId) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<StudentCourseScore> courseList = new ArrayList<>();
        if (conn != null) {
            try {
                Object[] param = {sId};
                String sql = "SELECT c.c_id ,c.c_number ,c.c_name ,t.t_id ,t.t_name ,sc.score ,c.c_week ,c.c_time_finish FROM student s, course c ,teacher t ,score sc WHERE c.t_id=t.t_id AND sc.c_id=c.c_id AND sc.s_id=s.s_id AND s.s_id = ?";
                rs = BaseDao.execute(conn, ps, rs, sql, param);
                while (rs.next()) {
                    StudentCourseScore course = new StudentCourseScore();
                    course.setcId(rs.getInt(1));
                    course.setcNumber(rs.getInt(2));
                    course.setcName(rs.getString(3));
                    course.settId(rs.getInt(4));
                    course.settName(rs.getString(5));
                    course.setScore(rs.getString(6));
                    course.setcWeek(rs.getString(7));
                    course.setcTimeFinish(rs.getString(8));
                    courseList.add(course);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, ps, rs);
            }
        }
        return courseList;
    }

    /**
     * 添加课程
     *
     * @param conn
     * @param course
     * @return
     */
    @Override
    public boolean addCourse(Connection conn, Course course) {
        boolean flag = false;
        int i = 0;
        PreparedStatement ps = null;
        if (conn != null) {
            Object[] param = {course.getcNumber(), course.getcName(), course.getCreateTime(), course.gettId(), course.getcWeek(), course.getTimeFinish()};
            String sql = "INSERT INTO course(c_number,c_name,c_create_time,t_id,c_week,c_time_finish) VALUES(?,?,?,?,?,?)";
            try {
                i = BaseDao.execute(conn, ps, sql, param);
                if (i > 0) {
                    flag = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, ps, null);
            }
        }
        return flag;
    }


    /**
     * 查看所有教师所有课程
     *
     * @param conn
     * @return
     */
    @Override
    public List<Teacher> getAllCourse(Connection conn) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Teacher> courseList = new ArrayList<>();
        if (conn != null) {
            try {
                Object[] param = {};
                String sql = "SELECT c.c_id ,c.c_number ,c.c_name ,c.t_id ,t.t_name ,c.c_week ,c.c_time_finish FROM course c,teacher t WHERE c.t_id=t.t_id";
                rs = BaseDao.execute(conn, ps, rs, sql, param);
                while (rs.next()) {
                    Teacher teacher = new Teacher();
                    Course course = new Course();
                    course.setcId(rs.getInt(1));
                    course.setcNumber(rs.getInt(2));
                    course.setcName(rs.getString(3));
                    course.settId(rs.getInt(4));
                    teacher.settName(rs.getString(5));
                    course.setcWeek(StrUtil.weekUtils(rs.getString(6)));
                    course.setTimeFinish(StrUtil.finishUtils(rs.getString(7)));
                    teacher.setCourse(course);
                    courseList.add(teacher);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, ps, rs);
            }
        }
        return courseList;
    }

    /**
     * 学生选课
     *
     * @param conn
     * @param score
     * @return
     */
    @Override
    public boolean StudentSeCourse(Connection conn, Score score) {
        PreparedStatement ps = null;
        boolean flag = false;
        if (conn != null) {
            try {
                Object[] param = {score.getcId(), score.getsId()};
                String sql = "INSERT INTO score(c_id,s_id) VALUES(?,?)";
                int i = BaseDao.execute(conn, ps, sql, param);
                if (i > 0) {
                    flag = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, ps, null);
            }
        }
        return flag;
    }

    /**
     * 判断是否已经选过次课程了
     */
    @Override
    public boolean judgeSeCourse(Connection conn, Score score) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cId = 0;
        boolean flag = true;
        if (conn != null) {
            try {
                Object[] param = {score.getsId()};
                String sql = "SELECT c_id FROM score WHERE s_id = ?";
                rs = BaseDao.execute(conn, ps, rs, sql, param);
                while (rs.next()) {
                    cId = rs.getInt(1);
                    if (cId == score.getcId()) {
                        flag = false;
                        break;
                    }
                }
            } catch (Exception throwables) {
                throwables.printStackTrace();
            } finally {
                BaseDao.closeResource(null, ps, rs);
            }
        }
        return flag;
    }

    /**
     * 判断相同名课程
     *
     * @param conn
     * @param cName
     * @return
     */
    @Override
    public boolean judgeSameCourse(Connection conn, String cName,int tId,String type) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;
        int num = 0;
        if (conn != null) {
            try {
                Object[] param = {cName,tId};
                String sql = "SELECT count(c_id)  FROM course WHERE c_name = ? AND t_id = ?";
                rs = BaseDao.execute(conn, ps, rs, sql, param);
                while (rs.next()) {
                    num = rs.getInt(1);
                }
                if (type.equals("mod")&&(num==1||num==0)){
                    flag=true;
                }else if (type.equals("add")&&num==0){
                    flag=true;
                } else {
                    System.out.println(type+"课程操作存在同名课程");
                }
            } catch (Exception throwables) {
                throwables.printStackTrace();
            } finally {
                BaseDao.closeResource(null, ps, rs);
            }
        }
        return flag;
    }

    /**
     * 教师获取所开课程
     *
     * @param conn
     * @param tId
     * @return
     */
    @Override
    public List<Course> getCourseByTId(Connection conn, int tId) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Course> courseList = null;
        if (conn != null) {
            try {
                courseList = new ArrayList<>();
                Object[] param = {tId};
                String sql = "SELECT * FROM course WHERE t_id = ?";
                rs = BaseDao.execute(conn, ps, rs, sql, param);
                while (rs.next()) {
                    Course course = new Course();
                    course.setcId(rs.getInt(1));
                    course.setcNumber(rs.getInt(2));
                    course.setcName(rs.getString(3));
                    course.setCreateTime(rs.getDate(4));
                    course.settId(rs.getInt(5));
                    course.setcWeek(rs.getString(6));
                    course.setTimeFinish(rs.getString(7));
                    courseList.add(course);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return courseList;
    }

    /**
     * 修改课程信息
     *
     * @param conn
     * @param course
     * @return
     */
    @Override
    public boolean modCourse(Connection conn, Course course) {
        PreparedStatement ps = null;
        boolean flag = false;
        if (conn != null) {
            try {
                Object[] param = {course.getcName(), course.getcWeek(), course.getTimeFinish(), course.getcId()};
                String sql = "UPDATE course SET c_name = ?,c_week = ?,c_time_finish = ? WHERE c_id = ? ";
                int i = BaseDao.execute(conn, ps, sql, param);
                if (i > 0) {
                    flag = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, ps, null);
            }
        }
        return flag;
    }

    /**
     * 通过教师id获取该教师的上课时间
     * @param conn
     * @param tId
     * @return
     */
    @Override
    public String getCourseWeekByTId(Connection conn, int tId) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuffer weekStrBu = new StringBuffer();
        String weekStr = null;

        if (conn != null) {
            try {
                Object[] param = {tId};
                String sql = "SELECT c_week FROM `course` WHERE t_id=?";
                rs = BaseDao.execute(conn, ps, rs, sql, param);
                while (rs.next()) {
                    String week = rs.getString(1);
                    weekStrBu.append(week);
                    weekStrBu.append("、");
                }
                if (weekStrBu.length()>0) {
                    weekStr = String.valueOf(weekStrBu);
                    weekStr = weekStr.substring(0, weekStr.length() - 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, ps, rs);
            }
        }
        return weekStr;
    }

    /**
     * 通过课程id获取该课程的上课时间
     * @param conn
     * @param cId
     * @return
     */
    @Override
    public String getCourseWeekByCId(Connection conn,int cId) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String weekStr = null;
        if (conn!=null){
            try {
                Object[] param={cId};
                String sql="SELECT c_week FROM `course` WHERE c_id=?";
                rs=BaseDao.execute(conn,ps,rs,sql,param);
                while (rs.next()) {
                   weekStr = rs.getString(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return weekStr;
    }

    /**
     * 通过学生id获取可退课课程
     * @param conn
     * @param sId
     * @return
     */
    @Override
    public List<StudentCourseScore> getDropCourseBySId(Connection conn, int sId) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<StudentCourseScore> courseList = new ArrayList<>();
        if (conn != null) {
            try {
                Object[] param = {sId};
                String sql = "SELECT c.c_id ,c.c_number ,c.c_name ,t.t_id ,t.t_name ,sc.score ,c.c_week ,c.c_time_finish FROM student s, course c ,teacher t ,score sc WHERE c.t_id=t.t_id AND sc.c_id=c.c_id AND sc.s_id=s.s_id AND sc.score = '未考试' AND s.s_id = ?";
                rs = BaseDao.execute(conn, ps, rs, sql, param);
                while (rs.next()) {
                    StudentCourseScore course = new StudentCourseScore();
                    course.setcId(rs.getInt(1));
                    course.setcNumber(rs.getInt(2));
                    course.setcName(rs.getString(3));
                    course.settId(rs.getInt(4));
                    course.settName(rs.getString(5));
                    course.setScore(rs.getString(6));
                    course.setcWeek(rs.getString(7));
                    course.setcTimeFinish(rs.getString(8));
                    courseList.add(course);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, ps, rs);
            }
        }
        return courseList;
    }

    /**
     * 通过学生id删除课程
     * @param conn
     * @param cId
     * @param sId
     * @return
     */
    @Override
    public boolean dropCourse(Connection conn, String cId, int sId) {
        PreparedStatement ps = null;
        boolean flag = false;
        if (conn!=null){
            try {
                Object[] param = {cId,sId};
                String sql ="DELETE FROM score WHERE c_id = ? AND s_id = ?";
                int i = BaseDao.execute(conn,ps,sql,param);
                if (i>0){
                    flag = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                BaseDao.closeResource(null,ps,null);
            }
        }
        return flag;
    }
}
