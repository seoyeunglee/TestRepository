<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardForm.jsp</title>
</head>
<body>
글쓰기 <br />
<form action = "boardWrite.miso" method="post">
글쓴이 : <input type = "text" name="boardWriter"><br />
제목 : <input type = "text" name="boardSubject"><br />
내용 : <textarea rows="10" cols="50" name="boardContent"></textarea><br />
<input type = "submit" value="글저장">
</form>
</body>
</html>