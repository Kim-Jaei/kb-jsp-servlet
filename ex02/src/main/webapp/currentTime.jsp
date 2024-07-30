<%--
  Created by IntelliJ IDEA.
  User: ehddn
  Date: 2024-07-29
  Time: 오전 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>스크립트 실습</title>
</head>
<%--head까지는 ultimate 버전이기 때문에 무시(?)해도 됨--%>
<body>
    <h1>현재 날짜 출력 실습</h1>
<%
    Date d = new Date();

    int sum = 0;
    for(int i=0; i<10; i++){
        sum = sum + i;
    }

    Date d2 = null;
%>
현재 날짜 : <%= d%> <br>
1~10의 합 : <%= sum%> <br>

<% if(d2!=null) { %>
    <%=d2%>
<%}%>
</body>
</html>
