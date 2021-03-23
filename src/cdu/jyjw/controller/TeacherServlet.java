package cdu.jyjw.controller;

import cdu.jyjw.entity.Teacher;
import cdu.jyjw.service.Impl.TeacherServiceImpl;
import cdu.jyjw.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/jsp/teacher.do")
public class TeacherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherService teacherService = new TeacherServiceImpl();
        Teacher userSession = (Teacher) request.getSession().getAttribute("userSession");
        int tId = userSession.gettId();
        Teacher teacher = teacherService.getTeacherDetail(tId);
        System.out.println("进入了 方法");
        request.setAttribute("detail", teacher);
        request.getRequestDispatcher("/WEB-INF/jsp/teacherDetail.jsp").forward(request, response);
    }
}
