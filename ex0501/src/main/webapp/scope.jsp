<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scope.jsp</title>
</head>
<body>
<h1>스코프 데이터 보기</h1>
<%
    pageContext.setAttribute("scopeName", "pageScope");
%>
pageScope의 속성값은 : ${pageScope.scopeName}<br>
requestScope의 속성값은 : ${requestScope.scopeName}<br>
sessionScope의 속성값은 : ${sessionScope.scopeName}<br>
applicationScope의 속성값은 : ${applicationScope.scopeName}<br>
scopeName 자동 찾기 : ${scopeName}<br>
member : ${requestScope.username}(${requestScope.userid})<br>
member : ${requestScope.username}(${requestScope.userid})<br>
member : ${sessionScope.username}(${sessionScope.userid})<br>
</body>
</html>
