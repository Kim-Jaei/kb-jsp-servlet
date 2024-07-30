<%--
  Created by IntelliJ IDEA.
  User: ehddn
  Date: 2024-07-29
  Time: 오전 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>로그인 입력 화면</h1>
<form action="login.jsp" method="get">
    <fieldset>
        <legend>로그인 폼</legend>
        <ul>
            <li>
                <lagel for="userid">아이디</lagel>
                <input type="text" name="userid">
            </li>
            <li>
                <label for="Password">비밀번호</label>
                <input type="password" name="Password">
            </li>
            <li><input type="submit" value="전송"></li>
        </ul>
    </fieldset>
</form>
</body>
</html>
