<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/css/login.css"/>
    <style>
        ul {
            list-style-type: none;
        }

        li {
            display: inline-block;
        }
    </style>
</head>
<body>
<div id="content">
    <div id="box">
        <div class="title">简易教务系统</div>
        <div class="input">
            <form method="post" action="/login.do">
                <input type="text" name="username"
                       value="${cookie.username.value}" placeholder="用户名"/>
                <br>
                <input type="password" name="password"
                       value="${cookie.password.value}" placeholder="密码"/>
                <br>
                <div>
                    <input style="width: 12px" type="checkbox" name="saveUser"
                           value="saveUser">记住我
                </div>
                <div>
                    <ul>
                        <lable><li><input style="width: 20px" type="radio" name="role"
                                          value="student" checked>学生</li></lable>
                        <lable><li><input style="width: 20px" type="radio" name="role"
                               value="teacher">教师</li></lable>
                    </ul>
                </div>
                <button type="submit">登录</button>
                <button type="reset">清空</button>
                <br>
                验证码:<input style="width: 100px;height: 30px" type="text"
                           name="validCode">
                <img src="validCode" id="validationCode_img" title="看不清?换一个"
                     onclick="loadImage();return false;"
                     name="validationCode_img" align="middle">
            </form>
        </div>
    </div>
</div>
<script src="/js/jquery-3.5.1.min.js"></script>
<script>

    function loadImage() {
        document.getElementById("validationCode_img").src = "validCode?time=" + new Date().getTime();
    }
    if (top.location != location){
        top.location.href = location.href;
    }
</script>

</body>
</html>
