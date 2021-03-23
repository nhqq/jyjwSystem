package cdu.jyjw.dao.Impl;

import cdu.jyjw.dao.BaseDao;
import cdu.jyjw.dao.StudentDao;
import cdu.jyjw.entity.Score;
import cdu.jyjw.entity.Student;
import cdu.jyjw.entity.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    /**
     * 通过username获取用户信息
     * @param conn
     * @param username
     * @return
     */
    @Override
    public Student getLoginStudent(Connection conn, String username) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Student student = null;
        if (conn != null) {
            Object[] param = {username};
            String sql = "SELECT * FROM student where username = ?";
            try {
                rs = BaseDao.execute(conn, ps, rs, sql, param);
                while (rs.next()) {
                    student = new Student();
                    student.setUsername(rs.getString("username"));
                    student.setPassword(rs.getString("password"));
                    student.setsId(rs.getInt(1));
                    student.setsNumber(rs.getInt(2));
                    student.setsName(rs.getString(3));
                    student.setsSex(rs.getString(4));
                    student.setsAge(rs.getInt(5));
                    System.out.println("studentDao==》"+student);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, ps, rs);
            }
        }
        return student;
    }

    /**
     * 根据课程id查看学生
     * @param conn
     * @param cId
     * @return
     */
    @Override
    public List<Student> getStudentAndScoreByCId(Connection conn, int cId) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> studentList = new ArrayList<>();
        if (conn != null) {
            Object[] param = {cId};
            String sql = "SELECT  s.s_id,s.s_number,s.s_name ,sc.sc_id ,sc.score " +
                    "FROM student s,score sc WHERE sc.s_id=s.s_id AND sc.c_id=?";
            try {
                rs = BaseDao.execute(conn, ps, rs, sql, param);
                while (rs.next()) {
                    Student student = new Student();
                    Score score = new Score();
                    student.setsId(rs.getInt(1));
                    student.setsNumber(rs.getInt(2));
                    student.setsName(rs.getString(3));
                    score.setScId(rs.getInt(4));
                    score.setScore(rs.getString(5));
                    student.setScore(score);
                    studentList.add(student);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, ps, rs);
            }
        }
        return studentList;
    }

    /**
     * 根据学生id删除选课表score表学生
     * @param conn
     * @param sId
     * @return
     */
    @Override
    public boolean deleteStudentBySId(Connection conn, int cId, int sId) {
        PreparedStatement ps = null;
        boolean flag = false;
        if (conn != null) {
            Object[] param = {cId, sId};
            String sql = "DELETE FROM score WHERE c_id = ? AND s_id = ?";
            try {
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
     * 学生更新密码
     * @param conn
     * @param sId
     * @param reNewPassword
     * @return
     */
    @Override
    public boolean updatePwd(Connection conn, int sId, String reNewPassword) {
        PreparedStatement ps = null;
        boolean flag = false;
        if (conn != null) {
            Object[] param = {reNewPassword,sId};
            String sql = "UPDATE student SET password = ? WHERE s_id = ?";
            try {
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
     * 通过学生id获取用户信息
     * @param conn
     * @param sId
     * @return
     */
    @Override
    public Student getStudentDetail(Connection conn, int sId) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Student student = null;
        if (conn != null) {
            try {
                Object[] param = {sId};
                String sql = "SELECT s_number , s_name , s_sex , s_age FROM student WHERE s_id = ?";
                rs = BaseDao.execute(conn, ps, rs, sql, param);
                while (rs.next()){
                    student = new Student();
                    student.setsNumber(rs.getInt(1));
                    student.setsName(rs.getString(2));
                    student.setsSex(rs.getString(3));
                    student.setsAge(rs.getInt(4));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return student;
    }
}
