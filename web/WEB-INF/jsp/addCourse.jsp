<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>填写添加课程信息</title>
    <style>
        .checkbox {
            width: 40px;
            height: 40px;
            background: #ddd;
            margin: 20px 20px;
            border-radius: 100%;
            position: relative;
            -webkit-box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.5);
            -moz-box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.5);
            box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.5);
        }

        /**
 * Create the checkbox button
 */

        .checkbox label {
            display: block;
            width: 30px;
            height: 30px;
            border-radius: 100px;
            -webkit-transition: all .5s ease;
            -moz-transition: all .5s ease;
            -o-transition: all .5s ease;
            -ms-transition: all .5s ease;
            transition: all .5s ease;
            cursor: pointer;
            position: absolute;
            top: 5px;
            left: 5px;
            z-index: 1;
            background: #333;
            -webkit-box-shadow: inset 0px 1px 3px rgba(0, 0, 0, 0.5);
            -moz-box-shadow: inset 0px 1px 3px rgba(0, 0, 0, 0.5);
            box-shadow: inset 0px 1px 3px rgba(0, 0, 0, 0.5);
        }

        /**
 * Create the checked state
 */

        .checkbox input[type=checkbox]:checked + label {
            background: #26ca28;
        }
    </style>
</head>
<body>
<form method="post"
      action="${pageContext.request.contextPath}/jsp/course.do?method=addCourse" id="courseForm">
    请输入课程名:<input type="text" name="cName" id="cName"><br>
    请选择上课时间:
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

        <tr>
            <td rowspan="2">上午</td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="1&1" id="checkboxInput1"
                           name="week"/>
                    <label for="checkboxInput1"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="2&1" id="checkboxInput2"
                           name="week"/>
                    <label for="checkboxInput2"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="3&1" id="checkboxInput3"
                           name="week"/>
                    <label for="checkboxInput3"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="4&1" id="checkboxInput4"
                           name="week"/>
                    <label for="checkboxInput4"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="5&1" id="checkboxInput5"
                           name="week"/>
                    <label for="checkboxInput5"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="6&1" id="checkboxInput6"
                           name="week"/>
                    <label for="checkboxInput6"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="7&1" id="checkboxInput7"
                           name="week"/>
                    <label for="checkboxInput7"></label>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="1&2" id="checkboxInput21"
                           name="week"/>
                    <label for="checkboxInput21"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="2&2" id="checkboxInput22"
                           name="week"/>
                    <label for="checkboxInput22"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="3&2" id="checkboxInput23"
                           name="week"/>
                    <label for="checkboxInput23"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="4&2" id="checkboxInput24"
                           name="week"/>
                    <label for="checkboxInput24"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="5&2" id="checkboxInput25"
                           name="week"/>
                    <label for="checkboxInput25"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="6&2" id="checkboxInput26"
                           name="week"/>
                    <label for="checkboxInput26"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="7&2" id="checkboxInput27"
                           name="week"/>
                    <label for="checkboxInput27"></label>
                </div>
            </td>
        </tr>

        <tr>
            <td rowspan="2">下午</td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="1&3" id="checkboxInput31"
                           name="week"/>
                    <label for="checkboxInput31"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="2&3" id="checkboxInput32"
                           name="week"/>
                    <label for="checkboxInput32"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="3&3" id="checkboxInput33"
                           name="week"/>
                    <label for="checkboxInput33"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="4&3" id="checkboxInput34"
                           name="week"/>
                    <label for="checkboxInput34"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="5&3" id="checkboxInput35"
                           name="week"/>
                    <label for="checkboxInput35"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="6&3" id="checkboxInput36"
                           name="week"/>
                    <label for="checkboxInput36"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="7&3" id="checkboxInput37"
                           name="week"/>
                    <label for="checkboxInput37"></label>
                </div>
            </td>
        </tr>

        <tr>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="1&4" id="checkboxInput41"
                           name="week"/>
                    <label for="checkboxInput41"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="2&4" id="checkboxInput42"
                           name="week"/>
                    <label for="checkboxInput42"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="3&4" id="checkboxInput43"
                           name="week"/>
                    <label for="checkboxInput43"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="4&4" id="checkboxInput44"
                           name="week"/>
                    <label for="checkboxInput44"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="5&4" id="checkboxInput45"
                           name="week"/>
                    <label for="checkboxInput45"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="6&4" id="checkboxInput46"
                           name="week"/>
                    <label for="checkboxInput46"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="7&4" id="checkboxInput47"
                           name="week"/>
                    <label for="checkboxInput47"></label>
                </div>
            </td>
        </tr>

        <tr>
            <td>晚上</td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="1&5" id="checkboxInput51"
                           name="week"/>
                    <label for="checkboxInput51"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="2&5" id="checkboxInput52"
                           name="week"/>
                    <label for="checkboxInput52"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="3&5" id="checkboxInput53"
                           name="week"/>
                    <label for="checkboxInput53"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="4&5" id="checkboxInput54"
                           name="week"/>
                    <label for="checkboxInput54"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="5&5" id="checkboxInput55"
                           name="week"/>
                    <label for="checkboxInput55"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="6&5" id="checkboxInput56"
                           name="week"/>
                    <label for="checkboxInput56"></label>
                </div>
            </td>
            <td>
                <div class="checkbox">
                    <input type="checkbox" value="7&5" id="checkboxInput57"
                           name="week"/>
                    <label for="checkboxInput57"></label>
                </div>
            </td>
        </tr>
    </table>
    请选择结课日期:
    <select name="finish">
        <c:forEach var="week" items="${weeks}">
            <option value="${week}">第${week}周</option>
        </c:forEach>
    </select>
    <input type="submit" value="提交">
</form>

<c:if test="${requestScope.msg == 'emptyName'}">
    <script language="JavaScript">
        alert("空名称")
    </script>
</c:if>
</body>
</html>
