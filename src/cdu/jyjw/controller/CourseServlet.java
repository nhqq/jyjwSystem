package cdu.jyjw.controller;

import cdu.jyjw.entity.*;
import cdu.jyjw.service.CourseService;
import cdu.jyjw.service.Impl.CourseServiceImpl;
import cdu.jyjw.util.StrUtil;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "CourseServlet", urlPatterns = "/jsp/course.do")
public class CourseServlet extends HttpServlet {
    CourseService courseService = new CourseServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        System.out.println("method==>" + method);
        if (method != null && method.equals("se")) {
            this.getSelectableCourse(request, response);
        } else if (method != null && method.equals("secourse")) {
            this.StudentSeCourse(request, response);
        } else if (method != null && method.equals("getCourseAndScore")) {
            this.getCourseAndScoreBySId(request, response);
        } else if (method != null && method.equals("TgetCourse")) {
            this.getCourseByTId(request, response);
        } else if (method != null && method.equals("addCourse")) {
            this.addCourse(request, response);
        } else if (method != null && method.equals("toAdd")) {
            this.toAdd(request, response);
        } else if (method != null && method.equals("goModCourse")) {
            this.goModCourse(request, response);
        } else if (method != null && method.equals("modCourse")) {
            this.modCourse(request, response);
        } else if (method != null && method.equals("getCourseTable")) {
            this.getCourseTable(request, response);
        } else if (method != null && method.equals("getDropCourse")) {
            this.getDropCourse(request, response);
        } else if (method != null && method.equals("dropCourse")) {
            this.dropCourse(request, response);
        }
    }

    /**
     * 学生退课
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void dropCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student userSession = (Student) request.getSession().getAttribute("userSession");
        int sId = userSession.getsId();
        String cId = request.getParameter("cId");
        boolean flag = courseService.dropCourse(cId, sId);
        if (flag) {
            System.out.println("退课成功");
            request.setAttribute("msg","success");

        } else {
            System.out.println("退课失败");
            request.setAttribute("msg","fail");
        }
        this.getDropCourse(request, response);

    }

    /**
     * 学生获取可退课程
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void getDropCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student userSession = (Student) request.getSession().getAttribute("userSession");
        int sId = userSession.getsId();
        //获得学生所选课程
        List<StudentCourseScore> dropCourseListBySId = courseService.getDropCourseBySId(sId);
        for (StudentCourseScore studentCourseScore : dropCourseListBySId) {
            String week = studentCourseScore.getcWeek();
            String timeFinish = studentCourseScore.getcTimeFinish();
            studentCourseScore.setcWeek(StrUtil.weekUtils(week));
            studentCourseScore.setcTimeFinish(StrUtil.finishUtils(timeFinish));
        }
        request.setAttribute("dropCourseListBySId", dropCourseListBySId);
        request.getRequestDispatcher("/WEB-INF/jsp/dropCourse.jsp").forward(request, response);
    }

    /**
     * 学生查看学生课表
     *
     * @param request
     * @param response
     */
    private void getCourseTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student userSession = (Student) request.getSession().getAttribute("userSession");
        int sId = userSession.getsId();
        String[][] weekArray = new String[10][10];
        List<StudentCourseScore> courseAndScoreListBySId = courseService.getCourseAndScoreBySId(sId);
        for (StudentCourseScore studentCourseScore : courseAndScoreListBySId) {
            String week = studentCourseScore.getcWeek();
            String tName = studentCourseScore.gettName();
            String cName = studentCourseScore.getcName();
            String timeFinish = StrUtil.finishUtils(studentCourseScore.getcTimeFinish());
            String arrayStr = cName + "/" + tName + "/" + timeFinish;
            if (week != null && !week.equals("未设置")) {
                String[] split1 = week.split("、");
                for (String s : split1) {
                    int weekday = s.toCharArray()[0] - 49;//星期几
                    int daytime = s.toCharArray()[2] - 49;//具体时间
                    weekArray[daytime][weekday] = arrayStr;
                }
            }
        }

        request.setAttribute("courseTable", weekArray);

        request.getRequestDispatcher("/WEB-INF/jsp/studentCourseTable.jsp").forward(request, response);
    }

    /**
     * 教师修改课程信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void modCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Teacher userSession = (Teacher) request.getSession().getAttribute("userSession");
        int tId = userSession.gettId();
        int cId = Integer.parseInt(request.getParameter("cId"));
        String type="mod";
        String cName = request.getParameter("cName");
        String[] weeks = request.getParameterValues("week");
        String finish = request.getParameter("finish");
        StringBuffer weekday = new StringBuffer();
        String weekStr = "未设置";
        if (weeks!=null&&!weeks.equals("")){
            for (String week : weeks) {
                System.out.println(week);
                weekday.append(week);
                weekday.append("、");
            }
            weekStr = String.valueOf(weekday);
            weekStr = weekStr.substring(0, weekStr.length() - 1);
        }
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        finish = year + "&" + finish;
        Course course = new Course();
        course.settId(tId);
        course.setcId(cId);
        course.setcName(cName);
        course.setcWeek(weekStr);
        course.setTimeFinish(finish);
        boolean flag = courseService.modCourse(course,type);
        if (!flag) {
            System.out.println("修改课程信息错误");
            request.setAttribute("msg","modFail");
        }else {
            System.out.println("修改课程信息成功");
            request.setAttribute("msg","modSuccess");
        }
        this.getCourseByTId(request, response);
    }

    /**
     * 教师去往修改课程页面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void goModCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cId = request.getParameter("cId");
        request.setAttribute("cId", cId);
        List<Integer> weeks = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            weeks.add(i);
        }
        request.setAttribute("weeks", weeks);
        request.getRequestDispatcher("/WEB-INF/jsp/modCourse.jsp").forward(request, response);
    }

    /**
     * 教师去往添加课程页面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Integer> weeks = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            weeks.add(i);
        }
        request.setAttribute("weeks", weeks);
        request.getRequestDispatcher("/WEB-INF/jsp/addCourse.jsp").forward(request, response);
    }

    /**
     * 教师添加课程
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void addCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Teacher userSession = (Teacher) request.getSession().getAttribute("userSession");
        int tId = userSession.gettId();
        String type ="add";
        String cName = request.getParameter("cName");
        String[] weeks = request.getParameterValues("week");
        String finish = request.getParameter("finish");
        StringBuffer weekday = new StringBuffer();
        String weekStr = null;
        if (weeks != null) {
            for (String week : weeks) {
                System.out.println(week);
                weekday.append(week);
                weekday.append("、");
            }
            weekStr = String.valueOf(weekday);
            weekStr = weekStr.substring(0, weekStr.length() - 1);
        } else {
            weekStr="未设置";
        }
        if (finish!=null){
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            finish = year + "&" + finish;
        }else {
            finish = "未设置";
        }

        Course course = new Course();
        //生成随机数
        course.setcNumber((int) System.currentTimeMillis());
        course.setcName(cName);
        course.setCreateTime(new Date());
        course.settId(tId);
        course.setcWeek(weekStr);
        course.setTimeFinish(finish);
        System.out.println("course==>" + course);
        if (cName != null && !cName.trim().equals("")) {
            boolean flag = courseService.addCourse(course,type);
            if (flag) {
                System.out.println("CourseServlet==>addCourse==>添加成功");
                request.setAttribute("msg","addSuccess");
            } else {
                System.out.println("CourseServlet==>addCourse==>添加失败");
                request.setAttribute("msg","addFail");
            }
            this.getCourseByTId(request, response);
        } else {
            System.out.println("课程名不能全为空或者空格串");
            request.setAttribute("msg","emptyName");
            toAdd(request, response);
        }
    }
    //学生获取学生所选课程及成绩
    private void getCourseAndScoreBySId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student userSession = (Student) request.getSession().getAttribute("userSession");
        int sId = userSession.getsId();
        //获得学生所选课程
        List<StudentCourseScore> courseAndScoreListBySId = courseService.getCourseAndScoreBySId(sId);
        for (StudentCourseScore studentCourseScore : courseAndScoreListBySId) {
            String week = studentCourseScore.getcWeek();
            String timeFinish = studentCourseScore.getcTimeFinish();
            studentCourseScore.setcWeek(StrUtil.weekUtils(week));
            studentCourseScore.setcTimeFinish(StrUtil.finishUtils(timeFinish));
        }
        System.out.println("CourseServlet==>" + courseAndScoreListBySId);
        // c.c_id ,c.c_number ,c.c_name ,t.t_id ,t.t_name ,sc.score
        //    1	        1   	离散数学    1	        黄荣兵	100
        //    2	        2   	Linux      2    	程福超	10
        request.setAttribute("courseAndScoreList", courseAndScoreListBySId);
        request.getRequestDispatcher("/WEB-INF/jsp/courseAndScore.jsp").forward(request, response);

    }

    /**
     *学生获得所有老师可选课程
     *学生获取可选的课程（所有课程-已选课程）
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void getSelectableCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有教师所有课程
        List<Teacher> courseList = courseService.getAllCourse();
        // c.c_id ,c.c_number ,c.c_name ,c.t_id ,t.t_name
        //   1	      1     	离散数学	   1	  黄荣兵
        //   2	      2	         Linux	   2	  程福超
        //获取此学生已选得得课程
        Student userSession = (Student) request.getSession().getAttribute("userSession");
        int sId = userSession.getsId();
        List<StudentCourseScore> courseAndScoreListBySId = courseService.getCourseAndScoreBySId(sId);
        Iterator<Teacher> iterator = courseList.iterator();
        while (iterator.hasNext()) {
            Teacher teacher = iterator.next();
            courseAndScoreListBySId.forEach(item -> {
                if (teacher.getCourse().getcId() == item.getcId()) {
                    iterator.remove();
                }
            });
        }
        request.setAttribute("courses", courseList);
        request.getRequestDispatcher("/WEB-INF/jsp/SelectableCourse.jsp").forward(request, response);
    }

    /**
     * 学生选课
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void StudentSeCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Student userSession = (Student) request.getSession().getAttribute("userSession");
        int sId = userSession.getsId();
        int cId = Integer.parseInt(request.getParameter("cId"));
        Score score = new Score();
        score.setcId(cId);
        score.setsId(sId);
        System.out.println("CourseServlet==>course" + score);
        boolean flag = courseService.StudentSeCourse(score);
        if (flag) {
            System.out.println("CourseServlet==>选课成功");
            request.setAttribute("msg","success");
        } else {
            System.out.println("CourseServlet==>选课失败");
            request.setAttribute("msg","fail");
        }
        this.getSelectableCourse(request, response);
    }

    /**
     * 教师获取本人所开的课程
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void getCourseByTId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Teacher userSession = (Teacher) request.getSession().getAttribute("userSession");
        int tId = userSession.gettId();
        List<Course> courseList = courseService.getCourseByTId(tId);
        for (Course course : courseList) {
            String week = StrUtil.weekUtils(course.getcWeek());
            String timeFinish = StrUtil.finishUtils(course.getTimeFinish());
            course.setcWeek(week);
            course.setTimeFinish(timeFinish);
        }
        System.out.println("courseList==>" + courseList);
        request.setAttribute("courseList", courseList);
        request.getRequestDispatcher("/WEB-INF/jsp/TCourse.jsp").forward(request, response);
    }

}
