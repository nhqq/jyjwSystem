<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
    <table  class="table">
        <th>学号</th>
        <th>姓名</th>
        <th>成绩</th>
        <th>操作</th>
        <c:forEach var="student" items="${studentList}">
            <tr class="success">
                <td>${student.sNumber}</td>
                <td>${student.sName} </td>
                <td>${student.score.score}</td>
                <td><a href="${pageContext.request.contextPath}/jsp/student.do?method=delStudent&cId=${cId}&sId=${student.sId}">删除</a>
                    <a href="${pageContext.request.contextPath}/jsp/score.do?method=gotoModScore&cId=${cId}&sId=${student.sId}">修改成绩</a> </td>
            </tr>
        </c:forEach>
    </table>

    <c:if test="${requestScope.msg == 'modScoreSuccess'}">
        <script language="JavaScript">
            alert("修改成绩成功");
        </script>
    </c:if>
    <c:if test="${requestScope.msg == 'modScoreFail'}">
        <script language="JavaScript">
            alert("修改成绩失败");
        </script>
    </c:if>
    <c:if test="${requestScope.msg == 'delSuccess'}">
        <script language="JavaScript">
            alert("删除学生成功");
        </script>
    </c:if>
    <c:if test="${requestScope.msg == 'delFail'}">
        <script language="JavaScript">
            alert("删除学生失败");
        </script>
    </c:if>
    <c:if test="${requestScope.msg == 'notNumber'}">
        <script language="JavaScript">
            alert("修改成绩失败，请输入符合要求的数字!!!(0-100整数)");
        </script>
    </c:if>
</body>
</html>
