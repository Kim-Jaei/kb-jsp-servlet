<%--
  Created by IntelliJ IDEA.
  User: ehddn
  Date: 2024-07-29
  Time: 오전 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>로그인 정보 세션 저장</h1>
<%
    String id = request.getParameter("userid");
    if(id==null || id.equals("")){
        response.sendRedirect("loginForm.jsp");
    }else{
        String pw = request.getParameter("password");
        session.setAttribute("userid", id);
        session.setAttribute("password", pw);
        out.print("안녕하세요" + id);
        out.print("<a href='loginInfo.jsp'>정보보기</a>");
    }
%>
</body>
</html>
