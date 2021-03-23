package cdu.jyjw.dao;

import cdu.jyjw.entity.Teacher;

import java.sql.Connection;

public interface TeacherDao {
    /**
     * 通过username获取用户信息
     * @param conn
     * @param username
     * @return
     */
    Teacher getLoginTeacher(Connection conn, String username);

    /**
     * 教师更新密码
     * @param conn
     * @param tId
     * @param reNewPassword
     * @return
     */
    boolean updatePwd(Connection conn, int tId, String reNewPassword);

    /**
     * 通过教师id获取用户信息
     * @param conn
     * @param tId
     * @return
     */
    Teacher getTeacherDetail(Connection conn, int tId);
}
