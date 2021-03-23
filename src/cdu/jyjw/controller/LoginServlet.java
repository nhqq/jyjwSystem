package cdu.jyjw.controller;


import cdu.jyjw.entity.Student;
import cdu.jyjw.entity.Teacher;
import cdu.jyjw.service.Impl.StudentServiceImpl;
import cdu.jyjw.service.Impl.TeacherServiceImpl;
import cdu.jyjw.service.StudentService;
import cdu.jyjw.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String validCode = request.getParameter("validCode");
        String saveUser = request.getParameter("saveUser");
        String role = request.getParameter("role");
        //获取session中的验证码
        HttpSession session = request.getSession();
        String randomCode = String.valueOf(session.getAttribute("randomCode"));
        if ("student".equals(role)) {
            StudentService studentService = new StudentServiceImpl();
            Student student = studentService.login(username, password);
            request.getSession().setAttribute("role","student");
            judge(student,"student",randomCode,validCode,saveUser,username,password,request,response);
        } else if ("teacher".equals(role)) {
            TeacherService teacherService = new TeacherServiceImpl();
            Teacher teacher = teacherService.login(username, password);
            request.getSession().setAttribute("role","teacher");
            judge(teacher,"teacher",randomCode,validCode,saveUser,username,password,request,response);
        }
    }
    public void judge(Object user, String userIndex,String randomCode, String validCode, String saveUser, String username, String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (user != null) {
            //判断验证码和输入验证码是否一致
            if (randomCode.equals(validCode)) {
                //保存用户名和密码
                if (saveUser != null) {
                    Cookie usernameCookie = new Cookie("username", username);
                    Cookie passwordCookie = new Cookie("password", password);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    //cookie设置为一周
                    usernameCookie.setMaxAge(24 * 60 * 60 * 7);
                    passwordCookie.setMaxAge(24 * 60 * 60 * 7);
                }
                //放入session
                request.getSession().setAttribute("userSession", user);
                response.sendRedirect("/"+userIndex+"Index");
            }else {
                System.out.println("登录失败");
                response.sendRedirect("/login");
            }
        }else {
            System.out.println("登录失败");
            response.sendRedirect("/login");
        }
    }
}

