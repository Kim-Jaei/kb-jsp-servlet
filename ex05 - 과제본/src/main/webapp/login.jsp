<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login.jsp</title>
</head>
<body>
<h1>EL 실습</h1>
사용자 아이디 : ${sessionScope.username}<br>
사용자 비밀번호 : ${sessionScope.passwd}<br>
</body>
</html>
