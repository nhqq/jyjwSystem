<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>简易教务系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/head.css">
</head>
<body>
<!--头部-->
<header class="header">
    <h1>简易教务系统</h1>
    <div class="headerR">
        <p><span style="color: #fff21b"> ${userSession.sName }</span> , 欢迎你！</p>
        <a href="${pageContext.request.contextPath }/logout.do">退出</a>
    </div>
</header>

<!--主体内容-->
<section class="functionList ">
    <div class="left">
        <h2>功能列表</h2>
        <ul class="list">
            <li><a target="right" href="${pageContext.request.contextPath }/jsp/course.do?method=se">选课</a></li>
            <li><a target="right" href="${pageContext.request.contextPath }/jsp/student.do?method=getDetail">个人信息</a></li>
            <li><a target="right" href="${pageContext.request.contextPath }/jsp/course.do?method=getCourseAndScore">查看所选课程及成绩</a></li>
            <li><a target="right" href="${pageContext.request.contextPath }/jsp/course.do?method=getCourseTable">查看课表</a></li>
            <li><a target="right" href="${pageContext.request.contextPath }/jsp/course.do?method=getDropCourse">退课</a></li>
            <li><a target="right" href="${pageContext.request.contextPath }/jsp/modp">密码修改</a></li>
        </ul>
    </div>
    <div class="right">
        <iframe scrolling="auto" rameborder="0" src="index.jsp" name="right" width="100%" height="100%"></iframe>
    </div>
</section>
<footer class="foot">
    简易教务系统
</footer>
</body>
</html>