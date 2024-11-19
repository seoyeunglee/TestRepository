<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employeeDrop.jsp</title>
</head>
<body>
<form action="empDropOk.my" method="post">
		비밀번호 확인 : <input type="password" name="empPw" id="empPw" />
		<input type="submit" value="회원탈퇴" />
		<div style="color: red">${errPw }</div>
	</form>
</body>
</html>