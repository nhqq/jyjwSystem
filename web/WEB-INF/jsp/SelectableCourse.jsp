<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>可选课程</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
<h3>可选课程</h3>
<table  class="table">
    <th>课程编号</th>
    <th>课程名称</th>
    <th>所属教师</th>
    <th>上课时间</th>
    <th>结课时间</th>
    <th>操作</th>
    <c:forEach var="course" items="${courses}">
        <tr class="success">
            <td>${course.course.cNumber}</td>
            <td>${course.course.cName}</td>
            <td>${course.tName}</td>
            <td>${course.course.cWeek}</td>
            <td>${course.course.timeFinish}</td>
            <td>
                <a href="${pageContext.request.contextPath}/jsp/course.do?method=secourse&cId=${course.course.cId}">选课</a>
            </td>
        </tr>
    </c:forEach>
</table>

<c:if test="${requestScope.msg == 'success'}">
    <script language="JavaScript">
        alert("选课成功");
    </script>
</c:if>
<c:if test="${requestScope.msg == 'fail'}">
    <script language="JavaScript">
        alert("选课失败，上课时间冲突!!!");
    </script>
</c:if>
</body>

</html>
