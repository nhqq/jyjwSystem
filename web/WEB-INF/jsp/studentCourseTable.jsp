<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生课表</title>
    <style>
        td {
            width: 80px;
            height: 80px;
        }
    </style>
</head>
<body>
<p>只会显示已经设置了具体时间的课程</p>
<table border="1" cellpadding="0" cellspacing="0"
       style="text-align: center">
    <th></th>
    <th>星期一</th>
    <th>星期二</th>
    <th>星期三</th>
    <th>星期四</th>
    <th>星期五</th>
    <th>星期六</th>
    <th>星期日</th>
    <c:forEach begin="1" end="5" var="row" varStatus="rowStatus">
        <tr>
            <c:forEach begin="1" end="8" var="col" varStatus="colStatus">
                <c:if test="${(rowStatus.index == 1 && colStatus.index ==1) || (rowStatus.index == 3 && colStatus.index == 1)}">
                    <td rowspan="2">
                        <c:if test="${rowStatus.index == 1}">
                            上午
                        </c:if>
                        <c:if test="${rowStatus.index == 3}">
                            下午
                        </c:if>
                    </td>
                </c:if>
                <c:if test="${(rowStatus.index == 5 && colStatus.index == 1)}">
                    <td>
                        晚上
                    </td>
                </c:if>
                <c:if test="${colStatus.index-1>0}">
                    <td>${courseTable[rowStatus.index-1][colStatus.index-2]}
                    </td>
                </c:if>
            </c:forEach>
        </tr>
    </c:forEach>

</table>
</body>
</html>
