package cdu.jyjw.service.Impl;

import cdu.jyjw.dao.BaseDao;
import cdu.jyjw.dao.Impl.TeacherDaoImpl;
import cdu.jyjw.dao.TeacherDao;
import cdu.jyjw.entity.Teacher;
import cdu.jyjw.service.TeacherService;

import java.sql.Connection;

public class TeacherServiceImpl implements TeacherService {
    private TeacherDao teacherDao;

    public TeacherServiceImpl() {
        teacherDao = new TeacherDaoImpl();
    }

    /**
     * 通过username获取用户信息和password匹配
     * @param username
     * @param password
     * @return
     */
    @Override
    public Teacher login(String username, String password) {
        Connection connection = null;
        Teacher teacher = null;
        try {
            connection = BaseDao.getConnection();
            teacher = teacherDao.getLoginTeacher(connection, username);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        //匹配密码
        if (null != teacher) {
            if (!teacher.getPassword().equals(password))
                teacher = null;
        }
        return teacher;
    }

    /**
     * 教师更新密码
     * @param tId
     * @param reNewPassword
     * @return
     */
    @Override
    public boolean updatePwd(int tId, String reNewPassword) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (teacherDao.updatePwd(connection, tId, reNewPassword)) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    /**
     * 通过教师id获取用户信息
     * @param tId
     * @return
     */
    @Override
    public Teacher getTeacherDetail(int tId) {
        Connection conn = null;
        Teacher teacher = null;
        try {
            conn = BaseDao.getConnection();
            teacher = teacherDao.getTeacherDetail(conn, tId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(conn, null, null);
        }
        return teacher;
    }
}
