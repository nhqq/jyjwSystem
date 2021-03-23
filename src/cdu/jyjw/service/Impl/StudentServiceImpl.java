package cdu.jyjw.service.Impl;

import cdu.jyjw.dao.BaseDao;
import cdu.jyjw.dao.Impl.StudentDaoImpl;
import cdu.jyjw.dao.StudentDao;
import cdu.jyjw.entity.Student;
import cdu.jyjw.entity.Teacher;
import cdu.jyjw.service.StudentService;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;
    public StudentServiceImpl() {
        studentDao = new StudentDaoImpl();
    }

    /**
     *根据学生用户名查看用户名和密码是否配对
     * @param username
     * @param password
     * @return
     */
    @Override
    public Student login(String username, String password) {
        Connection connection = null;
        Student student = null;
        try {
            connection = BaseDao.getConnection();
            student = studentDao.getLoginStudent(connection, username);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        //匹配密码
        if (null != student) {
            if (!student.getPassword().equals(password))
                student = null;
        }
        return student;
    }

    /**
     * 根据课程id查看学生和成绩
     * @param cId
     * @return
     */
    @Override
    public List<Student> getStudentAndScoreByCId(int cId) {
        List<Student> studentList = new ArrayList<>();
        Connection connection = null;
        try {
            connection=BaseDao.getConnection();
            studentList=studentDao.getStudentAndScoreByCId(connection,cId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return studentList;
    }

    /**
     * 根据学生id删除选课表score表学生
     * @param sId
     * @return
     */
    @Override
    public boolean deleteStudentBySId(int cId,int sId) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection=BaseDao.getConnection();
            if (studentDao.deleteStudentBySId(connection,cId,sId)){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    /**
     * 学生更新密码
     * @param sId
     * @param reNewPassword
     * @return
     */
    @Override
    public boolean updatePwd(int sId, String reNewPassword) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection=BaseDao.getConnection();
            if (studentDao.updatePwd(connection,sId,reNewPassword)){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    /**
     * 通过学生id获取用户信息
     * @param sId
     * @return
     */
    @Override
    public Student getStudentDetail(int sId) {
        Connection conn = null;
        Student student = null;
        try {
            conn = BaseDao.getConnection();
            student = studentDao.getStudentDetail(conn, sId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(conn, null, null);
        }
        return student;
    }
}
