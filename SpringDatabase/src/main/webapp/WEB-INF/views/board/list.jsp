<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지${page}</title>
</head>
<body>
	
	<div style="display:grid; grid-template-columns:1fr 4fr 1fr 1fr">
		<div style="grid-template-column:1/2;">글 번호</div>
		<div style="grid-template-column:2/3;">제목</div>
		<div style="grid-template-column:3/4;">글쓴이</div>
		<div style="grid-template-column:4/5;">조회수</div>
	<c:forEach items="${board2}" var="board">
		<div style="grid-template-column:1/2;">${board.board_id}</div>
		<div style="grid-template-column:2/3;">${board.board_title}</div>
		<div style="grid-template-column:3/4;">${board.writer}</div>
		<div style="grid-template-column:4/5;">${board.board_view}</div>
	</c:forEach>
	</div>
</body>
</html>