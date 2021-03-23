<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改成绩</title>
</head>
<body>
    <form action="/jsp/score.do" method="post" id="scoreForm">
        <input type="hidden" name="cId" value="${cId}">
        <input type="hidden" name="sId" value="${sId}">
        <input type="hidden" name="method" value="modScore" id="score">
        成绩:<input type="text" name="score">
        <button type="submit" name="tijiao" value="提交">提交</button>
    </form>
</body>
<script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
</html>
