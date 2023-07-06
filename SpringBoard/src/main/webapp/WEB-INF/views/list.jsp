<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	
	<h3>${param.page}페이지</h3>
	<div>
		<c:forEach items="${boards}" var="board">
			<div>${board.board_id}</div>
			<div><a href="./detail?board_id=${board.board_id}">${board.board_title}</a></div>
			<div>${board.writer}</div>
			<div>${board.board_view}</div>
		</c:forEach>
	</div>
	
</body>
</html>