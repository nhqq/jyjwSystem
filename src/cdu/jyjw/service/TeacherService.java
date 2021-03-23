package cdu.jyjw.service;

import cdu.jyjw.entity.Teacher;



public interface TeacherService {
    /**
     * 通过username获取用户信息和password匹配
     * @param username
     * @param password
     * @return
     */
    Teacher login(String username,String password);

    /**
     * 教师更新密码
     * @param tId
     * @param reNewPassword
     * @return
     */
    boolean updatePwd(int tId, String reNewPassword);

    /**
     * 通过教师id获取用户信息
     * @param tId
     * @return
     */
    Teacher getTeacherDetail(int tId);
}
