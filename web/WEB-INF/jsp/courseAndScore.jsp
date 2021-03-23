<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所选课程以及成绩</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
<table  class="table">
    <th>课程编号</th>
    <th>课程名</th>
    <th>教师</th>
    <th>上课时间</th>
    <th>结课时间</th>
    <th>成绩</th>
    <c:forEach items="${courseAndScoreList}" var="course">
        <tr class="success">
            <td>${course.cNumber}</td>
            <td>${course.cName}</td>
            <td>${course.tName}</td>
            <td>${course.cWeek}</td>
            <td>${course.cTimeFinish}</td>
            <td>${course.score}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
