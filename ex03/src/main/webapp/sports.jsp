<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>getParameterValues 실습</h1>
<form action="sports" method="post">
    <fieldset>
        <legend>좋아하는 운동 및 성별</legend>
        <ul>
            <li>
                <label for="baseball">야구</label>
                <input type="checkbox" id="baseball" name="sports" value="야구">
                <label for="football">축구</label>
                <input type="checkbox" id="football" name="sports" value="야구">
                <label for="basketball">농구</label>
                <input type="checkbox" id="basketball" name="sports" value="야구">
            </li>
            <li>
                <lable for="male">남</lable>
                <input type="checkbox" id="male" name="sex" value="남자" checked>
                <label for="female">여</label>
                <input type="checkbox" id="female" name="sex" value="여자">
            </li>
            <li><input type="submit" value="전송"></li>
        </ul>
    </fieldset>
</form>
</body>
</html>
