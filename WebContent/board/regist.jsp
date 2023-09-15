<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%@ include file="../header/header.jsp"%>
    <form method="post" action="/backProject/board">
        <input type="hidden" name="action" value="regist">
        <input type="text" name="title" placeholder="title" required>
        <input type="text" name="content" placeholder="content" required>
        <input type="submit" value="작성하기">
    </form>
</body>
</html>