<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
게시글 수정<br />
<form action = "boardModify.miso" method="post">
번호 : <input type = "text" name="boardNum" value="${dto.boardNum }"/><br />
글쓴이 : <input type = "text" name="boardWriter" value="${dto.boardWriter }"/><br />
제목 : <input type = "text" name="boardSubject" value="${dto.boardSubject }"/><br />
내용 : <textarea rows="10" cols="50" name="boardContent" >${dto.boardContent }/</textarea><br />
<input type = "submit" value="글수정하기">
</form>
</body>
</html>