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
    <c:if test="${not empty sessionScope.loginUser }">
        <a href = "board/regist.jsp">글 작성하기.</a>
    </c:if>
    
	<c:if test="${empty list }">
		<h1>게시물 없음.</h1>
	</c:if>
	<c:if test="${not empty list }">
		<c:forEach var="board" items="${list }">
			<table>
				<tr>
					<th><a href="board?action=detail&num=${board.num }"> title </a></th>
					<th>writer</th>
					<th>date</th>
				</tr>
				<tr>
					<td>${board.title }</td>
					<td>${board.writer.name }</td>
					<td>${board.date }</td>
				</tr>
			</table>
		</c:forEach>
	</c:if>
</body>
</html>