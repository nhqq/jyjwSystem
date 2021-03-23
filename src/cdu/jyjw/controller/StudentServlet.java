package cdu.jyjw.controller;

import cdu.jyjw.entity.Student;
import cdu.jyjw.entity.Teacher;
import cdu.jyjw.service.Impl.StudentServiceImpl;
import cdu.jyjw.service.Impl.TeacherServiceImpl;
import cdu.jyjw.service.StudentService;
import cdu.jyjw.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet",urlPatterns = "/jsp/student.do")
public class StudentServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        System.out.println("method==>"+method);
        if (method!=null&&method.equals("getStudentAndScore")){
            this.getStudentByCId(request,response);
        }else if (method!=null&&method.equals("delStudent")){
            this.deleteStudentBySId(request,response);
        }else if (method!=null&&method.equals("getDetail")){
            this.getDetail(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    /**
     * 获取学生详细信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void getDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService = new StudentServiceImpl();
        Student userSession = (Student) request.getSession().getAttribute("userSession");
        int sId = userSession.getsId();
        Student student = studentService.getStudentDetail(sId);
        System.out.println("进入了 方法");
        request.setAttribute("detail", student);
        request.getRequestDispatcher("/WEB-INF/jsp/studentDetail.jsp").forward(request, response);
    }

    /**
     * 教师获得被选课程的学生及成绩
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void getStudentByCId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cId = Integer.parseInt(request.getParameter("cId"));
        List<Student> studentList = studentService.getStudentAndScoreByCId(cId);
        //s.s_id,s.s_number,s.s_name ,sc.sc_id ,sc.score
        //1	        1	    聂涵	          1	      100
        request.setAttribute("studentList",studentList);
        request.setAttribute("cId",cId);
        request.getRequestDispatcher("/WEB-INF/jsp/allStudent.jsp").forward(request,response);
    }

    /**
     * 删除选课学生
     * @param request
     * @param response
     */
    private void deleteStudentBySId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sId = Integer.parseInt(request.getParameter("sId"));
        int cId = Integer.parseInt(request.getParameter("cId"));
        boolean flag = studentService. deleteStudentBySId(cId,sId);
        if (flag){
            System.out.println("删除成功");
            request.setAttribute("msg","delSuccess");
        }else {
            System.out.println("删除失败");
            request.setAttribute("msg","delFail");
        }
        this.getStudentByCId(request,response);
    }
}
