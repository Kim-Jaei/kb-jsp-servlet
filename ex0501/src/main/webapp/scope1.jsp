<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>scope 데이터 보기</h1>
<%
    pageContext.setAttribute("scopeName","pageScope 값");
%>
<%--    이거 덕분에 pageScope랑 자동 찾기 이해가 확 됐어요!!  --%>

pageScope의 속성값은 : ${pageScope.scopeName}<br>
requestScope의 속성값은 : ${requestScope.scopeName}<br>
sessionScope의 속성값은 : ${sessionScope.scopeName}<br>
applicationScope의 속성값은 : ${applicationScope.scopeName}<br>
scopeName 자동 찾기: ${scopeName}<br>
member: ${member.name}(${member.userid})<br>
member: ${member.name}(${member.userid})<br>
<%--    객체 주의점 -> 필드로 직접 접근 안했음 (getter)
                     member.getName();
                     member.getUserId();      --%>
</body>
</html>
