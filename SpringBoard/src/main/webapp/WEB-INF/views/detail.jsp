<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${param.board_id}글</title>
</head>
<body>
	<div>제목</div>
	<input type="text" value="${board.board_title}" />
	<div>내용</div>
	<input type="text" value="${board.board_content}" style="width: 300px; height: 300px;" />
	<div>작성자</div>
	<input type="text" value="${board.writer}" readonly />

	
</body>
</html>