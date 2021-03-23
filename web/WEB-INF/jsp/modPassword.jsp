<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/modPassword.js"></script>

</head>
<body>
<div id="">
    <form method="post" id="userForm"
          action="${pageContext.request.contextPath }/jsp/user.do">
        <input type="hidden" name="method" value="modPwd">
        <div>
            <label class="label_input" for="oldPassword">旧密码</label>
            <input type="text" id="oldPassword" name="oldPassword" value=""/>
            <span id="msg"></span>
        </div>

        <div>
            <label class="label_input" for="newPassword">新密码</label>
            <input type="text" id="newPassword" name="newPassword" value=""/>
            <span id="msgN"></span>
        </div>
        <div>
            <label class="label_input" for="reNewPassword">新密码</label>
            <input type="text" id="reNewPassword" name="reNewPassword"
                   value=""/>
            <span id="msgrN"></span>
        </div>
        <div>
            <label class="" for="save"></label>
            <button type="button" value="提交" name="save" id="save">提交</button>
        </div>
    </form>
</div>
</body>
</html>
