package cdu.jyjw.dao.Impl;

import cdu.jyjw.dao.BaseDao;
import cdu.jyjw.dao.TeacherDao;
import cdu.jyjw.entity.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeacherDaoImpl implements TeacherDao {
    /**
     * 通过username获取用户信息
     * @param conn
     * @param username
     * @return
     */
    @Override
    public Teacher getLoginTeacher(Connection conn, String username) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Teacher teacher = null;
        if (conn != null) {
            try {
                Object[] param = {username};
                String sql = "SELECT * FROM teacher where username = ?";
                rs = BaseDao.execute(conn, ps, rs, sql, param);
                while (rs.next()) {
                    teacher = new Teacher();
                    teacher.setUsername(rs.getString("username"));
                    teacher.setPassword(rs.getString("password"));
                    teacher.settId(rs.getInt(1));
                    teacher.settNumber(rs.getInt(2));
                    teacher.settName(rs.getString(3));
                    teacher.settSex(rs.getString(4));
                    teacher.settAge(rs.getInt(5));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(conn, ps, rs);
            }
        }
        return teacher;
    }

    /**
     * 教师更新密码
     * @param conn
     * @param tId
     * @param reNewPassword
     * @return
     */
    @Override
    public boolean updatePwd(Connection conn, int tId, String reNewPassword) {
        PreparedStatement ps = null;
        boolean flag = false;
        if (conn != null) {
            Object[] param = {reNewPassword, tId};
            String sql = "UPDATE teacher SET password = ? WHERE t_id = ?";
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
     * 通过教师id获取用户信息
     * @param conn
     * @param tId
     * @return
     */
    @Override
    public Teacher getTeacherDetail(Connection conn, int tId) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Teacher teacher = null;
        if (conn != null) {
            try {
                Object[] param = {tId};
                String sql = "SELECT t_number , t_name , t_sex , t_age FROM teacher WHERE t_id = ?";
                rs = BaseDao.execute(conn, ps, rs, sql, param);
                while (rs.next()){
                    teacher = new Teacher();
                    teacher.settNumber(rs.getInt(1));
                    teacher.settName(rs.getString(2));
                    teacher.settSex(rs.getString(3));
                    teacher.settAge(rs.getInt(4));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return teacher;
    }
}
