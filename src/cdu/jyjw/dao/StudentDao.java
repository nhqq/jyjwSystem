package cdu.jyjw.dao;

import cdu.jyjw.entity.Student;

import java.sql.Connection;
import java.util.List;

public interface StudentDao {
    /**
     *根据学生用户名查看用户名和密码是否配对
     * @param conn
     * @param username
     * @return
     */
    Student getLoginStudent(Connection conn, String username);

    /**
     * 根据课程id查看学生和成绩
     * @param conn
     * @param cId
     * @return
     */
    List<Student> getStudentAndScoreByCId(Connection conn, int cId);

    /**
     * 根据学生id删除选课表score表学生
     * @param conn
     * @param sId
     * @return
     */
    boolean deleteStudentBySId(Connection conn, int cId,int sId);

    /**
     * 学生更新密码
     * @param conn
     * @param sId
     * @param reNewPassword
     * @return
     */
    boolean updatePwd(Connection conn, int sId, String reNewPassword);

    /**
     * 通过学生id获取用户信息
     * @param conn
     * @param sId
     * @return
     */
    Student getStudentDetail(Connection conn, int sId);
}
