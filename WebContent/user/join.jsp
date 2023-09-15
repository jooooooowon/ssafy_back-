<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../header/header.jsp"%>
    <form method="post" action="/backProject/user">
        <input type="hidden" name="action" value="doJoin">
        <input type="text" name="id" placeholder="아이디" required>
        <input type="password" name="pwd" placeholder="비밀번호" required>
        <input type="text" name="name" placeholder="이름" required>
        <input type="submit" value="가입하기">
    </form>
</body>
</html>