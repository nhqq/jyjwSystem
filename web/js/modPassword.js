$(function () {
    var msg = $("#msg");
    var msgN = $("#msgN");
    var msgrN = $("#msgrN");
    var saveBtn = $("#save");
    var oldPassword = null;
    var newPassword = null;
    var reNewPassword = null;
    $("#oldPassword").blur(function () {
        $.get("/jsp/user.do?method=judgePwd", {oldPassword: oldPassword},
            function (data) {
                oldPassword = $("#oldPassword").val();
                if (data.result) {
                    msg.css("color", "green");
                    msg.html(data.msg);
                    msg.status = true;
                } else {
                    msg.css("color", "red");
                    msg.html(data.msg);
                    msg.status = false;
                }
            }, "json");
    });

    $("#newPassword").focus(function () {
        newPassword = $("#newPassword").val();
        msgN.css("color", "green");
        msgN.html("密码长度必须大于等于6小于等于16");
    }).on("blur", function () {
        if (newPassword != null && newPassword.length >= 6
            && newPassword.length <= 16) {
            msgN.css("color", "green");
            msgN.html("格式正确");
            msgN.status = true;
        } else {
            msgN.css("color", "red");
            msgN.html("格式错误");
            msgN.status = false;
        }
    });
    $("#reNewPassword").focus(function () {
        reNewPassword = $("#reNewPassword").val();
        msgrN.css("color", "green");
        msgrN.html("与上面密码一致");
    }).on("blur", function () {
        if (reNewPassword != null && reNewPassword.length >= 6
            && reNewPassword.length <= 16 && reNewPassword == reNewPassword) {
            msgrN.css("color", "green");
            msgrN.html("格式正确");
            msgrN.status = true;
        } else {
            msgrN.css("color", "red");
            msgrN.html("格式错误");
            msgrN.status = false;
        }
    });
    saveBtn.on("click", function () {
        $("#oldPassword").blur();
        $("#newPassword").blur();
        $("#reNewPassword").blur();
        if (msg.status == true && msgN.status == true && msgrN.status == true) {
            if (confirm("确定要修改密码？")) {
                $("#userForm").submit();
            }
        }
    })
});