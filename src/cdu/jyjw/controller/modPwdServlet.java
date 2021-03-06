package cdu.jyjw.controller;

import cdu.jyjw.entity.Student;
import cdu.jyjw.entity.Teacher;
import cdu.jyjw.service.Impl.StudentServiceImpl;
import cdu.jyjw.service.Impl.TeacherServiceImpl;
import cdu.jyjw.service.StudentService;
import cdu.jyjw.service.TeacherService;
import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "modPwdServlet", urlPatterns = "/jsp/user.do")
public class modPwdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        String role = (String) request.getSession().getAttribute("role");
        System.out.println("modPwdServlet==>role:" + role);
        if (method != null && method.equals("judgePwd")) {
            this.getPwdByUser(request, response, role);
        } else if (method != null && method.equals("modPwd")) {
            this.updatePwd(request, response, role);
        }
    }

    private void getPwdByUser(HttpServletRequest request, HttpServletResponse response, String role)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        Object o = request.getSession().getAttribute("userSession");
        String oldPassword = request.getParameter("oldPassword");
        System.out.println(oldPassword);
        Map<String, Object> resultMap = new HashMap<>();
        String sessionPwd = null;
        if (role.equals("teacher")) {
            sessionPwd = ((Teacher) o).getPassword();
        } else if (role.equals("student")) {
            sessionPwd = ((Student) o).getPassword();
        }
        if (null == o) {//session??????
            resultMap.put("result",false);
            resultMap.put("msg","????????????");
        } else if (StringUtils.isNullOrEmpty(oldPassword)) {//?????????????????????
            resultMap.put("result", false);
            resultMap.put("msg","?????????");
        } else {
            if (oldPassword.equals(sessionPwd)) {
                resultMap.put("result", true);
                resultMap.put("msg","true");
            } else {//????????????????????????
                resultMap.put("result", false);
                resultMap.put("msg","????????????");
            }
        }
        response.setContentType("application/json");
        PrintWriter outPrintWriter = response.getWriter();
        outPrintWriter.write(JSONArray.toJSONString(resultMap));
        outPrintWriter.flush();
        outPrintWriter.close();
    }

    private void updatePwd(HttpServletRequest request, HttpServletResponse response, String role)
            throws ServletException, IOException {

        Object o = request.getSession().getAttribute("userSession");
        String reNewPassword = request.getParameter("reNewPassword");
        boolean flag = false;
        if (o != null && !StringUtils.isNullOrEmpty(reNewPassword)) {
            if (role.equals("student")) {
                StudentService studentService = new StudentServiceImpl();
                flag = studentService.updatePwd(((Student) o).getsId(), reNewPassword);
            } else if (role.equals("teacher")) {
                TeacherService teacherService = new TeacherServiceImpl();
                flag = teacherService.updatePwd(((Teacher) o).gettId(), reNewPassword);
            }
            if (flag) {
                request.setAttribute("message", "??????????????????,??????????????????????????????????????????");
                request.getSession().removeAttribute("userSession");//session??????
            } else {
                request.setAttribute("message", "?????????????????????");
            }
        } else {
            request.setAttribute("message", "?????????????????????");
        }
        request.getRequestDispatcher("/WEB-INF/jsp/modPassword.jsp").forward(request, response);
    }
}
