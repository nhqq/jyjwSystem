package cdu.jyjw.service;

import cdu.jyjw.entity.Student;


import java.util.List;

public interface StudentService {
    Student login(String username, String password);

    List<Student> getStudentAndScoreByCId(int cId);

    boolean deleteStudentBySId(int cId,int sId);

    boolean updatePwd(int sId, String reNewPassword);

    Student getStudentDetail(int sId);
}
