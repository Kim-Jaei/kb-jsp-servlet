<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>상품 리스트</h1>
<%--이 화면에서 '카트 저장' 버튼을 누르면 선택한 데이터가 get 방식으로 전송됨--%>
<%--사용자가 선택을 하고 제출 버튼을 누르면 데이터가 url의 쿼리 스트링으로 cart_save 액션에 전송됨--%>
<form action="cart_save" method="GET">
    <input type="radio" name="product" value="BMW"> BMW<br/>
    <input type="radio" name="product" value="SM5"> SM5<br/>
    <input type="radio" name="product" value="K7"> K7<br/>
    <input type="submit" value="카트 저장">
</form>
</body>
</html>
