<%--
  Created by IntelliJ IDEA.
  User: ehddn
  Date: 2024-07-31
  Time: 오전 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login_form.jsp</title>
</head>
<body>
<form action="login" method="get">
    <fieldset>
        <legend>로그인 폼</legend>
        <ul>
            <li>
                <label for="userid">아이디</label>
                <input type="text" id="userid" name="userid">
            </li>
            <li>
                <label for="passwd">비밀번호</label>
                <input type="password" id="passwd" name="passwd">
            </li>
            <li><input type="submit" value="전송"></li>
        </ul>
    </fieldset>
</form>
</body>
</html>
