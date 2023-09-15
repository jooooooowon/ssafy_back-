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

	<table>
		<tr>
			<th>title</th>
			<th>content</th>
			<th>writer</th>
			<th>date</th>
		</tr>
		<tr>
			<td>${board.title }</td>
			<td>${board.content }</td>
			<td>${board.writer }</td>
			<td>${board.date }</td>
		</tr>
	</table>
    <c:if test = "${not empty btns }">
        <input type = "button" value = "수정하기" onclick = "location.href='board?action=updatePage&num=${board.num}'">
        <input type = "button" value = "삭제하기" onclick = "location.href='board?action=delete&num=${board.num}'">
    </c:if>
</body>
</html>