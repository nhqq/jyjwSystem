package cdu.jyjw.controller;

import cdu.jyjw.entity.Score;
import cdu.jyjw.entity.Student;
import cdu.jyjw.service.Impl.ScoreServiceImpl;
import cdu.jyjw.service.Impl.StudentServiceImpl;
import cdu.jyjw.service.ScoreService;
import cdu.jyjw.service.StudentService;
import cdu.jyjw.util.StrUtil;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

@WebServlet(name = "ScoreServlet",urlPatterns = "/jsp/score.do")
public class ScoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if (method!=null&&method.equals("gotoModScore")){
            this.gotoModScore(request,response);
        }else if (method!=null&&method.equals("modScore")){
            this.modScore(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    /**
     * 教师前往修改成绩页面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void gotoModScore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cId = Integer.parseInt(request.getParameter("cId"));
        int sId = Integer.parseInt(request.getParameter("sId"));
        request.setAttribute("cId",cId);
        request.setAttribute("sId",sId);
        request.getRequestDispatcher("/WEB-INF/jsp/modScore.jsp").forward(request,response);
    }

    /**
     * 教师修改成绩
     * @param request
     * @param response
     */
    private void modScore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService = new StudentServiceImpl();
        int cId = Integer.parseInt(request.getParameter("cId"));
        int sId = Integer.parseInt(request.getParameter("sId"));
        String score = request.getParameter("score");
        if (StrUtil.isNumeric(score)&&StrUtil.isLength(score)) {
            int i  = Integer.parseInt(score);
            String s = String.valueOf(i);
            Score Score = new Score();
            ScoreService scoreService = new ScoreServiceImpl();
            Score.setcId(cId);
            Score.setsId(sId);
            Score.setScore(s);
            boolean flag = scoreService.ModScore(Score);
            if (flag){
                System.out.println("修改成绩成功");
                request.setAttribute("msg","modScoreSuccess");
            }else {
                System.out.println("修改成绩失败");
                request.setAttribute("msg","modScoreFail");
            }
            List<Student> studentList = studentService.getStudentAndScoreByCId(cId);
            request.setAttribute("studentList",studentList);
        }else {
            System.out.println("修改成绩失败,请输入数字!!!");
            request.setAttribute("msg","notNumber");
            List<Student> studentList = studentService.getStudentAndScoreByCId(cId);
            request.setAttribute("studentList",studentList);
        }
        request.setAttribute("cId",cId);
        request.getRequestDispatcher("/WEB-INF/jsp/allStudent.jsp").forward(request,response);

    }
    @Test
    public void testAllStudent(){
        String s = "01";
        int i = Integer.parseInt(s);
        String s1 = String.valueOf(i);
        System.out.println(s1);
        System.out.println(i);
    }
}
