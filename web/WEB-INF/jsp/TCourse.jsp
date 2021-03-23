<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所开课程</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
<div class="button"><a href="${pageContext.request.contextPath}/jsp/course.do?method=toAdd">添加课程</a></div>

<table class="table">
    <th>课程编号</th>
    <th>课程名称</th>
    <th>创建时间</th>
    <th>具体上课时间</th>
    <th>结课时间</th>
    <th>操作</th>
    <c:forEach var="course" items="${courseList}">
        <tr  class="success">
            <td>${course.cNumber}</td>
            <td><a href="${pageContext.request.contextPath}/jsp/student.do?method=getStudentAndScore&cId=${course.cId}">${course.cName}</a> </td>
            <td>${course.createTime}</td>
            <td>${course.cWeek}</td>
            <td>${course.timeFinish}</td>
            <td><a href="/jsp/course.do?method=goModCourse&cId=${course.cId}">修改信息</a></td>
        </tr>
    </c:forEach>
</table>

<c:if test="${requestScope.msg == 'modSuccess'}">
    <script language="JavaScript">
        alert("修改成功");
    </script>
</c:if>
<c:if test="${requestScope.msg == 'modFail'}">
    <script language="JavaScript">
        alert("修改失败，开课时间或课程名冲突");
    </script>
</c:if>
<c:if test="${requestScope.msg == 'addFail'}">
    <script language="JavaScript">
        alert("添加课程失败，开课时间或课程名冲突");
    </script>
</c:if>
<c:if test="${requestScope.msg == 'addSuccess'}">
    <script language="JavaScript">
        alert("添加课程成功");
    </script>
</c:if>
</body>
</html>
