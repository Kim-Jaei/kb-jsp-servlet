<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<hr>
<c:if test="${empty user}">
    <a href="/login_form.jsp">로그인</a> | <a href="#">회원가입</a>
</c:if>
<c:if test="${!empty user}">
    ${user.name} | <a href="/logout">로그아웃</a>
</c:if>
<hr>
