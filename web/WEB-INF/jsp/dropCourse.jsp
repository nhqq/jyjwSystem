<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退课</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
<table class="table">
    <th>课程编号</th>
    <th>课程名</th>
    <th>教师</th>
    <th>上课时间</th>
    <th>结课时间</th>
    <th>退课</th>
    <c:forEach items="${dropCourseListBySId}" var="course">
        <tr class="success">
            <td>${course.cNumber}</td>
            <td>${course.cName}</td>
            <td>${course.tName}</td>
            <td>${course.cWeek}</td>
            <td>${course.cTimeFinish}</td>
            <td><a href="${pageContext.request.contextPath}/jsp/course.do?method=dropCourse&cId=${course.cId}">退课</a></td>
        </tr>
    </c:forEach>
</table>

<c:if test="${requestScope.msg == 'success'}">
    <script language="JavaScript">
        alert("退课成功");
    </script>
</c:if>
<c:if test="${requestScope.msg == 'fail'}">
    <script language="JavaScript">
        alert("退课失败");
    </script>
</c:if>
</body>
</html>
